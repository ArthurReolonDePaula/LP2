package br.fundatec.lp2.spotthurDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpotthurDao {
	private EntityManager em;

	@Autowired
	public SpotthurDao(EntityManager em) {
		this.em = em;
	}

	/** GET ARTISTA **/
	public ArtistaEntity getArtista(Long id) {
		ArtistaEntity artistaEntity = em.find(ArtistaEntity.class, id);
		if (artistaEntity != null) {
			return artistaEntity;
		} else {
			throw new RuntimeException();
		}
	}

	/** GET MUSICA **/
	public MusicaEntity getMusica(Long id) {
		MusicaEntity musicaEntity = em.find(MusicaEntity.class, id);
		if (musicaEntity != null) {
			return musicaEntity;
		} else {
			throw new RuntimeException();
		}
	}

	/** POST ARTISTA **/
	@Transactional
	public ArtistaEntity postArtista(ArtistaEntity artEnti) {
		return em.merge(artEnti);
	}

	/** POST MUSICA **/
	@Transactional
	public MusicaEntity postMusica(MusicaEntity musEnti) {
		return em.merge(musEnti);
	}

	/** DELETA ARTISTA **/
	@Transactional
	public void deletaArtista(long id) {
		ArtistaEntity artistaEntity = em.find(ArtistaEntity.class, id);
		if (artistaEntity != null) {
			em.remove(artistaEntity);
		} else {
			throw new RuntimeException();
		}
	}

	/** DELETA MUSICA **/
	@Transactional
	public void deletaMusica(long id) {
		MusicaEntity musicaEntity = em.find(MusicaEntity.class, id);
		if (musicaEntity != null) {
			em.remove(musicaEntity);
		} else {
			throw new RuntimeException();
		}
	}

	/** PUT ARTISTA **/
	@Transactional
	public void updateInfoMusica(MusicaEntity musEnti) {
		em.merge(musEnti);
	}

	/** PUT MUSICA **/
	@Transactional
	public void updateInfoArtista(ArtistaEntity artEnti) {
		em.merge(artEnti);
	}

	/** GET LISTA ARTISTA **/
	public List<ArtistaEntity> pegarArtista() {
		return em.createQuery("from ArtistaEntity").getResultList();
	}
	
	/** GET LISTA MUSICA **/
	public List<MusicaEntity> pegarMusica(){
		return em.createQuery("from MusicaEntity").getResultList();
	}
}
