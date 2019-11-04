package com.acmestore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acmestore.domain.Categoria;
import com.acmestore.repository.CategoriaRepository;

@SpringBootApplication
public class AcmeStoreApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcmeStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat,cat2));
	}
	
	

}
