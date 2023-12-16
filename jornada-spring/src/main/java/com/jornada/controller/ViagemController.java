package com.jornada.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jornada.model.Destino;
import com.jornada.model.Passageiro;
import com.jornada.model.Viagem;
import com.jornada.service.DestinoService;
import com.jornada.service.PassageiroService;
import com.jornada.service.ViagemService;

@Controller
public class ViagemController {

	@Autowired
	private ViagemService viagemService;

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private PassageiroService passageiroService;

	@GetMapping("/cadastrarViagem")
	public ModelAndView cadastrarViagem() {
		ModelAndView modelAndView = new ModelAndView("cadastrarViagem");

		List<Destino> destinos = destinoService.listarDestinos();
		List<Passageiro> passageiros = passageiroService.listarPassageiros();

		modelAndView.addObject("destinos", destinos);
		modelAndView.addObject("passageiros", passageiros);
		modelAndView.addObject("viagem", new Viagem());

		return modelAndView;
	}

	@PostMapping("/cadastrarViagem")
	public ModelAndView cadastrarViagem(Viagem viagem, @RequestParam("idDestino") Long idDestino,
			@RequestParam("idPassageiro") Long idPassageiro,
			@RequestParam("dataHoraIda") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraIda,
			@RequestParam("dataHoraVolta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraVolta) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarViagens");

		Destino destino = destinoService.obterDestinoPorId(idDestino);
		Passageiro passageiro = passageiroService.obterPassageiroPorId(idPassageiro);

		viagem.setDestino(destino);
		viagem.setPassageiro(passageiro);
		viagem.setDataHoraIda(dataHoraIda);
		viagem.setDataHoraVolta(dataHoraVolta);

		viagemService.salvarViagem(viagem);

		return modelAndView;
	}

	@GetMapping("/{id}/editarViagem")
	public ModelAndView editarViagem(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("editarViagem");

		Viagem viagem = viagemService.obterViagemPorId(id);
		List<Destino> destinos = destinoService.listarDestinos();
		List<Passageiro> passageiros = passageiroService.listarPassageiros();

		modelAndView.addObject("viagem", viagem);
		modelAndView.addObject("destinos", destinos);
		modelAndView.addObject("passageiros", passageiros);

		return modelAndView;
	}

	@PostMapping("/{id}/editarViagem")
	public ModelAndView editarViagem(Viagem viagem) { 
		viagemService.salvarViagem(viagem);
        ModelAndView modelAndView = new ModelAndView("redirect:/listarViagens");

		return modelAndView;
	}

	@GetMapping("/{id}/excluirViagem")
	public ModelAndView excluirViagem(@PathVariable Long id) {
		viagemService.excluirViagem(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/listarViagens");

		return modelAndView;
	}

	@RequestMapping("/listarViagens")
	@GetMapping
	public ModelAndView listarViagens() {
		ModelAndView modelAndView = new ModelAndView("listarViagens");

		List<Viagem> viagens = viagemService.listarViagens();
		modelAndView.addObject("viagens", viagens);

		return modelAndView;
	}
}
