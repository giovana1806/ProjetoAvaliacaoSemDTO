package projetojpaAvaliacao.controller; 

import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
 
import projetojpaAvaliacao.entities.ItemPedido; 
import projetojpaAvaliacao.services.ItemPedidoService;

@RestController  
@RequestMapping("/itemPedido")  
public class ItemPedidoController {  
	private final ItemPedidoService itemPedidoService;  
	@Autowired  
	public ItemPedidoController(ItemPedidoService itemPedidoService) {  
		this.itemPedidoService = itemPedidoService;  
	}  
	@GetMapping("/{id}")  
	public ResponseEntity<ItemPedido> buscaItemPedidosControlId(@PathVariable Long id){ 
		ItemPedido itemPedido = itemPedidoService.buscaItemPedidoId(id);  
		if (itemPedido != null) {  
			return ResponseEntity.ok(itemPedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@GetMapping("/")  
	public ResponseEntity<List<ItemPedido>> buscaTodasItemPedidosControl(){  
		List<ItemPedido> itemPedido = itemPedidoService.buscaTodosItemPedidos();  
		return ResponseEntity.ok(itemPedido);  
	}  
	@PostMapping("/")  
	public ResponseEntity<ItemPedido> salvaItemPedidosControl(@RequestBody ItemPedido itemPedido){  
		ItemPedido salvaItemPedido = itemPedidoService.salvaItemPedido(itemPedido);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);  
	}  
	@PutMapping("/{id}")  
	public ResponseEntity<ItemPedido> alteraItemPedidosControl(@PathVariable Long id, @RequestBody ItemPedido itemPedido){  
		ItemPedido alteraItemPedido = itemPedidoService.alterarItemPedido(id, itemPedido);  
		if (alteraItemPedido != null) {  
			return ResponseEntity.ok(itemPedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@DeleteMapping("/{id}")  
	public ResponseEntity<String> apagaItemPedidoControl(@PathVariable Long id){  
		boolean apagar = itemPedidoService.apagarItemPedido(id);  
		if(apagar) {  
			return ResponseEntity.ok().body("O itemPedido foi excluido!");  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
} 