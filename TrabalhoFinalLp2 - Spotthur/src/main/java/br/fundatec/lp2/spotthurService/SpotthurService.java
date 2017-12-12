package br.fundatec.lp2.spotthurService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.fundatec.lp2.convert.SpotthurConvert;
import br.fundatec.lp2.spotthurDao.SpotthurDao;
import br.fundatec.lp2.spotthurRest.ArtistaDTO;

@Component
public class SpotthurService {
	private SpotthurDao spoDao;

	@Autowired
	public SpotthurService(SpotthurDao spoDao) {
		this.spoDao = spoDao;
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public ArtistaBO getArtista(long id) {
		if (spoDao.getArtista(id) != null) {
			return SpotthurConvert.convertEntityEmBO(spoDao.getArtista(id));
		}
		throw new RuntimeException("Artista não encontrado");
	}

	public MusicaBO getMusica(long id) {
		if (spoDao.getMusica(id) != null) {
			return SpotthurConvert.convertEntityEmBO(spoDao.getMusica(id));
		}
		throw new RuntimeException("Musica não encontrado");
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public void deletarArtista(long id) {

		spoDao.deletaArtista(id);
	}

	public void deletarMusica(long idArtista, long id) {
		ArtistaBO artistaBO = getArtista(idArtista);
		List<MusicaBO> bos = artistaBO.getListaMusicas();
		int contador = 0;
		for (MusicaBO musicaBO : bos) {
			if (musicaBO.getId() == id) {
				artistaBO.getListaMusicas().remove(contador);
				updateInfoArtista(artistaBO);
				spoDao.deletaMusica(id);
				break;
			}
			contador++;
		}
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public void addArtista(ArtistaBO artBO) {
		artBO.setListaMusicas(new ArrayList<>());
		spoDao.addArtista(SpotthurConvert.convertBoEmEntity(artBO));
	}

	public void addMusica(MusicaBO musBO, long idArtista) {
		ArtistaBO artiBO = getArtista(idArtista);
		musBO = SpotthurConvert.convertEntityEmBO(spoDao.addMusica(SpotthurConvert.convertBoEmEntity(musBO)));
		artiBO.getListaMusicas().add(musBO);
		updateInfoArtista(artiBO);
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public void updateInfoArtista(ArtistaBO artBO) {
		spoDao.updateInfoArtista(SpotthurConvert.convertBoEmEntity(artBO));
	}

	public void updateInfoMusica(MusicaBO musBO) {
		spoDao.updateInfoMusica(SpotthurConvert.convertBoEmEntity(musBO));
	}

	/**
	 * -------------------------------------------------------------------------------------------------------
	 **/

	public List<MusicaBO> pegaLista(Long id) {
		return this.getArtista(id).getListaMusicas();
	}

	public List<ArtistaBO> pegaArtistas() {
		return SpotthurConvert.convertListaEntityEmBo(spoDao.pegarArtista());
	}

}
