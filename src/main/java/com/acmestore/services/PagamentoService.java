package com.acmestore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmestore.domain.Pagamento;
import com.acmestore.exceptions.ObjectNotFoundException;
import com.acmestore.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repo;
	
	public Pagamento find(Integer id) {
		
		Optional<Pagamento> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: "+ Pagamento.class.getName()));
	}
}
