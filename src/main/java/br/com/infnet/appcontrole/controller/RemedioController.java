package br.com.infnet.appcontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appcontrole.model.negocio.Remedio;
import br.com.infnet.appcontrole.model.service.RemedioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/controle")
public class RemedioController {

	@Autowired private RemedioService remedioService;
	
	@ApiOperation(value = "Cadastrar um novo remedio")
	@PostMapping(value = "/remedio/incluir")
	public void incluir(@RequestBody Remedio remedio) {
		remedioService.incluir(remedio);
	}

	@ApiOperation(value = "Retornar uma lista de remedios")
	@GetMapping(value = "/remedios")
	public List<Remedio> obterLista() {
		return remedioService.obterLista();
	}
	@ApiOperation(value = "Remover um remedio existente")
	@GetMapping(value = "/remedio/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		remedioService.excluir(id);
	}

	@ApiOperation(value = "Retornar um remedio")
	@GetMapping(value = "/remedio/{id}")
	public Remedio obterPorId(@PathVariable Integer id) {
		return remedioService.obterPorId(id);
	}
}