package projetojpaAvaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetojpaAvaliacao.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
