package br.fundatec.lp2.ContatoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.lp2.ContatoDao.ContatoDao;
import br.fundatec.lp2.convert.ContatoConvert;

@Component
public class ContatoService {

	private ContatoDao Cdao;

	@Autowired
	public ContatoService(ContatoDao Cdao) {
		this.Cdao = Cdao;
	}

	/** GET LISTA CONTATO **/
	public List<ContatoBO> pegaListaContato() {
		return ContatoConvert.convertListEntityEmListBO(Cdao.getListaContato());
	}

	/** GET CONTATO **/
	public ContatoBO getContatoBO(long id) {
		return ContatoConvert.convertEntityEmBO(Cdao.getContatoEntity(id));
	}

	/** POST CONTATO **/
	public ContatoBO postContatoBO(ContatoBO contBO) {
		if(contBO.getNome().trim().equals("") || contBO.getTelefone().trim().equals("") || contBO.getEmail().trim().equals("")) {
			throw new RuntimeException();
		}else{
			return ContatoConvert.convertEntityEmBO(Cdao.postContatoEntity(ContatoConvert.convertBoEmEntity(contBO)));			
		}
	}

	/** DELETA CONTATO **/
	public void deletaContatoBO(long id) {
		Cdao.deleteContatoEntity(id);
	}

	/** PUT CONTATO **/
	public void putContatoBO(ContatoBO contBO) {
		if(contBO.getNome().trim().equals("") || contBO.getTelefone().trim().equals("") || contBO.getEmail().trim().equals("")) {
			throw new RuntimeException();
		}else {
			Cdao.putContatoEntity(ContatoConvert.convertBoEmEntity(contBO));
		}
	}
}
