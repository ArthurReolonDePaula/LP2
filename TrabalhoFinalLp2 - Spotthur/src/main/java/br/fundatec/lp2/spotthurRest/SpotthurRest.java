package br.fundatec.lp2.spotthurRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fundatec.lp2.convert.SpotthurConvert;
import br.fundatec.lp2.spotthurService.SpotthurService;

@RestController
@RequestMapping(value = "/spotthur")
public class SpotthurRest {

	private SpotthurService spotthurService;

	@Autowired
	public SpotthurRest(SpotthurService spotthurService) {
		super();
		this.spotthurService = spotthurService;
	}

	/** GET TODOS ARTISTAS **/
	@GetMapping("/artistas")
	public ResponseEntity<List<ArtistaDTO>> getListaArtista() {
		return ResponseEntity.ok(SpotthurConvert.convertListaBoEmDTO(spotthurService.pegaArtistas()));
	}

	/** GET TODAS MUSICAS **/
	@GetMapping("/musicas")
	public ResponseEntity<List<MusicaDTO>> getListaMusica() {
		return ResponseEntity.ok(SpotthurConvert.convertListaBoEmDTOs(spotthurService.pegarMusicas()));
	}

	/** GET ARTISTA POR ID **/
	@GetMapping("/artistas/{id}")
	public ResponseEntity<ArtistaDTO> getArtistaEspecifico(@PathVariable("id") long id) {
		try {
			ArtistaDTO artista = SpotthurConvert.convertBOEmDTO(spotthurService.getArtista(id));
			return ResponseEntity.ok(artista);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	/** GET MUSICA POR ID **/
	@GetMapping("/musicas/{idMusica}")
	public ResponseEntity<MusicaDTO> getMusica(@PathVariable("idMusica") long idMusica) {
		try {
			MusicaDTO musica = SpotthurConvert.convertBOEmDTO((spotthurService.getMusica(idMusica)));
			return ResponseEntity.ok(musica);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	/** POST ARTISTAS **/
	@PostMapping("/artistas")
	public ResponseEntity<ArtistaDTO> postArtista(@RequestBody ArtistaDTO dto) {
		try {
			dto = SpotthurConvert.convertBOEmDTO(spotthurService.postArtista(SpotthurConvert.convertDTOEmBO(dto)));
			return ResponseEntity.ok(dto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/** POST MUSICA DOS ARTISTAS **/
	@PostMapping("/musica/{idArtista}")
	public ResponseEntity<MusicaDTO> postMusicaDoArtista(@RequestBody MusicaDTO dto,
			@PathVariable("idArtista") long idArtista) {
		try {
			dto = SpotthurConvert.convertBOEmDTO(spotthurService.postMusica(SpotthurConvert.convertDTOEmBO(dto)));
			return ResponseEntity.ok(dto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/** DELETA MUSICA DO ARTISTA**/
	@DeleteMapping("/musica/{idArtista}/{idMusica}")
	public ResponseEntity<MusicaDTO> deletarMusica(@PathVariable("idMusica") long id){
		try {
			spotthurService.deletarMusica(id);
			return ResponseEntity.noContent().build();			
		}catch(RuntimeException e){
			return ResponseEntity.notFound().build();
		}
	}
	
	/** POST MUSICA **/
	@PutMapping("/musica/{idMusica}")
	public ResponseEntity<MusicaDTO> putMusica(@RequestBody MusicaDTO musicaDTO, @PathVariable("idMusica") long idMusica) {
		musicaDTO.setId(idMusica);
		try {
			spotthurService.updateInfoMusica(SpotthurConvert.convertDTOEmBO(musicaDTO));
			return ResponseEntity.ok(musicaDTO);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
