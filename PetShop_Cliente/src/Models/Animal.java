package Models;

enum TipoAnimal{
	Cachorro,
	Gato
}

enum GeneroAnimal{
	Macho,
	Femea
}

public class Animal {
	private int IdAnimal;
	private String Codigo;
	private String NomeAdotivo;
	private TipoAnimal Tipo;
	private GeneroAnimal Genero;
	private int Idade;
	private String Raca;
	private boolean Disponivel;
	private int IdAdocao;
	
	public Animal(String codigo, String nomeAdotivo, TipoAnimal tipo, GeneroAnimal genero, int idade, String raca,
			boolean disponivel) {
		Codigo = codigo;
		NomeAdotivo = nomeAdotivo;
		Tipo = tipo;
		Genero = genero;
		Idade = idade;
		Raca = raca;
		Disponivel = disponivel;
	}
	
	public int getIdAdocao() {
		return IdAdocao;
	}

	public void setIdAdocao(int idAdocao) {
		IdAdocao = idAdocao;
	}

	public int getIdAnimal() {
		return IdAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		IdAnimal = idAnimal;
	}

	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNomeAdotivo() {
		return NomeAdotivo;
	}
	public void setNomeAdotivo(String nomeAdotivo) {
		NomeAdotivo = nomeAdotivo;
	}
	public TipoAnimal getTipo() {
		return Tipo;
	}
	public void setTipo(TipoAnimal tipo) {
		Tipo = tipo;
	}
	public GeneroAnimal getGenero() {
		return Genero;
	}
	public void setGenero(GeneroAnimal genero) {
		Genero = genero;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		Idade = idade;
	}
	public String getRaca() {
		return Raca;
	}
	public void setRaca(String raca) {
		Raca = raca;
	}
	public boolean isDisponivel() {
		return Disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		Disponivel = disponivel;
	}
}
