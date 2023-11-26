package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.repository.PassagemRepository;

@Service
public class PassagemService {


	@Autowired
	private PassagemRepository repository;
	
	public List<Passagem> findAll() {
		
		List<Passagem> lista = repository.findAll();
		return lista;
	}
	
	public Passagem findById(Integer id) {
		
		Optional<Passagem> item = repository.findById(id);
		return item.orElseThrow(() -> new ObjectNotFoundException(id, "CompanhiaAerea"));
	}
	
	public Passagem create(Passagem novo) {
		
		return repository.save(novo);
	}
	
	public Passagem update(Passagem novo) {
		
		Passagem atual = findById(novo.getId());
		atual.setOrigem(novo.getOrigem());
		atual.setDataPartida(novo.getDataPartida());
		atual.setDestino(novo.getDestino());
		atual.setPromocao(novo.getPromocao());
		atual.setCompanhiaAerea(novo.getCompanhiaAerea());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
