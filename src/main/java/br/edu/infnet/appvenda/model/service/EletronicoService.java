package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Eletronico;
import br.edu.infnet.appvenda.model.repository.EletronicoRepository;

@Service
public class EletronicoService {

	@Autowired
	private EletronicoRepository eletronicoRepository;
	
	public void incluir(Eletronico eletronico) {
		eletronicoRepository.save(eletronico);
	}
	
	public Collection<Eletronico> obterLista(){	
		return (Collection<Eletronico>) eletronicoRepository.findAll();
	}
}