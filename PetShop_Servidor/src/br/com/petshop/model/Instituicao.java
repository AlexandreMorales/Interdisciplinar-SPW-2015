package br.com.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

enum TipoInstituicao{
	Canil,
	Gatil,
	Ambos
}
@Entity
@Table
public class Instituicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nome;
	private String Codigo;
	private String CNPJ;
	private String Endereco;
	private String Telefone;
	private String Email;
	private TipoInstituicao Tipo;
	@OneToOne
	private Usuario usuario;
	
	public Instituicao() {
		super();
	}
	
	public Instituicao(int id, String nome, String codigo, String cNPJ,
			String endereco, String telefone, String email,
			TipoInstituicao tipo, Usuario usuario) {
		super();
		this.id = id;
		Nome = nome;
		Codigo = codigo;
		CNPJ = cNPJ;
		Endereco = endereco;
		Telefone = telefone;
		Email = email;
		Tipo = tipo;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public TipoInstituicao getTipo() {
		return Tipo;
	}
	public void setTipo(TipoInstituicao tipo) {
		Tipo = tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
