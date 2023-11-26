package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Destino;
import br.com.dreamtravel.repository.DestinoRepository;

@Service
public class DestinoService {
	
	@Autowired
	private DestinoRepository repository;
	
	
	public List<Destino> findAll() {
		
		List<Destino> lista = repository.findAll();
		return lista;
	}
	
	public Destino findById(Integer id) {
		
		Optional<Destino> destino = repository.findById(id);
		return destino.orElseThrow(() -> new ObjectNotFoundException(id, "Destino"));
	}
	
	public Destino create(Destino novo) {
		
		return repository.save(novo);
	}
	
	public Destino update(Destino novo) {
		
		Destino atual = findById(novo.getId());
		atual.setNome(novo.getNome());
		atual.setLocalizacao(novo.getLocalizacao());
		atual.setPrecoMedio(novo.getPrecoMedio());
		
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
