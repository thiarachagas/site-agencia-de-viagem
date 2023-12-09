package br.com.dreamtravel.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Passagem;
import br.com.dreamtravel.model.Promocao;
import br.com.dreamtravel.model.form.FiltroFormHome;
import br.com.dreamtravel.repository.PassagemRepository;
import br.com.dreamtravel.specification.PassagemSpec;

@Service
public class PassagemService {


	@Autowired
	private PassagemRepository repository;
	
	public List<Passagem> findAll() {
		
		List<Passagem> lista = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return lista;
	}
	
	public List<Passagem> findAllByForm(FiltroFormHome form) {
		
		Specification<Passagem> origemSpec = PassagemSpec.origemVazioOuIgual(form.getOrigem());
		Specification<Passagem> destinoSpec = PassagemSpec.destinoVazioOuIgual(form.getDestino());
		Specification<Passagem> dataPartidaInferiorSpec = PassagemSpec.dataPartidaVazioOuMaiorIgual(
				form.getDataInicio());
		Specification<Passagem> dataPartidaSuperiorSpec = PassagemSpec.dataPartidaVazioOuMenorIgual(
				form.getDataTermino());
				
		List<Passagem> lista = repository.findAll(
				origemSpec.and(
						destinoSpec.and(
								dataPartidaInferiorSpec.and(dataPartidaSuperiorSpec)
						)
				)
			);
		
		return lista;
	}
	
	public List<Passagem> findAllByDestinoIdAndPromocaoId(Integer idDestino, Integer idPromocao) {
		
		Specification<Passagem> spec1 = PassagemSpec.idDestinoVazioOuIgual(idDestino);
		Specification<Passagem> spec2 = PassagemSpec.idPromocaoVazioOuIgual(idPromocao);
		Specification<Passagem> spec = spec1.and(spec2);
		return repository.findAll(spec);
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
