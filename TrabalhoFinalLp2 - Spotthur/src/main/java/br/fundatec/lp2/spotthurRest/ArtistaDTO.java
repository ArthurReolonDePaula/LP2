package br.fundatec.lp2.spotthurRest;

import java.util.List;

import br.fundatec.lp2.spotthurDao.MusicaEntity;

public class ArtistaDTO {
	private Long id;
	private String nome;
	private String idade;
	private List<MusicaDTO> listaMusicasDTO;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public List<MusicaDTO> getListaMusicas() {
		return listaMusicasDTO;
	}
	public void setListaMusicas(List<MusicaDTO> listaMusicasDTO) {
		this.listaMusicasDTO = listaMusicasDTO;
	}	
}

