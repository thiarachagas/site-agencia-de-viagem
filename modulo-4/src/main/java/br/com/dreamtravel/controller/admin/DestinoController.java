package br.com.dreamtravel.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Destino;
import br.com.dreamtravel.service.DestinoService;

@RequestMapping("/admin/destino")
@Controller
public class DestinoController {
	
	private String nome = "destino";
	
	@Autowired
	private DestinoService service;

	@GetMapping
	public ModelAndView lista() {
		
		List<Destino> destinos = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/lista");
		mav.addObject("lista", destinos);
		return mav;
	}
	
	@GetMapping("/novo")
	public ModelAndView formularioCriar() {
		
		Destino item = new Destino();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "POST");
		mav.addObject("item", item);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView formularioEditar(@PathVariable Integer id) {
		
		Destino item = service.findById(id);
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "PUT");
		mav.addObject("item", item);
		return mav;
	}
	
	@PostMapping
	public String create(Destino item) {
		
		service.create(item);
		return "redirect:/admin/"+ nome;
	}
	
	@PutMapping
	public String update(Destino item) {
		
		service.update(item);
		return "redirect:/admin/"+ nome;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		
		service.delete(id);
		return "redirect:/admin/" + nome;
	}
}
