package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.CompanhiaAerea;
import br.com.dreamtravel.repository.CompanhiaAereaRepository;

@Service
public class CompanhiaAereaService {

	@Autowired
	private CompanhiaAereaRepository repository;
	
	public List<CompanhiaAerea> findAll() {
		
		List<CompanhiaAerea> lista = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return lista;
	}
	
	public CompanhiaAerea findById(Integer id) {
		
		Optional<CompanhiaAerea> item = repository.findById(id);
		return item.orElseThrow(() -> new ObjectNotFoundException(id, "CompanhiaAerea"));
	}
	
	public CompanhiaAerea create(CompanhiaAerea novo) {
		
		return repository.save(novo);
	}
	
	public CompanhiaAerea update(CompanhiaAerea novo) {
		
		CompanhiaAerea atual = findById(novo.getId());
		atual.setNome(novo.getNome());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
