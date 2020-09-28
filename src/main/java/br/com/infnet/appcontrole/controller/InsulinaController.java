package br.com.infnet.appcontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appcontrole.model.negocio.Insulina;
import br.com.infnet.appcontrole.model.service.InsulinaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/controle")
public class InsulinaController {

	@Autowired
	private InsulinaService insulinaService;

	@ApiOperation(value = "Retornar uma lista de insulinas")
	@GetMapping(value = "/insulinas")
	public List<Insulina> obterLista() {
		return insulinaService.obterLista();
	}

	@ApiOperation(value = "Retornar insulina")
	@GetMapping(value = "/insulina/{id}")
	public Insulina obterPorId(@PathVariable Integer id) {
		return insulinaService.obterPorId(id);
	}
}