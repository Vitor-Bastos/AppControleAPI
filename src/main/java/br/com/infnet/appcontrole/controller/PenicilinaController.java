package br.com.infnet.appcontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appcontrole.model.negocio.Penicilina;
import br.com.infnet.appcontrole.model.service.PenicilinaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/controle")
public class PenicilinaController {

	@Autowired private PenicilinaService penicilinaService;
	
	@ApiOperation(value = "Retornar uma lista de penicilinas")
	@GetMapping(value = "/penicilinas")
	public List<Penicilina> obterLista() {
		return penicilinaService.obterLista();
	}

	@ApiOperation(value = "Retornar penicilina")
	@GetMapping(value = "/penicilina/{id}")
	public Penicilina obterPorId(@PathVariable Integer id) {
		return penicilinaService.obterPorId(id);
	}
}