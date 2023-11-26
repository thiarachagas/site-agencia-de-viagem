package br.com.dreamtravel.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Destino;
import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.service.DestinoService;
import br.com.dreamtravel.service.PromocaoService;

@RequestMapping("/admin/promocao")
@Controller
public class PromocaoController {
	
	private String nome = "promocao";
	
	@Autowired
	private PromocaoService service;
	
	@Autowired
	private DestinoService destinoService;

	@GetMapping
	public ModelAndView lista() {
		
		List<Promocao> lista = service.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/lista");
		mav.addObject("lista", lista);
		return mav;
	}
	
	@GetMapping("/novo")
	public ModelAndView formularioCriar() {
		
		Promocao item = new Promocao();
		List<Destino> destinos = destinoService.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "POST");
		mav.addObject("item", item);
		mav.addObject("destinos", destinos);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView formularioEditar(@PathVariable Integer id) {
		
		Promocao item = service.findById(id);
		List<Destino> destinos = destinoService.findAll();
		ModelAndView mav = new ModelAndView("/admin/"+ nome +"/formulario");
		mav.addObject("method", "PUT");
		mav.addObject("item", item);
		mav.addObject("destinos", destinos);
		return mav;
	}
	
	@GetMapping("/destino/{idDestino}")
	public ResponseEntity<List<Promocao>> buscaPromocoesPorDestino(
			@PathVariable Integer idDestino) {
		
		List<Promocao> promocoes = service.findByIdDestino(idDestino);
		
		return ResponseEntity.ok().body(promocoes);
	}
	
	@PostMapping
	public String create(Promocao novo) {
		
		System.out.println(novo);
		
		service.create(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@PutMapping
	public String update(Promocao novo) {
		
		service.update(novo);
		return "redirect:/admin/"+ nome;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		
		service.delete(id);
		return "redirect:/admin/" + nome;
	}
}
