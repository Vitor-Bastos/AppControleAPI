package br.com.infnet.appcontrole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appcontrole.model.negocio.Remedio;
import br.com.infnet.appcontrole.model.repository.IRemedioRepository;

@Service
public class RemedioService {

	@Autowired private IRemedioRepository remedioRepository;
	
	public void incluir(Remedio remedio) {
		remedioRepository.save(remedio);
	}

	public List<Remedio> obterLista(){		
		return (List<Remedio>)remedioRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void excluir(Integer id) {
		remedioRepository.deleteById(id);
	}

	public Remedio obterPorId(Integer id) {
		return remedioRepository.findById(id).orElse(null);
	}
}