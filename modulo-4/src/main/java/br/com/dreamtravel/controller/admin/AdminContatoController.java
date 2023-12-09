package br.com.dreamtravel.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Contato;
import br.com.dreamtravel.service.ContatoService;

@Controller
@RequestMapping("/admin/contato")
public class AdminContatoController {

	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ModelAndView lista() {
		
		List<Contato> lista = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/contato/lista");
		mav.addObject("lista", lista);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhe(@PathVariable Integer id) {
		
		Contato item = service.findById(id);
		ModelAndView mav = new ModelAndView("/admin/contato/detalhe");
		mav.addObject("item", item);
		return mav;
	}
}
