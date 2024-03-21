package projetojpaAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetojpaAvaliacao.entities.ItemPedido;
import projetojpaAvaliacao.repository.ItemPedidoRepository;  
  
@Service  
public class ItemPedidoService {  
	private final ItemPedidoRepository itemPedidoRepository;    
	@Autowired    
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {    
		this.itemPedidoRepository = itemPedidoRepository;    
	}   
	public List<ItemPedido> buscaTodosItemPedidos() {    
		return itemPedidoRepository.findAll();   
	}   
	public ItemPedido buscaItemPedidoId(Long id) {    
		Optional <ItemPedido> itemPedido = itemPedidoRepository.findById(id);   
		return itemPedido.orElse(null);   
	}   
	public ItemPedido salvaItemPedido(ItemPedido itemPedido) {    
		return itemPedidoRepository.save(itemPedido);    
	}   
	public ItemPedido alterarItemPedido(Long id, ItemPedido alterarUser) {    
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);    
		if (existeItemPedido.isPresent()) {    
			alterarUser.setId(id);    
			return itemPedidoRepository.save(alterarUser);    
		}   
		return null;    
	}   
	public boolean apagarItemPedido(Long id) {   
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);    
		if (existeItemPedido.isPresent()) {    
			itemPedidoRepository.deleteById(id);    
			return true;    
		}   
		return false;    
	}  
} 