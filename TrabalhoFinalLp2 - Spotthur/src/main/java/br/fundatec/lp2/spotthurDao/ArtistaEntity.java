package br.fundatec.lp2.spotthurDao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class ArtistaEntity {
		
		@Id
		@Column(name="id")
		@GeneratedValue
		private Long id;
		
		@Column(name="nome")
		private String nome;
		
		@Column(name="idade")
		private String idade;

		@OneToMany
		private List<MusicaEntity> listaMusicasEntity;

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

		public List<MusicaEntity> getListaMusicasEntity() {
			return listaMusicasEntity;
		}

		public void setListaMusicasEntity(List<MusicaEntity> listaMusicasEntity) {
			this.listaMusicasEntity = listaMusicasEntity;
		}
    }

