package br.com.petshop.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@ManyToMany(targetEntity = Animal.class, fetch = FetchType.LAZY)
	private List<Animal> animais;
	private Date dataAdocao;
	
	public Adocao(Pessoa pessoa, Instituicao instituicao,
			Date dataAdocao) {
		super();
		this.dataAdocao = dataAdocao;
	}

	public Adocao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int idA) {
		this.id = id;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
	
	
			
	
}
