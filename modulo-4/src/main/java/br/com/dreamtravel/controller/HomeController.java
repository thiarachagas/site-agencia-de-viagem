package br.com.dreamtravel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.model.form.FiltroFormHome;
import br.com.dreamtravel.service.PassagemService;
import br.com.dreamtravel.service.PromocaoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private PassagemService passagemService;
	
	@GetMapping
	public ModelAndView homePage() {
		
		FiltroFormHome form = new FiltroFormHome();
		List<Passagem> lista = passagemService.findAll();
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("form", form);
		mav.addObject("passagens", lista);
		return mav;
	}
	
	@PostMapping
	public ModelAndView homePageFiltrada(FiltroFormHome form) {
		
		List<Passagem> lista = passagemService.findAllByForm(form);
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("form", form);
		mav.addObject("passagens", lista);
		return mav;
	}
	
	@GetMapping("/sobre-nos")
	public String sobreNos() {
		return "/sobre-nos";
	}
	
	@GetMapping("/central-de-ajuda")
	public String centralDeAjuda() {
		return "/central-de-ajuda";
	}
	
	@GetMapping("/duvidas")
	public String duvidas() {
		return "/duvidas";
	}
}
