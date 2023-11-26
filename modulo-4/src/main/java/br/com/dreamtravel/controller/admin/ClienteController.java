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

import br.com.dreamtravel.model.Cliente;
import br.com.dreamtravel.service.ClienteService;

@Controller
@RequestMapping("/admin/cliente")
public class ClienteController {

	private String nome = "cliente";
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public ModelAndView lista() {
		
		List<Cliente> lista = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/lista");
		mav.addObject("lista", lista);
		return mav;
	}
	
	@GetMapping("/novo")
	public ModelAndView formularioCriar() {
		
		Cliente item = new Cliente();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "POST");
		mav.addObject("readonlyId", false);
		mav.addObject("item", item);
		return mav;
	}
	
	@GetMapping("/{cpf}")
	public ModelAndView formularioEditar(@PathVariable String cpf) {
		
		Cliente item = service.findById(cpf);
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "PUT");
		mav.addObject("readonlyId", true);
		mav.addObject("item", item);
		return mav;
	}
	
	@PostMapping
	public String create(Cliente novo) {
		
		service.create(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@PutMapping
	public String update(Cliente novo) {
		
		service.update(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@DeleteMapping("/{cpf}")
	public String delete(@PathVariable String cpf) {
		
		System.out.println(cpf);
		
		service.delete(cpf);
		return "redirect:/admin/" + nome;
	}
}
