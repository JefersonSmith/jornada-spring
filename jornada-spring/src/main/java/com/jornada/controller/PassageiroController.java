package com.jornada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jornada.model.Passageiro;
import com.jornada.service.PassageiroService;

import java.util.List;

@Controller
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

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
        passageiroService.excluirPassageiro(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarPassageiros");

        return modelAndView;
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
