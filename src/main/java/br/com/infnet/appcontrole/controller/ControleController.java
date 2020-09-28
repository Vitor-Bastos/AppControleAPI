package br.com.infnet.appcontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appcontrole.model.negocio.Controle;
import br.com.infnet.appcontrole.model.service.ControleService;

@RestController
@RequestMapping("/api/controle")
public class ControleController {

	@Autowired
	private ControleService controleService;

	@GetMapping(value = "/lista")
	public List<Controle> obterLista() {
		return controleService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Controle controle) {
		controleService.incluir(controle);
	}

	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		controleService.excluir(id);
	}

	@GetMapping(value = "/{id}/consultar")
	public Controle consultar(@PathVariable Integer id) {
		return controleService.obterPorId(id);
	}
}