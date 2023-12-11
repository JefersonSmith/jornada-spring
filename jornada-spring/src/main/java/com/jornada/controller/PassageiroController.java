package com.jornada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jornada.model.Passageiro;
import com.jornada.service.PassageiroService;

@Controller
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;
    
    @GetMapping("/login")
    public String loginPage(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("mensagemErro", "Usuário ou senha inválidos");
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String senha, Model model) {
        Passageiro passageiro = passageiroService.login(usuario, senha);

        if (passageiro != null) {
            return "redirect:/listarPassageiros";
        } else {
            model.addAttribute("mensagemErro", "Usuário ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/cadastrarPassageiro")
    public ModelAndView cadastrarPassageiro() {
        ModelAndView modelAndView = new ModelAndView("cadastrarPassageiro");

        modelAndView.addObject("passageiro", new Passageiro());

        return modelAndView;
    }

    @PostMapping("/cadastrarPassageiro")
    public ModelAndView cadastrarPassageiro(Passageiro passageiro) {
        ModelAndView modelAndView = new ModelAndView("redirect:/sucesso");

        passageiroService.salvarPassageiro(passageiro);

        return modelAndView;
    }

    @GetMapping("/{id}/editarPassageiro")
    public ModelAndView editarPassageiro(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("editarPassageiro");

        Passageiro passageiro = passageiroService.obterPassageiroPorId(id);
        modelAndView.addObject("passageiro", passageiro);

        return modelAndView;
    }

    @PostMapping("/{id}/editarPassageiro")
    public ModelAndView editarPassageiro(Passageiro passageiro) {
        passageiroService.salvarPassageiro(passageiro);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarPassageiros");

        return modelAndView;
    }

    @GetMapping("/{id}/excluirPassageiro")
    public ModelAndView excluirPassageiro(@PathVariable Long id) {
        try {
            passageiroService.excluirPassageiro(id);
            return new ModelAndView("redirect:/listarPassageiros");
        } catch (DataIntegrityViolationException e) {
            ModelAndView modelAndView = new ModelAndView("erroExclusaoPassageiro");
            modelAndView.addObject("mensagem", "Não é possível excluir o passageiro. Ele está vinculado a uma ou mais viagens.");
            return modelAndView;
        }
    }

    @RequestMapping("/listarPassageiros")
    @GetMapping
    public ModelAndView listarPassageiros() {
        ModelAndView modelAndView = new ModelAndView("listarPassageiros");

        List<Passageiro> passageiros = passageiroService.listarPassageiros();
        modelAndView.addObject("passageiros", passageiros);

        return modelAndView;
    }
}
