package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.repository.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository repository;
	
	public List<Promocao> findAll() {
		
		List<Promocao> lista = repository.findAll();
		return lista;
	}
		
	public Promocao findById(Integer id) {
		
		Optional<Promocao> promocao = repository.findById(id);
		return promocao.orElseThrow(() -> new ObjectNotFoundException(id, "Promocao"));
	}
	
	public List<Promocao> findByIdDestino(Integer idDestino) {
		
		List<Promocao> lista = repository.findByIdDestino(idDestino);
		return lista;
	}
	
	public Promocao create(Promocao novo) {
		
		return repository.save(novo);
	}
	
	public Promocao update(Promocao novo) {
		
		Promocao atual = findById(novo.getId());
		atual.setNome(novo.getNome());
		atual.setDataInicio(novo.getDataInicio());
		atual.setDataTermino(novo.getDataTermino());
		atual.setDesconto(novo.getDesconto());
		atual.setDestino(novo.getDestino());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
