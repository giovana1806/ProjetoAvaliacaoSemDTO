package projetojpaAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetojpaAvaliacao.entities.Fornecedor;
import projetojpaAvaliacao.repository.FornecedorRepository;  
  
@Service  
public class FornecedorService {  
	private final FornecedorRepository fornecedorRepository;    
	@Autowired    
	public FornecedorService(FornecedorRepository fornecedorRepository) {    
		this.fornecedorRepository = fornecedorRepository;    
	}   
	public List<Fornecedor> buscaTodosFornecedors() {    
		return fornecedorRepository.findAll();   
	}   
	public Fornecedor buscaFornecedorId(Long id) {    
		Optional <Fornecedor> fornecedor = fornecedorRepository.findById(id);   
		return fornecedor.orElse(null);   
	}   
	public Fornecedor salvaFornecedor(Fornecedor fornecedor) {    
		return fornecedorRepository.save(fornecedor);    
	}   
	public Fornecedor alterarFornecedor(Long id, Fornecedor alterarUser) {    
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);    
		if (existeFornecedor.isPresent()) {   
			alterarUser.setId(id);   
			return fornecedorRepository.save(alterarUser);    
		}   
		return null;    
	}   
	public boolean apagarFornecedor(Long id) {   
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);    
		if (existeFornecedor.isPresent()) {    
			fornecedorRepository.deleteById(id);    
			return true;    
		}   
		return false;    
	}  
} 