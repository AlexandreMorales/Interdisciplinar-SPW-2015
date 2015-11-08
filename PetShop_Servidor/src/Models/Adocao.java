package Models;

import java.util.Date;

public class Adocao {
	private int IdAdocao;
	private int IdPessoa;
	private int IdInstituicao;
	private Date DataAdocao;
			
	public Adocao(int idPessoa, int idInstituicao, Date dataAdocao) {
		super();
		IdPessoa = idPessoa;
		IdInstituicao = idInstituicao;
		DataAdocao = dataAdocao;
	}
	
	public int getIdAdocao() {
		return IdAdocao;
	}
	public void setIdAdocao(int idAdocao) {
		IdAdocao = idAdocao;
	}
	public int getIdPessoa() {
		return IdPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		IdPessoa = idPessoa;
	}
	public int getIdInstituicao() {
		return IdInstituicao;
	}
	public void setIdInstituicao(int idInstituicao) {
		IdInstituicao = idInstituicao;
	}
	public Date getDataAdocao() {
		return DataAdocao;
	}
	public void setDataAdocao(Date dataAdocao) {
		DataAdocao = dataAdocao;
	}
}
