package br.com.infnet.appcontrole.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TControle")
public class Controle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@ManyToMany(cascade = CascadeType.DETACH)	
	@JoinTable(name = "TControleRemedio",	
		joinColumns = {@JoinColumn(name="idControle")},
		inverseJoinColumns = {@JoinColumn(name="idRemedio")})
	private List<Remedio> remedios;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idSolicitante")
	private Solicitante solicitante;
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s", 
					this.getId(),
					this.getDescricao(),
					this.getRemedios()
				);
	}

	public Controle() {
	}
	public Controle(Integer id, String descricao) {
		this();
		this.setId(id);
		this.setDescricao(descricao);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Remedio> getRemedios() {
		return remedios;
	}
	public void setRemedios(List<Remedio> remedios) {
		this.remedios = remedios;
	}
	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
}
