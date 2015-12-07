package br.com.petshop.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Adocao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	@ManyToOne
    @JoinColumn(name="instituicao_id")
	private Instituicao instituicao;
	@ManyToOne
    @JoinColumn(name="animal_id")
	private Animal animal;
	private Date dataAdocao;
	
	public Adocao() {
		super();
	}

	
	public Adocao(int id, Pessoa pessoa, Instituicao instituicao,
			Animal animal, Date dataAdocao) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.instituicao = instituicao;
		this.animal = animal;
		this.dataAdocao = dataAdocao;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
	

	
	
			
	
}
