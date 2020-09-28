package br.com.infnet.appcontrole.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TRemedio")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipoRemedio"
		)
@JsonSubTypes({
	@JsonSubTypes.Type(value = Insulina.class, name = "I"),
	@JsonSubTypes.Type(value = Morfina.class, name = "M"),
	@JsonSubTypes.Type(value = Penicilina.class, name = "P")
})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public abstract class Remedio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@ManyToMany(mappedBy = "remedios")
	@JsonBackReference
	private List<Controle> controles;
	
	@Override
	public String toString() {
		return String.format("%s", this.getDescricao());
	}
	
	public Remedio() {
	}
	public Remedio(Integer id) {
		this();
		this.setId(id);
	}
	public Remedio(Integer id, String descricao) {
		this(id);
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
	public List<Controle> getControles() {
		return controles;
	}
	public void setControles(List<Controle> controles) {
		this.controles = controles;
	}
}