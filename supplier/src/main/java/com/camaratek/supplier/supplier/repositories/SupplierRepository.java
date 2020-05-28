package com.camaratek.supplier.supplier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.camaratek.supplier.supplier.model.Supplier;

@CrossOrigin("*")
@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	public Supplier getSupplierById( Long id );
}
