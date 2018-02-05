package br.fundatec.lp2.spotthurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.lp2.convert.SpotthurConvert;
import br.fundatec.lp2.spotthurDao.SpotthurDao;

@Component
public class SpotthurService {
	private SpotthurDao spoDao;

	@Autowired
	public SpotthurService(SpotthurDao spoDao) {
		this.spoDao = spoDao;
	}

	/** GET ARTISTA **/
	public ArtistaBO getArtista(long id) {
		return SpotthurConvert.convertEntityEmBO(spoDao.getArtista(id));
	}

	/** GET MUSICA **/
	public MusicaBO getMusica(long id) {
		return SpotthurConvert.convertEntityEmBO(spoDao.getMusica(id));
	}

	/** DELETA ARTISTA **/
	public void deletarArtista(long id) {
		spoDao.deletaArtista(id);
	}

	/** DELETA MUSICA **/
	public void deletarMusica(long id) {
		spoDao.deletaMusica(id);
	}

	/** POST ARTISTA **/
	public ArtistaBO postArtista(ArtistaBO artBO) {
		if (artBO.getNome().trim().equals("") && artBO.getNome().isEmpty()
				|| artBO.getIdade().trim().equals("") && artBO.getIdade().isEmpty()
				|| artBO.getListaMusicas().isEmpty()) {
			throw new RuntimeException();
		} else {
			return SpotthurConvert.convertEntityEmBO(spoDao.postArtista(SpotthurConvert.convertBoEmEntity(artBO)));
		}
	}

	/** POST MUSICA **/
	public MusicaBO postMusica(MusicaBO musBO) {
		if (musBO.getNome().trim().equals("") && musBO.getNome().isEmpty()
				|| musBO.getClassificacao().trim().equals("") && musBO.getClassificacao().isEmpty()
				|| musBO.getDuracao().trim().equals("") && musBO.getDuracao().isEmpty()
				|| musBO.getGenero().trim().equals("") && musBO.getGenero().isEmpty()
				|| musBO.getTamanhoMusica().trim().equals("") && musBO.getTamanhoMusica().isEmpty()
				|| musBO.getDataLancamento() == null) {
			throw new RuntimeException();
		}else {
			return SpotthurConvert.convertEntityEmBO(spoDao.postMusica(SpotthurConvert.convertBoEmEntity(musBO)));
		}
	}

	/** PUT ARTISTA **/
	public void updateInfoArtista(ArtistaBO artBO) {
		if (artBO.getNome().trim().equals("") && artBO.getNome().isEmpty()
				|| artBO.getIdade().trim().equals("") && artBO.getIdade().isEmpty()
				|| artBO.getListaMusicas().isEmpty()) {
			throw new RuntimeException();
		}else {
			spoDao.updateInfoArtista(SpotthurConvert.convertBoEmEntity(artBO));		
		}
	}
	
	/** PUT MUSICA **/
	public void updateInfoMusica(MusicaBO musBO) {
		if (musBO.getNome().trim().equals("") && musBO.getNome().isEmpty()
				|| musBO.getClassificacao().trim().equals("") && musBO.getClassificacao().isEmpty()
				|| musBO.getDuracao().trim().equals("") && musBO.getDuracao().isEmpty()
				|| musBO.getGenero().trim().equals("") && musBO.getGenero().isEmpty()
				|| musBO.getTamanhoMusica().trim().equals("") && musBO.getTamanhoMusica().isEmpty()
				|| musBO.getDataLancamento() == null) {
			throw new RuntimeException();
		}else {
			spoDao.postMusica(SpotthurConvert.convertBoEmEntity(musBO));
		}
	}

	/** GET LISTA ARTISTA **/
	public List<ArtistaBO> pegaArtistas() {
		return SpotthurConvert.convertListaEntityEmBo(spoDao.pegarArtista());
	}
	
	/** GET LISTA MUSICA **/
	public List<MusicaBO> pegarMusicas(){
		return SpotthurConvert.convertListaEntityEmBos(spoDao.pegarMusica());
	}
}
