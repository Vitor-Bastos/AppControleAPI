package br.com.infnet.appcontrole.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appcontrole.model.negocio.Penicilina;

@Repository
public interface IPenicilinaRepository extends CrudRepository<Penicilina, Integer> {

	List<Penicilina> findAll(Sort by);
}
