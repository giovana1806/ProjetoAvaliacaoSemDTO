package projetojpaAvaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetojpaAvaliacao.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
