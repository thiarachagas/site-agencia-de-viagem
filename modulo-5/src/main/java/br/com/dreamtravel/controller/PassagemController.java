package br.com.dreamtravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.FormaPagamento;
import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.model.Pedido;
import br.com.dreamtravel.service.FormaPagamentoService;
import br.com.dreamtravel.service.PassagemService;

@Controller
@RequestMapping("/passagem")
public class PassagemController {

	@Autowired
	private PassagemService service;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@GetMapping
	public ModelAndView passagens(
			@RequestParam(required = false, name = "idDestino") Integer idDestino,
			@RequestParam(required = false, name = "idPromocao") Integer idPromocao) {
		
		List<Passagem> passagens = service.findAllByDestinoIdAndPromocaoId(idDestino, idPromocao);
		ModelAndView mav = new ModelAndView("/passagem");
		mav.addObject("passagens", passagens);
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView passagem(@PathVariable Integer id) {
		
		Pedido pedido = new Pedido();
		Passagem passagem = service.findById(id);
		pedido.setPassagem(passagem);
		List<FormaPagamento> formasPagamento = formaPagamentoService.findAll();
		ModelAndView mav = new ModelAndView("/passagem-detalhe");
		mav.addObject("pedido", pedido);
		mav.addObject("formasPagamento", formasPagamento);
		
		return mav;
	}
}
