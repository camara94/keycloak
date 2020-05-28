package com.camaratek.supplier.supplier;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.camaratek.supplier.supplier.model.Supplier;
import com.camaratek.supplier.supplier.repositories.SupplierRepository;
@CrossOrigin("*")
@SpringBootApplication
public class SupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start( SupplierRepository supplierRepository, RepositoryRestConfiguration restConfiguration) {
		return args -> {
			restConfiguration.exposeIdsFor(Supplier.class);
			Stream.of("IBM", "Sansung", "HP").forEach(name -> {
				supplierRepository.save(new Supplier(null, name, "contact@"+name + ".com"));
			});
		};
	}

}
