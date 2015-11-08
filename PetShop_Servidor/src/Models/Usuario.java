package Models;

public class Usuario {
	private int IdUsuario;
	private String Email;
	private String Senha;
	private String PerfilAcesso;
	private int IdPessoa;
		
	public Usuario(String email, String senha, String perfilAcesso, int idPessoa) {
		super();
		Email = email;
		Senha = senha;
		PerfilAcesso = perfilAcesso;
		IdPessoa = idPessoa;
	}
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
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
	public int getIdPessoa() {
		return IdPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		IdPessoa = idPessoa;
	}	
}
