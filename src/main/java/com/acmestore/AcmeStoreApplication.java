package com.acmestore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acmestore.domain.Categoria;
import com.acmestore.domain.Cidade;
import com.acmestore.domain.Estado;
import com.acmestore.domain.Produto;
import com.acmestore.repository.CategoriaRepository;
import com.acmestore.repository.CidadeRepository;
import com.acmestore.repository.EstadoRepository;
import com.acmestore.repository.ProdutoRepository;

@SpringBootApplication
public class AcmeStoreApplication implements CommandLineRunner{

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcmeStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		
		Estado estado1 = new Estado(null, "Rio de Janeiro");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Rio de Janeiro",estado1);
		Cidade cidade2 = new Cidade(null, "Campos dos Goytacazes",estado1);
		Cidade cidade3 = new Cidade(null, "Guarulhos",estado2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		estado1.getCidades().addAll(Arrays.asList(cidade1,cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
	
	

}
