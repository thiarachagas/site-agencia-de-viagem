package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Pedido;
import br.com.dreamtravel.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll() {
		
		List<Pedido> lista = repository.findAll();
		return lista;
	}
	
	public Pedido findById(Integer id) {
		
		Optional<Pedido> promocao = repository.findById(id);
		return promocao.orElseThrow(() -> new ObjectNotFoundException(id, "Promocao"));
	}
	
	public Pedido create(Pedido novo) {
		
		return repository.save(novo);
	}
	
	public Pedido update(Pedido novo) {
		
		Pedido atual = findById(novo.getId());
		atual.setDataCompra(novo.getDataCompra());
		atual.setHoraCompra(novo.getHoraCompra());
		atual.setPrecoCompra(novo.getPrecoCompra());
		atual.setCliente(novo.getCliente());
		atual.setPassagem(novo.getPassagem());
		atual.setFormaPagamento(novo.getFormaPagamento());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
