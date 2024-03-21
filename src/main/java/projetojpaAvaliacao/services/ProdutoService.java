package projetojpaAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetojpaAvaliacao.entities.Produto;
import projetojpaAvaliacao.repository.ProdutoRepository;  
 

 
@Service  
public class ProdutoService {  
	private final ProdutoRepository produtoRepository;    
	@Autowired    
	public ProdutoService(ProdutoRepository produtoRepository) {    
		this.produtoRepository = produtoRepository;    
	}   
	public List<Produto> buscaTodosProdutos() {    
		return produtoRepository.findAll();   
	}   
	public Produto buscaProdutoId(Long id) {    
		Optional <Produto> produto = produtoRepository.findById(id);   
		return produto.orElse(null);   
	}   
	public Produto salvaProduto(Produto produto) {    
		return produtoRepository.save(produto);    
	}   
	public Produto alterarProduto(Long id, Produto alterarUser) {    
		Optional <Produto> existeProduto = produtoRepository.findById(id);    
		if (existeProduto.isPresent()) {    
			alterarUser.setId(id);    
			return produtoRepository.save(alterarUser);    
		}   
		return null;    
	}   
	public boolean apagarProduto(Long id) {   
		Optional <Produto> existeProduto = produtoRepository.findById(id);    
		if (existeProduto.isPresent()) {    
			produtoRepository.deleteById(id);    
			return true;    
		}   
		return false;    
	}  
} 
