package com.pruebas.service;

import java.util.Optional;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.pruebas.model.Productos;

//import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

public interface UserService {

	public Iterable<Productos>findAll();
	
	public Page<Productos>findAll(Pageable pageable);
	
	public Optional<Productos> findById(Long id);
	
	public  Productos save(Productos productos);
	
	public void deleteById(Long id);
}
