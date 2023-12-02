package com.jornada.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jornada.model.Destino;
import com.jornada.service.DestinoService;

@Controller
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping("/cadastrarDestino")
    public ModelAndView cadastrarDestino() {
        ModelAndView modelAndView = new ModelAndView("cadastrarDestino");

        modelAndView.addObject("destino", new Destino());

        return modelAndView;
    }

    @PostMapping("/cadastrarDestino")
    public ModelAndView cadastrarDestino(Destino destino) {
        ModelAndView modelAndView = new ModelAndView("redirect:/sucesso");

        destinoService.salvarDestino(destino);

        return modelAndView;
    }

    @GetMapping("/{id}/editarDestino")
    public ModelAndView editarDestino(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("editarDestino");

        Destino destino = destinoService.obterDestinoPorId(id);
        modelAndView.addObject("destino", destino);

        return modelAndView;
    }

    @PostMapping("/{id}/editarDestino")
    public ModelAndView editarDestino(Destino destino) {
        destinoService.salvarDestino(destino);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarDestinos");

        return modelAndView;
    }

    @GetMapping("/{id}/excluirDestino")
    public ModelAndView excluirDestino(@PathVariable Long id) {
        destinoService.excluirDestino(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarDestinos");

        return modelAndView;
    }

    @RequestMapping("/listarDestinos")
    @GetMapping
    public ModelAndView listarDestinos() {
        ModelAndView modelAndView = new ModelAndView("listarDestinos");

        List<Destino> destinos = destinoService.listarDestinos();
        modelAndView.addObject("destinos", destinos);

        return modelAndView;
    }
}
