package br.com.dreamtravel.controller.admin;

import java.util.ArrayList;
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
import br.com.dreamtravel.model.Destino;
import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.service.CompanhiaAereaService;
import br.com.dreamtravel.service.DestinoService;
import br.com.dreamtravel.service.PassagemService;
import br.com.dreamtravel.service.PromocaoService;

@Controller
@RequestMapping("/admin/passagem")
public class PassagemController {

	private String nome = "passagem";
	
	@Autowired
	private PassagemService service;
	
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private PromocaoService promocaoService;
	
	@Autowired
	private CompanhiaAereaService companhiaAereaService;

	@GetMapping
	public ModelAndView lista() {
		
		List<Passagem> lista = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/lista");
		mav.addObject("lista", lista);
		return mav;
	}
	
	@GetMapping("/novo")
	public ModelAndView formularioCriar() {
		
		List<Destino> destinos = destinoService.findAll();
		List<Promocao> promocoes = new ArrayList<>();
		
		if (destinos.size() > 0) {
			promocoes = promocaoService.findByIdDestino(destinos.get(0).getId());
		}
		
		List<CompanhiaAerea> companhiasAereas = companhiaAereaService.findAll();
		
		Passagem item = new Passagem();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "POST");
		mav.addObject("item", item);
		mav.addObject("destinos", destinos);
		mav.addObject("promocoes", promocoes);
		mav.addObject("companhiasAereas", companhiasAereas);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView formularioEditar(@PathVariable Integer id) {
		
		Passagem item = service.findById(id);
		List<Destino> destinos = destinoService.findAll();
		List<Promocao> promocoes = new ArrayList<>();
		
		if (destinos.size() > 0) {
			promocoes = promocaoService.findByIdDestino(item.getDestino().getId());
		}
		
		List<CompanhiaAerea> companhiasAereas = companhiaAereaService.findAll();
		
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "PUT");
		mav.addObject("item", item);
		mav.addObject("destinos", destinos);
		mav.addObject("promocoes", promocoes);
		mav.addObject("companhiasAereas", companhiasAereas);
		return mav;
	}
	
	@PostMapping
	public String create(Passagem novo) {
		
		service.create(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@PutMapping
	public String update(Passagem novo) {
		
		service.update(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		
		service.delete(id);
		return "redirect:/admin/" + nome;
	}
}
