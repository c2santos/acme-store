package com.acmestore;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acmestore.domain.Categoria;
import com.acmestore.domain.Cidade;
import com.acmestore.domain.Cliente;
import com.acmestore.domain.Endereco;
import com.acmestore.domain.Estado;
import com.acmestore.domain.Produto;
import com.acmestore.domain.enuns.TipoCliente;
import com.acmestore.repository.CategoriaRepository;
import com.acmestore.repository.CidadeRepository;
import com.acmestore.repository.ClienteRepository;
import com.acmestore.repository.EnderecoRepository;
import com.acmestore.repository.EstadoRepository;
import com.acmestore.repository.ProdutoRepository;

@SpringBootApplication
public class AcmeStoreApplication implements CommandLineRunner{

	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
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
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estado1.getCidades().addAll(Arrays.asList(cidade1,cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3678912377", TipoCliente.PESSOAFISICA);
		cl1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cl1, cidade1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cl1, cidade2);
		
		
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}
	
	

}
