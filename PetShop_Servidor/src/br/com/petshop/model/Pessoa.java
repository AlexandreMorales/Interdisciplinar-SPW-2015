package br.com.petshop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

enum GeneroPessoa{
	Feminino,
	Masculino,
	Outro
}

enum EtniaPessoa{
	Branca,
	Negra,
	Parda,
	Amarela,
	Outro
}
@Entity
@Table
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String NomeSocial;
	private Date DataNascimento;
	private String NomeParente1;
	private String NomeParente2;
	private String Telefone;
	private GeneroPessoa Genero;
	private EtniaPessoa Etnia;
	private String NomeConjuge;
	private String Religiao;
	private boolean PossuiDeficienciaFisica;
	@OneToOne
	private Usuario usuario;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(int id, String nomeSocial, Date dataNascimento,
			String nomeParente1, String nomeParente2, String telefone,
			GeneroPessoa genero, String nomeConjuge, String religiao,
			boolean possuiDeficienciaFisica, Usuario usuario) {
		super();
		this.id = id;
		NomeSocial = nomeSocial;
		DataNascimento = dataNascimento;
		NomeParente1 = nomeParente1;
		NomeParente2 = nomeParente2;
		Telefone = telefone;
		Genero = genero;
		NomeConjuge = nomeConjuge;
		Religiao = religiao;
		PossuiDeficienciaFisica = possuiDeficienciaFisica;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeSocial() {
		return NomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		NomeSocial = nomeSocial;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getNomeParente1() {
		return NomeParente1;
	}
	public void setNomeParente1(String nomeParente1) {
		NomeParente1 = nomeParente1;
	}
	public String getNomeParente2() {
		return NomeParente2;
	}
	public void setNomeParente2(String nomeParente2) {
		NomeParente2 = nomeParente2;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public GeneroPessoa getGenero() {
		return Genero;
	}
	public void setGenero(GeneroPessoa genero) {
		Genero = genero;
	}
	public String getNomeConjuge() {
		return NomeConjuge;
	}
	public void setNomeConjuge(String nomeConjuge) {
		NomeConjuge = nomeConjuge;
	}
	public String getReligiao() {
		return Religiao;
	}
	public void setReligiao(String religiao) {
		Religiao = religiao;
	}
	public boolean isPossuiDeficienciaFisica() {
		return PossuiDeficienciaFisica;
	}
	public void setPossuiDeficienciaFisica(boolean possuiDeficienciaFisica) {
		PossuiDeficienciaFisica = possuiDeficienciaFisica;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EtniaPessoa getEtnia() {
		return Etnia;
	}

	public void setEtnia(EtniaPessoa etnia) {
		Etnia = etnia;
	}
	
	
		
	
}
