package br.com.dreamtravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Contato;
import br.com.dreamtravel.service.ContatoService;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	private String nome = "contato";
	
	@Autowired
	private ContatoService service;

	@GetMapping
	public ModelAndView contato() {
		
		Contato contato = new Contato();
		ModelAndView mav = new ModelAndView("/contato");
		mav.addObject("contato", contato);
		return mav;
	}
	
	@PostMapping
	public String processaContato(Contato novo) {
		
		service.create(novo);
		return "redirect:/"+ nome;
	}
}
