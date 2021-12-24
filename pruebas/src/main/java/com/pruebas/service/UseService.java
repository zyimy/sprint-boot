package com.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.pruebas.model.Productos;
import com.pruebas.repository.ProductoRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

@Service
public class UseService implements UserService {

	@Autowired
	private ProductoRepository pr;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Productos> findAll() {
		
		return pr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Productos> findAll(Pageable pageable) {
		
		return pr.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Productos> findById(Long id) {
		
		return pr.findById( id);
	}
	@Override
	@Transactional
	public Productos save(Productos productos) {
		
		return pr.save(productos);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		pr.deleteById(id);
	}

}
