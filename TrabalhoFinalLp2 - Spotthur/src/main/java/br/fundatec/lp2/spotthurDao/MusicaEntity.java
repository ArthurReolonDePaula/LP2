package br.fundatec.lp2.spotthurDao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "musica")
	public class MusicaEntity {
			
			@Id
			@Column(name="id")
			@GeneratedValue
			private Long id;
			
			@Column(name="nome")
			private String nome;
			
			@Column(name="duracao")
			private String duracao;

			@Column(name="genero")
			private String genero;
			
			@Column(name="data_lancamento")
			private Date dataLancamento;
			
			@Column(name="classificacao")
			private String classificacao;
			
			@Column(name="tamanho_musica")
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
	
