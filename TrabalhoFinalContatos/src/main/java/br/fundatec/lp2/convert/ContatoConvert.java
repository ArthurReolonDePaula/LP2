package br.fundatec.lp2.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.lp2.ContatoDao.ContatoEntity;
import br.fundatec.lp2.ContatoRest.ContatoDTO;
import br.fundatec.lp2.ContatoService.ContatoBO;

public class ContatoConvert {
	
/*******************************************************************************/	
	public static ContatoEntity convertBoEmEntity(ContatoBO contBO) {
		ContatoEntity contatoEntity = new ContatoEntity();
		contatoEntity.setId(contBO.getId());
		contatoEntity.setNome(contBO.getNome());
		contatoEntity.setTelefone(contBO.getTelefone());
		contatoEntity.setEmail(contBO.getEmail());
		return contatoEntity;
	}
	
	public static ContatoBO convertEntityEmBO(ContatoEntity contEntity) {
		ContatoBO contatoBO = new ContatoBO();
		contatoBO.setId(contEntity.getId());
		contatoBO.setNome(contEntity.getNome());
		contatoBO.setTelefone(contEntity.getTelefone());
		contatoBO.setEmail(contEntity.getEmail());
		return contatoBO;
	}
	
/*******************************************************************************/	
	
	public static ContatoDTO convertBoEmDto(ContatoBO contBO) {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setId(contBO.getId());
		contatoDTO.setNome(contBO.getNome());
		contatoDTO.setTelefone(contBO.getTelefone());
		contatoDTO.setEmail(contBO.getEmail());
		return contatoDTO;
	}
	
	public static ContatoBO convertDTOemBO(ContatoDTO contDTO) {
		ContatoBO contadorBO = new ContatoBO();
		contadorBO.setId(contDTO.getId());
		contadorBO.setNome(contDTO.getNome());
		contadorBO.setTelefone(contDTO.getTelefone());
		contadorBO.setEmail(contDTO.getEmail());
		return contadorBO;
	}
	
/*******************************************************************************/
	
	public static List<ContatoBO> convertListEntityEmListBO(List<ContatoEntity> entity){
		List<ContatoBO> bos = new ArrayList<>();
		for(ContatoEntity contatoEntity : entity) {
			ContatoBO contatoBO = new ContatoBO();
			contatoBO.setId(contatoEntity.getId());
			contatoBO.setNome(contatoEntity.getNome());
			contatoBO.setTelefone(contatoEntity.getTelefone());
			contatoBO.setEmail(contatoEntity.getEmail());
			
			bos.add(contatoBO);
		} 
		return bos;
	}
	
	public static List<ContatoDTO> convertListBOemDTO(List<ContatoBO> bo){
		List<ContatoDTO> dtos = new ArrayList<>();
		for(ContatoBO contatoBO : bo) {
			ContatoDTO contatoDTO = new ContatoDTO();
			contatoDTO.setId(contatoBO.getId());
			contatoDTO.setNome(contatoBO.getNome());
			contatoDTO.setTelefone(contatoBO.getTelefone());
			contatoDTO.setEmail(contatoBO.getEmail());
			dtos.add(contatoDTO);
		}
			return dtos;
	}

/*******************************************************************************/
}
