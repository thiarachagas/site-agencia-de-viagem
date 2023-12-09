package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Contato;
import br.com.dreamtravel.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll() {
		
		List<Contato> lista = repository.findAll();
		return lista;
	}
	
	public Contato findById(Integer id) {
		
		Optional<Contato> item = repository.findById(id);
		return item.orElseThrow(() -> new ObjectNotFoundException((Object) id, "Contato"));
	}
	
	public Contato create(Contato novo) {
		
		return repository.save(novo);
	}
	
	public Contato update(Contato novo) {
		
		Contato atual = findById(novo.getId());
		atual.setNome(novo.getNome());
		atual.setEmail(novo.getEmail());
		atual.setMensagem(novo.getMensagem());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
