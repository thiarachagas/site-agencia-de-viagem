package br.com.dreamtravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dreamtravel.model.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}
