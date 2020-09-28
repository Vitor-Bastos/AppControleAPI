package br.com.infnet.appcontrole.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TPenicilina")
@PrimaryKeyJoinColumn(name = "idRemedio")
public class Penicilina extends Remedio {

	private String tratamento;

	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), this.getTratamento());
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
}