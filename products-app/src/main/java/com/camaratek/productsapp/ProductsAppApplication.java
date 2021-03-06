package com.camaratek.productsapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.camaratek.productsapp.model.Product;
import com.camaratek.productsapp.repositories.ProductRepository;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(1l, "Ordinateur", 500d));
			productRepository.save(new Product(2l, "TV LD", 200d));
			productRepository.save(new Product(3l, "Imprimante", 300d));
			productRepository.save(new Product(4l, "PC Acer", 800d));
			productRepository.save(new Product(5l, "Renault 19", 2500d));
			productRepository.save(new Product(6l, "Mac Book", 900d));
			
			productRepository.findAll().forEach(p -> System.out.println(p.getName()));
		};
		
	}


}
