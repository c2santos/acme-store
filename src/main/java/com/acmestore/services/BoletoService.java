package com.acmestore.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.acmestore.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void PreencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instante) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instante);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pgto.setDataPagamento(cal.getTime());
		
	}

}
