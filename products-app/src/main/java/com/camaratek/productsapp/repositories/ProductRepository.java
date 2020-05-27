package com.camaratek.productsapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.camaratek.productsapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {	
	public Product getProductById( Long id );
}