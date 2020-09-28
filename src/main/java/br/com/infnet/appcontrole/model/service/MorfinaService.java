package br.com.infnet.appcontrole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appcontrole.model.negocio.Morfina;
import br.com.infnet.appcontrole.model.repository.IMorfinaRepository;

@Service
public class MorfinaService {

	@Autowired private IMorfinaRepository morfinaRepository;
	
	public List<Morfina> obterLista(){
		return (List<Morfina>)morfinaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Morfina morfina) {
		morfinaRepository.save(morfina);
	}

	public void excluir(Integer id) {
		morfinaRepository.deleteById(id);		
	}

	public Morfina obterPorId(Integer id) {
		return morfinaRepository.findById(id).orElse(null);
	}
}