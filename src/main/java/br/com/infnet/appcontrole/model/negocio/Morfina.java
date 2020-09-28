package br.com.infnet.appcontrole.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TMorfina")
@PrimaryKeyJoinColumn(name = "idRemedio")
public class Morfina extends Remedio {

	private String tipo;

	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), this.getTipo());
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
