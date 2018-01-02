package br.fundatec.lp2.ContatoRest;

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

import br.fundatec.lp2.ContatoService.ContatoService;
import br.fundatec.lp2.convert.ContatoConvert;

@RestController
@RequestMapping(value = "/agenda")
public class ContatoRest {

	private ContatoService Cservice;

	@Autowired
	public ContatoRest(ContatoService Cservice) {
		this.Cservice = Cservice;
	}

	@GetMapping("/contatos")
	public ResponseEntity<List<ContatoDTO>> getListaContato() {
		return ResponseEntity.ok(ContatoConvert.convertListBOemDTO(Cservice.pegaListaContato()));
	}

	@GetMapping("/contatos/{idContato}")
	public ResponseEntity<ContatoDTO> getContatoDTO(@PathVariable("idContato") long id) {
		try {
			ContatoDTO contato = ContatoConvert.convertBoEmDto(Cservice.getContatoBO(id));
			return ResponseEntity.ok(contato);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/contatos")
	public ResponseEntity<ContatoDTO> postContato(@RequestBody ContatoDTO dto) {
		try {
			dto = ContatoConvert.convertBoEmDto(Cservice.postContatoBO(ContatoConvert.convertDTOemBO(dto)));
			return ResponseEntity.ok(dto);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/contatos/{idContato}")
	public ResponseEntity<String> deletaContato(@PathVariable("idContato") long id) {
		try {
			Cservice.deletaContatoBO(id);
			return ResponseEntity.ok("Contato deletado com sucesso");
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("contatos/{idContato}")
	public ResponseEntity<ContatoDTO> putContatoDTO(@RequestBody ContatoDTO dto, @PathVariable("idContato") long id) {
		dto.setId(id);
		try {
			Cservice.putContatoBO(ContatoConvert.convertDTOemBO(dto));
			return ResponseEntity.ok(dto);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
