package br.fundatec.lp2.ContatoDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContatoDao {

	private EntityManager em;

	@Autowired
	public ContatoDao(EntityManager em) {
		this.em = em;
	}

	/** GET LISTA CONTATO **/

	public List<ContatoEntity> getListaContato() {
		return em.createQuery("from ContatoEntity").getResultList();
	}

	/** GET CONTATO **/
	public ContatoEntity getContatoEntity(long id) {
		ContatoEntity contatoEntity = em.find(ContatoEntity.class, id);
		if (contatoEntity != null) {
			return contatoEntity;
		} else {
			throw new RuntimeException();
		}
	}

	/** POST CONTATO **/
	@Transactional
	public ContatoEntity postContatoEntity(ContatoEntity contatoEntity) {
		return em.merge(contatoEntity);
	}

	/** DELETA CONTATO **/
	@Transactional
	public void deleteContatoEntity(long id) {
		ContatoEntity contatoEntity = em.find(ContatoEntity.class, id);
		if(contatoEntity != null) {
		em.remove(contatoEntity);
		} else {
			throw new RuntimeException();
		}
	}

	/** PUT CONTATO **/
	@Transactional
	public void putContatoEntity(ContatoEntity contatoEntity) {
		em.merge(contatoEntity);
	}
}
