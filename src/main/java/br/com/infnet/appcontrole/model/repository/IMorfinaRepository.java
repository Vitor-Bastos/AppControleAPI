package br.com.infnet.appcontrole.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appcontrole.model.negocio.Morfina;

@Repository
public interface IMorfinaRepository extends CrudRepository<Morfina, Integer> {

	List<Morfina> findAll(Sort by);
}
