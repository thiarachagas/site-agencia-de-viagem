package br.com.dreamtravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dreamtravel.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
