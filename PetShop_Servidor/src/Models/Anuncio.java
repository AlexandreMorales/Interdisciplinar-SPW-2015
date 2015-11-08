package Models;

public class Anuncio {
	private int IdAnuncio;
	private int IdInstituicao;
	private int IdAnimal;
	private String Descricao;
		
	public Anuncio(int idInstituicao, int idAnimal, String descricao) {
		IdInstituicao = idInstituicao;
		IdAnimal = idAnimal;
		Descricao = descricao;
	}
	
	public int getIdAnuncio() {
		return IdAnuncio;
	}
	public void setIdAnuncio(int idAnuncio) {
		IdAnuncio = idAnuncio;
	}
	public int getIdInstituicao() {
		return IdInstituicao;
	}
	public void setIdInstituicao(int idInstituicao) {
		IdInstituicao = idInstituicao;
	}
	public int getIdAnimal() {
		return IdAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		IdAnimal = idAnimal;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
}
