package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Cliente;
import br.com.dreamtravel.repository.ClienteRepository;

@Service
public class ClienteService {


	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		
		List<Cliente> lista = repository.findAll();
		return lista;
	}
	
	public Cliente findById(String cpf) {
		
		Optional<Cliente> item = repository.findById(cpf);
		return item.orElseThrow(() -> new ObjectNotFoundException((Object) cpf, "Cliente"));
	}
	
	public Cliente create(Cliente novo) {
		
		return repository.save(novo);
	}
	
	public Cliente update(Cliente novo) {
		
		Cliente atual = findById(novo.getCpf());
		atual.setEmail(novo.getEmail());
		atual.setTel(novo.getTel());
		atual.setNome(novo.getNome());
		atual.setSenha(novo.getSenha());
		return repository.save(atual);
	}
	
	public void delete(String cpf) {
		repository.deleteById(cpf);
	}
}
