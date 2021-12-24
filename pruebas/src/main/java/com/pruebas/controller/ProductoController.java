package com.pruebas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.pruebas.model.Productos;
import com.pruebas.service.UseService;

@RestController
@RequestMapping("/api/users")
public class ProductoController {

	@Autowired
	private UseService service;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Productos productos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {

		Optional<Productos> user = service.findById(id);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Productos productos, @PathVariable(value = "id") Long productId) {

		Optional<Productos> user = service.findById(productId);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		user.get().setNombre(productos.getNombre());
		user.get().setApellido(productos.getApellido());
		user.get().setContrasena(productos.getContrasena());
		user.get().setEmail(productos.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user.get()));

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long ProductId) {

		if (!service.findById(ProductId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
         service.deleteById(ProductId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Productos>readAll(){
		
		List<Productos> productos = StreamSupport
				.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return productos;
		
	}

}
