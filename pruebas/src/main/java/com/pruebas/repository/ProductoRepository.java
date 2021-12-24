package com.pruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Productos;
public interface ProductoRepository extends JpaRepository<Productos,Long> {
	

}
