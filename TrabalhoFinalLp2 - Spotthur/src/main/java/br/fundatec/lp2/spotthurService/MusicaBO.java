package br.fundatec.lp2.spotthurService;

import java.util.Date;

public class MusicaBO {
	private Long id;
	private String nome;
	private String duracao;
	private String genero;
	private Date dataLancamento;
	private String classificacao;
	private String tamanhoMusica;
	
/**-------------------------------------------------------------------------------------------------------**/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public String getTamanhoMusica() {
		return tamanhoMusica;
	}
	public void setTamanhoMusica(String tamanhoMusica) {
		this.tamanhoMusica = tamanhoMusica;
	}
	
	
}
