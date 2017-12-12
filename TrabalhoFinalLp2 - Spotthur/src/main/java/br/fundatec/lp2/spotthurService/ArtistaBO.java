package br.fundatec.lp2.spotthurService;

import java.util.List;

import br.fundatec.lp2.spotthurDao.MusicaEntity;

public class ArtistaBO {
	private Long id;
	private String nome;
	private String idade;
	private List<MusicaBO> listaMusicasBO;
	
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

	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
/**-------------------------------------------------------------------------------------------------------**/

	public List<MusicaBO> getListaMusicas() {
		return listaMusicasBO;
	}
	public void setListaMusicas(List<MusicaBO> listaMusicasBO) {
		this.listaMusicasBO = listaMusicasBO;
	}
	
	
}
