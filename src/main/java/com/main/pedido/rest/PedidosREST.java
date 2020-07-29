package com.main.pedido.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.pedido.dao.PedidoDAO;
import com.main.pedido.dao.ProductoDAO;
import com.main.pedido.entitys.Pedido;
import com.main.pedido.entitys.Producto;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("productos")
public class PedidosREST {

	@Autowired
	private ProductoDAO productoDAO;

	@Autowired
	private PedidoDAO pedidoDAO;

	@GetMapping
	public ResponseEntity<List<Producto>> getProducto() {
		List<Producto> productos = productoDAO.findAll();
		return ResponseEntity.ok(productos);

	}

	@RequestMapping("{id}")

	public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id) {
		Optional<Producto> producto = productoDAO.findById(id);
		if (!producto.isPresent())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(producto.get());

	}

	@PostMapping
	public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
		Pedido nuevoPedido = pedidoDAO.save(pedido);
		return ResponseEntity.ok(nuevoPedido);

	}

}
