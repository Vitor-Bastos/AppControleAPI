package br.com.infnet.appcontrole.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TInsulina")
@PrimaryKeyJoinColumn(name = "idRemedio")
public class Insulina extends Remedio {

	private Float dosagem;
	
	@Override
	public String toString() {
		return String.format("%s - %.2f", super.toString(), this.getDosagem());
	}

	public Float getDosagem() {
		return dosagem;
	}

	public void setDosagem(Float dosagem) {
		this.dosagem = dosagem;
	}
}