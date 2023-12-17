package br.com.dreamtravel.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dreamtravel.model.Cliente;
import br.com.dreamtravel.model.ClienteParaForm;
import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.model.Pedido;
import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.service.ClienteService;
import br.com.dreamtravel.service.PassagemService;
import br.com.dreamtravel.service.PedidoService;
import br.com.dreamtravel.service.PromocaoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private PassagemService passagemService;
	
	@Autowired
	private PromocaoService promocaoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public String processaPedido(Pedido pedido) {
		
		try {
			Cliente cliente = clienteService.findById(pedido.getCliente().getCpf());
			pedido.setCliente(cliente);					
		}
		catch (org.hibernate.ObjectNotFoundException e) {
		}
		
		Passagem passagem = passagemService.findById(pedido.getPassagem().getId());
		pedido.setPassagem(passagem);
		pedido.setDataCompra(LocalDate.now());
		pedido.setHoraCompra(LocalTime.now());
		double precoCompra = pedido.calculaPrecoCompra();
		pedido.setPrecoCompra(precoCompra);
		
		service.create(pedido);		
		
		return "redirect:/passagem";
	}
	
	@GetMapping("/cliente/{cpf}")
	public ResponseEntity<ClienteParaForm> buscaCliente(@PathVariable String cpf) {
		
		Cliente cliente = clienteService.findById(cpf);
		ClienteParaForm c = new ClienteParaForm(cliente);
		
		return ResponseEntity.ok().body(c);
	}
}
