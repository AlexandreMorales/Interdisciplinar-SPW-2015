package br.com.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@ManyToOne
    @JoinColumn(name="instituicao_id")
	private Instituicao instituicao;
	@ManyToOne
	@JoinColumn(name="animal_id")
	private Animal animal;
	private String Descricao;
	
	public Anuncio(){
		super();
	}
	public Anuncio(int id, Instituicao instituicao, Animal animal,
			String descricao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.animal = animal;
		Descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
		
	
	
}
