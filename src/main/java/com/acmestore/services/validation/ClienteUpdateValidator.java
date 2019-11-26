package com.acmestore.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.acmestore.domain.Cliente;
import com.acmestore.dto.ClienteDTO;
import com.acmestore.exception.FieldMessage;
import com.acmestore.repository.ClienteRepository;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		@SuppressWarnings("unchecked")
		Map<String,String> map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer UriId = Integer.parseInt(map.get("id"));
		
		Cliente cliAux = clienteRepo.findByEmail(objDTO.getEmail());
		
		if(cliAux!=null && !cliAux.getId().equals(UriId)) {
			list.add(new FieldMessage("email", "Já existe um usuário cadastrado com esse email!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
