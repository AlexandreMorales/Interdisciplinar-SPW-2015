package Models;

enum TipoInstituicao{
	Canil,
	Gatil,
	Ambos
}

public class Instituicao {
	private int IdInstituicao;
	private String Nome;
	private String Codigo;
	private String CNPJ;
	private String Endereco;
	private String Telefone;
	private String Email;
	private TipoInstituicao Tipo;
	
	public Instituicao(String nome, String codigo, String cNPJ, String endereco, String telefone, String email,
			TipoInstituicao tipo) {
		Nome = nome;
		Codigo = codigo;
		CNPJ = cNPJ;
		Endereco = endereco;
		Telefone = telefone;
		Email = email;
		Tipo = tipo;
	}
	
	public int getIdInstituicao() {
		return IdInstituicao;
	}

	public void setIdInstituicao(int idInstituicao) {
		IdInstituicao = idInstituicao;
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
}
