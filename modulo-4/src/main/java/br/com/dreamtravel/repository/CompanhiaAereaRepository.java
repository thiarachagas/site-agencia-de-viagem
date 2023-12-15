package br.com.dreamtravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dreamtravel.model.CompanhiaAerea;

@Repository
public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Integer> {

}
