package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Alimenticio;
import br.edu.infnet.appvenda.model.repository.AlimenticioRepository;

@Service
public class AlimenticioService {
	
	@Autowired
	private AlimenticioRepository alimenticioRepository;

	public void incluir(Alimenticio alimenticio) {
		alimenticioRepository.save(alimenticio);
	}
	
	public Collection<Alimenticio> obterLista(){	
		return (Collection<Alimenticio>) alimenticioRepository.findAll();
	}
}