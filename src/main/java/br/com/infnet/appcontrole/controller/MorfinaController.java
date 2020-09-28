package br.com.infnet.appcontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appcontrole.model.negocio.Morfina;
import br.com.infnet.appcontrole.model.service.MorfinaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/controle")
public class MorfinaController {

	@Autowired
	private MorfinaService morfinaService;

	@ApiOperation(value = "Retornar uma lista de morfinas")
	@GetMapping(value = "/morfinas")
	public List<Morfina> obterLista() {
		return morfinaService.obterLista();
	}

	@ApiOperation(value = "Retornar morfina")
	@GetMapping(value = "/morfina/{id}")
	public Morfina obterPorId(@PathVariable Integer id) {
		return morfinaService.obterPorId(id);
	}
}