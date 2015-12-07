package br.com.petshop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

enum TipoAnimal {
	Cachorro, Gato
}

enum GeneroAnimal {
	Macho, Femea
}

@Entity
@Table
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private String nomeAdotivo;
	private TipoAnimal tipo;
	private GeneroAnimal genero;
	private int idade;
	private String raca;
	private boolean disponivel;
	@ManyToOne
    @JoinColumn(name="instituicao_id")
	private Instituicao instituicao;

	public Animal() {
		super();
	}

	public Animal(String codigo, String nomeAdotivo, TipoAnimal tipo, GeneroAnimal genero, int idade, String raca,
			boolean disponivel, Instituicao instituicao) {
		super();
		this.codigo = codigo;
		this.nomeAdotivo = nomeAdotivo;
		this.tipo = tipo;
		this.genero = genero;
		this.idade = idade;
		this.raca = raca;
		this.disponivel = disponivel;
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeAdotivo() {
		return nomeAdotivo;
	}

	public void setNomeAdotivo(String nomeAdotivo) {
		this.nomeAdotivo = nomeAdotivo;
	}

	public TipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}

	public GeneroAnimal getGenero() {
		return genero;
	}

	public void setGenero(GeneroAnimal genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}	
	
}
