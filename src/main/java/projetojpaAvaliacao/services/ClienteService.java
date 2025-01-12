package projetojpaAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetojpaAvaliacao.entities.Cliente;
import projetojpaAvaliacao.repository.ClienteRepository;  
  
@Service  
public class ClienteService {  
	private final ClienteRepository clienteRepository;    
	@Autowired    
	public ClienteService(ClienteRepository clienteRepository) {    
		this.clienteRepository = clienteRepository;    
	}   
	public List<Cliente> buscaTodosClientes() {    
		return clienteRepository.findAll();   
	}   
	public Cliente buscaClienteId(Long id) {    
		Optional <Cliente> cliente = clienteRepository.findById(id);   
		return cliente.orElse(null);   
	}   
	public Cliente salvaCliente(Cliente cliente) {    
		return clienteRepository.save(cliente);    
	}   
	public Cliente alterarCliente(Long id, Cliente alterarUser) {    
		Optional <Cliente> existeCliente = clienteRepository.findById(id);    
		if (existeCliente.isPresent()) {    
			alterarUser.setId(id);    
			return clienteRepository.save(alterarUser);    
		}   
		return null;    
	}   
	public boolean apagarCliente(Long id) {   
		Optional <Cliente> existeCliente = clienteRepository.findById(id);    
		if (existeCliente.isPresent()) {    
			clienteRepository.deleteById(id);    
			return true;    
		}   
		return false;    
	}  
} 