package br.com.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Email;
	private String Senha;
	private String PerfilAcesso;
	@OneToOne
	private Pessoa pessoa;
	public Usuario(int id, String email, String senha, String perfilAcesso,
			Pessoa pessoa) {
		super();
		this.id = id;
		Email = email;
		Senha = senha;
		PerfilAcesso = perfilAcesso;
		this.pessoa = pessoa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getPerfilAcesso() {
		return PerfilAcesso;
	}
	public void setPerfilAcesso(String perfilAcesso) {
		PerfilAcesso = perfilAcesso;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
		
	
		
}
