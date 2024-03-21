package projetojpaAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetojpaAvaliacao.entities.Pedido;
import projetojpaAvaliacao.repository.PedidoRepository;  
  
@Service  
public class PedidoService {  
	private final PedidoRepository pedidoRepository;    
	@Autowired    
	public PedidoService(PedidoRepository pedidoRepository) {    
		this.pedidoRepository = pedidoRepository;    
	}   
	public List<Pedido> buscaTodosPedidos() {    
		return pedidoRepository.findAll();   
	}   
	public Pedido buscaPedidoId(Long id) {    
		Optional <Pedido> pedido = pedidoRepository.findById(id);   
		return pedido.orElse(null);   
	}   
	public Pedido salvaPedido(Pedido pedido) {    
		return pedidoRepository.save(pedido);    

	}   
	public Pedido alterarPedido(Long id, Pedido alterarUser) {    
		Optional <Pedido> existePedido = pedidoRepository.findById(id);    
		if (existePedido.isPresent()) {    
			alterarUser.setId(id);    
			return pedidoRepository.save(alterarUser);    
		}   
		return null;    
	}   
	public boolean apagarPedido(Long id) {   
		Optional <Pedido> existePedido = pedidoRepository.findById(id);    
		if (existePedido.isPresent()) {    
			pedidoRepository.deleteById(id);    
			return true;    
		}   
		return false;    
	}  
} 