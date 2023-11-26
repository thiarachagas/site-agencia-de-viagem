package br.com.dreamtravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dreamtravel.model.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

	@Query("SELECT p FROM Promocao p WHERE p.destino.id = :idDestino")
	public List<Promocao> findByIdDestino(Integer idDestino);
}
