package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.FormaPagamento;
import br.com.dreamtravel.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository repository;
	
	public List<FormaPagamento> findAll() {
		
		List<FormaPagamento> lista = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return lista;
	}
	
	public FormaPagamento findById(Integer id) {
		
		Optional<FormaPagamento> item = repository.findById(id);
		return item.orElseThrow(() -> new ObjectNotFoundException(id, "FormaPagamento"));
	}
	
	public FormaPagamento create(FormaPagamento novo) {
		
		return repository.save(novo);
	}
	
	public FormaPagamento update(FormaPagamento novo) {
		
		FormaPagamento atual = findById(novo.getId());
		atual.setNome(novo.getNome());
		return repository.save(atual);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
