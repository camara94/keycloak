package com.camaratek.supplier.supplier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camaratek.supplier.supplier.model.Supplier;


@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	public Supplier getSupplierById( Long id );
}
