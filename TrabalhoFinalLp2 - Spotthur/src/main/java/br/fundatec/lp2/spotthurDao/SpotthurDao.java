package br.fundatec.lp2.spotthurDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.lp2.spotthurService.ArtistaBO;

@Component
public class SpotthurDao {
	private EntityManager em;

	@Autowired
	public SpotthurDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public ArtistaEntity getArtista(Long id) {
		ArtistaEntity artistaEntity = em.find(ArtistaEntity.class, id);
		return artistaEntity;
	}

	public MusicaEntity getMusica(Long id) {
		MusicaEntity musicaEntity = em.find(MusicaEntity.class, id);
		return musicaEntity;
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	@Transactional
	public void addArtista(ArtistaEntity artEnti) {
		em.merge(artEnti);
	}

	@Transactional
	public MusicaEntity addMusica(MusicaEntity musEnti) {
		return em.merge(musEnti);
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	@Transactional
	public void deletaArtista(long id) {
		ArtistaEntity artistaEntity = em.find(ArtistaEntity.class, id);
		if (artistaEntity != null) {
			em.remove(artistaEntity);
		}
	}

	@Transactional
	public void deletaMusica(long id) {
		MusicaEntity musicaEntity = em.find(MusicaEntity.class, id);
		if (musicaEntity != null) {
			em.remove(musicaEntity);
		}
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	@Transactional
	public void updateInfoMusica(MusicaEntity musEnti) {
		em.merge(musEnti);
	}

	@Transactional
	public void updateInfoArtista(ArtistaEntity artEnti) {
		em.merge(artEnti);
	}

	public List<ArtistaEntity> pegarArtista() {
		return em.createQuery("from ArtistaEntity").getResultList();
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/
}
