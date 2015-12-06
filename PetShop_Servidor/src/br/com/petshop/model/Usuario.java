package br.com.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

enum PerfilAcesso {
	Pessoa, Instituicao
}

@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Email;
	private String Senha;
	private PerfilAcesso PerfilAcesso;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String senha, PerfilAcesso perfilAcesso) {
		super();
		Email = email;
		Senha = senha;
		PerfilAcesso = perfilAcesso;
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
	public PerfilAcesso getPerfilAcesso() {
		return PerfilAcesso;
	}
	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		PerfilAcesso = perfilAcesso;
	}	
	
		
}
