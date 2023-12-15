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

import br.com.dreamtravel.model.CompanhiaAerea;
import br.com.dreamtravel.service.CompanhiaAereaService;

@RequestMapping("/admin/companhia-aerea")
@Controller
public class CompanhiaAereaController {
	
	private String nome = "companhia-aerea";
	
	@Autowired
	private CompanhiaAereaService service;

	@GetMapping
	public ModelAndView lista() {
		
		List<CompanhiaAerea> lista = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/lista");
		mav.addObject("lista", lista);
		return mav;
	}
	
	@GetMapping("/novo")
	public ModelAndView formularioCriar() {
		
		CompanhiaAerea item = new CompanhiaAerea();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "POST");
		mav.addObject("item", item);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView formularioEditar(@PathVariable Integer id) {
		
		CompanhiaAerea item = service.findById(id);
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "PUT");
		mav.addObject("item", item);
		return mav;
	}
	
	@PostMapping
	public String create(CompanhiaAerea novo) {
		
		service.create(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@PutMapping
	public String update(CompanhiaAerea novo) {
		
		service.update(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		
		service.delete(id);
		return "redirect:/admin/" + nome;
	}
}
