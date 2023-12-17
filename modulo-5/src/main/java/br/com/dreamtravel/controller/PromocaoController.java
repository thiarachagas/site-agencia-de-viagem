package br.com.dreamtravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.service.PromocaoService;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

	@Autowired
	private PromocaoService service;
	
	@GetMapping
	public ModelAndView promocoes() {
		
		List<Promocao> promocoes = service.findAll();
		ModelAndView mav = new ModelAndView("/promocao");
		mav.addObject("promocoes", promocoes);
		
		return mav;
	}
}
