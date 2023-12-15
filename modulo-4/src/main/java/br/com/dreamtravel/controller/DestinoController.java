package br.com.dreamtravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Destino;
import br.com.dreamtravel.service.DestinoService;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoService service;
	
	@GetMapping
	public ModelAndView destinos() {
		
		List<Destino> destinosNacionais = service.findAllByInternacional(false);
		List<Destino> destinosInternacionais = service.findAllByInternacional(true);
		
		ModelAndView mav = new ModelAndView("/destino");
		mav.addObject("destinosNacionais", destinosNacionais);
		mav.addObject("destinosInternacionais", destinosInternacionais);
		
		return mav;
	}
}
