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
	
	@PostMapping("/musica/{idArtista}")
	public ResponseEntity<String> postMusicaDoArtista(@RequestBody MusicaDTO dto, @PathVariable("idArtista") long idArtista) {
		spotthurService.addMusica(SpotthurConvert.convertDTOEmBO(dto), idArtista);
		return ResponseEntity.ok("Musica incluida com sucesso.");
	}
	
	@PostMapping("/artista")
	public ResponseEntity<String> postArtista(@RequestBody ArtistaDTO dto) {
		spotthurService.addArtista(SpotthurConvert.convertDTOEmBO(dto));
		return ResponseEntity.ok("Artista incluido com Sucesso.");
	}

	@GetMapping("/musica/{idMusica}")
	public ResponseEntity<MusicaDTO> getMusica(@PathVariable("idMusica") long idMusica){
		try {
			MusicaDTO musica  = SpotthurConvert.convertBOEmDTO((spotthurService.getMusica(idMusica)));
			return ResponseEntity.ok(musica);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/artista")
	public ResponseEntity<List<ArtistaDTO>> getArtista(){
		return ResponseEntity.ok(SpotthurConvert.convertListaBoEmDTO(spotthurService.pegaArtistas()));
	}	
	
	@GetMapping("/artista/{id}")
	public ResponseEntity<ArtistaDTO> getArtistaEspecifico(@PathVariable("id") long id){
		try {
			ArtistaDTO artista = SpotthurConvert.convertBOEmDTO(spotthurService.getArtista(id));
			return ResponseEntity.ok(artista);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/musica/{idArtista}/{idMusica}")
	public ResponseEntity<MusicaDTO> deletarMusica(@PathVariable("idMusica") long id, @PathVariable("idArtista") long idArtista) {
		spotthurService.deletarMusica(idArtista, id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/musica/{idMusica}")
	public ResponseEntity<String> putMusica(@RequestBody MusicaDTO musicaDTO, @PathVariable("idMusica") long idMusica) {	
		musicaDTO.setId(idMusica);
		spotthurService.updateInfoMusica(SpotthurConvert.convertDTOEmBO(musicaDTO));
		return ResponseEntity.ok("Musica editada com sucesso.");
	}
}

