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
 
import projetojpaAvaliacao.entities.Pedido; 
import projetojpaAvaliacao.services.PedidoService;  

@RestController  
@RequestMapping("/pedido")  
public class PedidoController {  
	private final PedidoService pedidoService;  
	@Autowired  
	public PedidoController(PedidoService pedidoService) {  
		this.pedidoService = pedidoService;  
	}  
	@GetMapping("/{id}")  
	public ResponseEntity<Pedido> buscaPedidosControlId(@PathVariable Long id){  
		Pedido pedido = pedidoService.buscaPedidoId(id);  
		if (pedido != null) {  
			return ResponseEntity.ok(pedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@GetMapping("/")  
	public ResponseEntity<List<Pedido>> buscaTodasPedidosControl(){  
		List<Pedido> pedido = pedidoService.buscaTodosPedidos();  
		return ResponseEntity.ok(pedido);  
	}  
	@PostMapping("/")  
	public ResponseEntity<Pedido> salvaPedidosControl(@RequestBody Pedido pedido){  
		Pedido salvaPedido = pedidoService.salvaPedido(pedido);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);  
	}  
	@PutMapping("/{id}")  
	public ResponseEntity<Pedido> alteraPedidosControl(@PathVariable Long id, @RequestBody Pedido pedido){  
		Pedido alteraPedido = pedidoService.alterarPedido(id, pedido);  
		if (alteraPedido != null) {  
			return ResponseEntity.ok(pedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@DeleteMapping("/{id}")  
	public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id){  
		boolean apagar = pedidoService.apagarPedido(id);  
		if(apagar) {  
			return ResponseEntity.ok().body("O pedido foi excluido!");  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
} 