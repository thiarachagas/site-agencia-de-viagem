package br.com.dreamtravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dreamtravel.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

	List<Destino> findAllByInternacional(Boolean internacional);
}
