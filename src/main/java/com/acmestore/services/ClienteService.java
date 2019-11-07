package com.acmestore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmestore.domain.Cliente;
import com.acmestore.exceptions.ObjectNotFoundException;
import com.acmestore.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
		
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: "+ id + ", Tipo: "+ Cliente.class.getName()));
	}
}
