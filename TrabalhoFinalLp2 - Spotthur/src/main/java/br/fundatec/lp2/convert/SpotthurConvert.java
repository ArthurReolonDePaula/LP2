package br.fundatec.lp2.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.lp2.spotthurDao.ArtistaEntity;
import br.fundatec.lp2.spotthurDao.MusicaEntity;
import br.fundatec.lp2.spotthurRest.ArtistaDTO;
import br.fundatec.lp2.spotthurRest.MusicaDTO;
import br.fundatec.lp2.spotthurService.ArtistaBO;
import br.fundatec.lp2.spotthurService.MusicaBO;

public class SpotthurConvert {
	
/**
 * 		Parâmetro entity é o objeto da classe ArtistaEntity.
 * @param entity
 * 		O parâmetro entity está pegando o atributo da classe ArtistaEntity, como por exemplo atributo nome, e está jogando para 
 * 		dentro do atributo equivalente na classe ArtistaBO.
 * 
 * 		Return artiBO é o objeto instanciado da Classe ArtistaBO.
 * @return
 * 		O retorno artiBO é o responsável por armazenar o atributo que veio da classe ArtistaEntity no atributo correspondente na 
 * 		classe ArtistaBO. Fazendo assim a conversão de ENTITY em BO.
 */
	public static ArtistaBO convertEntityEmBO(ArtistaEntity entity) {
		ArtistaBO artiBO = new ArtistaBO();
		artiBO.setId(entity.getId());
		artiBO.setNome(entity.getNome());
		artiBO.setIdade(entity.getIdade());
		artiBO.setListaMusicas(convertListaEntityEmBos(entity.getListaMusicasEntity()));
		return artiBO;
	}
	
/**
 * 		Parâmetro entity é o objeto da classe MusicaEntity.	
 * @param entity
 * 		O parâmetro entity está pegando o atributo da classe MusicaEntity, como por exemplo atributo nome, e está jogando para
 * 		dentro do atributo equivalente na classe MusicaBO.
 * 
 * 		Return musiBo é o objeto instanciado da Classe MusicaBO.
 * @return
 * 		O retorno musiBO é o responsável por amazenar o atributo que veio da classe MusicaEntity no atributo correspondente na
 * 		classe MusicaBO. Fazendo assim a conversão de ENTITY em BO.
 */
	public static MusicaBO convertEntityEmBO(MusicaEntity entity) {
		MusicaBO musiBO = new MusicaBO();
		musiBO.setId(entity.getId());
		musiBO.setNome(entity.getNome());
		musiBO.setDuracao(entity.getDuracao());
		musiBO.setClassificacao(entity.getClassificacao());
		musiBO.setDataLancamento(entity.getDataLancamento());
		musiBO.setGenero(entity.getGenero());
		musiBO.setTamanhoMusica(entity.getTamanhoMusica());
		return musiBO;
	}
/**-------------------------------------------------------------------------------------------------------**/
	
/**
 * 		Parâmetro bo é o objeto da classe ArtistaBO.
 * @param bo
 * 		O parâmetro bo está pegando o atributo da classe ArtistaBO, como por exemplo atributo nome, e está jogando para
 * 		dentro do atributo equivalente na classe ArtistaEntity. 
 * 
 *  	Return artiEntity é o objeto instanciado da Classe ArtistaEntity.
 * @return
 * 		O retorno artiEntity é o responsável por amazenar o atributo que veio da classe ArtistaBO no atributo correspondente na
 * 		classe ArtistaEntity. Fazendo assim a conversão de BO em ENTITY.
 */
	public static ArtistaEntity convertBoEmEntity(ArtistaBO bo) {
		ArtistaEntity artiEntity = new ArtistaEntity();
		artiEntity.setId(bo.getId());
		artiEntity.setNome(bo.getNome());
		artiEntity.setIdade(bo.getIdade());
		artiEntity.setListaMusicasEntity(convertListaBoEmEntitys(bo.getListaMusicas()));
		return artiEntity;
	}
	
/**
 * 		Parâmetro bo é o objeto da classe MusicaBO.
 * @param bo
 * 		O parâmetro bo está pegando o atributo da classe MusicaBO, como por exemplo atributo nome, e está jogando para
 * 		dentro do atributo equivalente na classe MusicaEntity. 
 * 
 * 		Return musiEntity é o objeto instanciado da Classe MusicaEntity.
 * @return
 * 		O retorno musiEntity é o responsável por armazenar o atributo que veio da classe MusicaBO no atributo correspondente na
 * 		classe MusicaEntity. Fazendo assim a conversão de BO em ENTITY.
 */
	public static MusicaEntity convertBoEmEntity(MusicaBO bo) {
		MusicaEntity musiEntity = new MusicaEntity();
		musiEntity.setId(bo.getId());
		musiEntity.setNome(bo.getNome());
		musiEntity.setDuracao(bo.getDuracao());
		musiEntity.setDataLancamento(bo.getDataLancamento());
		musiEntity.setClassificacao(bo.getClassificacao());
		musiEntity.setGenero(bo.getGenero());
		musiEntity.setTamanhoMusica(bo.getTamanhoMusica());
		return musiEntity;
}
/**-------------------------------------------------------------------------------------------------------**/
	
/**
 * 		Parâmetro bo é o objeto da classe ArtistaBO.
 * @param bo
 * 		O parâmetro está pegando o atributo da classe ArtistaBO, como por exemplo nome, e está jogando para dentro do atributo
 * 		equivalente na classe ArtistaDTO.
 * 
 * 		Return artiDTO é o objeto instanciado da classe ArtistaDTO.
 * @return
 * 		Esse retorno é o responsável por armazenar o atributo que veio da classe ArtistaBO no atributo correspondente na classe
 * 		ArtistaDTO. Fazendo assim a conversão de BO em DTO.
 */
	public static ArtistaDTO convertBOEmDTO(ArtistaBO bo) {
		ArtistaDTO artiDTO = new ArtistaDTO(); 
		artiDTO.setId(bo.getId());
		artiDTO.setNome(bo.getNome());
		artiDTO.setIdade(bo.getIdade());
		artiDTO.setListaMusicas(convertListaBoEmDTOs(bo.getListaMusicas()));
		return artiDTO;
	}
	
/**
 * 		Parâmetro bo é o objeto da classe MusicaBO.
 * @param bo
 * 		O parâmetro está pegando o atributo da classe MusicaBO, como por exemplo nome, e está jogando para dentro do atributo
 * 		equivalente na classe MusicaDTO.
 * 
 * 		Return musiDTO é o objeto instanciado da classe MusicaDTO.
 * @return
 * 		Esse retorno é o responsável por armazenar o atributo que veio da classe MusicaBO no atributo correspondente na classe
 * 		MusicaDTO. Fazendo assim a conversão de BO em DTO.
 */
	public static MusicaDTO convertBOEmDTO(MusicaBO bo) {
		MusicaDTO musiDTO = new MusicaDTO();
		musiDTO.setId(bo.getId());
		musiDTO.setNome(bo.getNome());
		musiDTO.setDuracao(bo.getDuracao());
		musiDTO.setDataLancamento(bo.getDataLancamento());
		musiDTO.setClassificacao(bo.getClassificacao());
		musiDTO.setGenero(bo.getGenero());
		musiDTO.setTamanhoMusica(bo.getTamanhoMusica());
		return musiDTO;
	}
/**-------------------------------------------------------------------------------------------------------**/
	
/**
 * 		Parâmetro dto é o objeto da classe ArtistaDTO.
 * @param dto
 * 		O parâmetro está pegando o atributo da classe ArtistaDTO, como por exemplo nome, e está jogando para dentro do atributo
 * 		equivalente na classe ArtistaBO.
 * 
 * 		Return artiBO é o objeto instanciado da classe ArtistaBO.
 * @return
 * 		Esse retorno é o responsável por armazenar o atributo que veio da classe ArtistaDTO no atributo correspondente na classe
 * 		ArtistaBO. Fazendo assim a conversão de BO em DTO.
 */
	public static ArtistaBO convertDTOEmBO(ArtistaDTO dto) {
		ArtistaBO artiBO = new ArtistaBO();
		artiBO.setId(dto.getId());
		artiBO.setNome(dto.getNome());
		artiBO.setIdade(dto.getIdade());
		return artiBO;
	}
	
/**
 * 		Parâmetro dto é o objeto da classe MusicaDTO.
 * @param dto
 * 		O parâmetro está pegando o atributo da classe MusicaDTO, como por exemplo nome, e está jogando para dentro do atributo
 * 		equivalente na classe MusicaBO.
 * 
 * 		Return musiBO é o objeto instanciado da classe MusicaBO.
 * @return
 * 		Esse retorno é o responsável por armazenar o atributo que veio da classe MusicaDTO no atributo correspondente na classe
 * 		MusicaBO. Fazendo assim a conversão de DTO em BO.
 */
	public static MusicaBO convertDTOEmBO(MusicaDTO dto) {
		MusicaBO musiBO = new MusicaBO();
		musiBO.setId(dto.getId());
		musiBO.setNome(dto.getNome());
		musiBO.setDuracao(dto.getDuracao());
		musiBO.setDataLancamento(dto.getDataLancamento());
		musiBO.setClassificacao(dto.getClassificacao());
		musiBO.setGenero(dto.getGenero());
		musiBO.setTamanhoMusica(dto.getTamanhoMusica());
		return musiBO;
	}
/**-------------------------------------------------------------------------------------------------------**/
	
	public static List<ArtistaDTO> convertListaBoEmDTO(List<ArtistaBO> bo) {
		List<ArtistaDTO> dtos = new ArrayList<>();
		for(ArtistaBO artistaBO : bo) {
			ArtistaDTO artiDTO = new ArtistaDTO();
			artiDTO.setId(artistaBO.getId());
			artiDTO.setNome(artistaBO.getNome());
			artiDTO.setIdade(artistaBO.getIdade());
			artiDTO.setListaMusicas(convertListaBoEmDTOs(artistaBO.getListaMusicas()));
			
			dtos.add(artiDTO);
		}
		return dtos;
	}

	public static List<MusicaDTO> convertListaBoEmDTOs(List<MusicaBO> bo) {
		List<MusicaDTO> dtos = new ArrayList<>();
		for(MusicaBO musicaBO : bo) {
			MusicaDTO musiDTO = new MusicaDTO();
			musiDTO.setId(musicaBO.getId());
			musiDTO.setNome(musicaBO.getNome());
			musiDTO.setDuracao(musicaBO.getDuracao());
			musiDTO.setClassificacao(musicaBO.getClassificacao());
			musiDTO.setDataLancamento(musicaBO.getDataLancamento());
			musiDTO.setGenero(musicaBO.getGenero());
			musiDTO.setTamanhoMusica(musicaBO.getTamanhoMusica());
			
			dtos.add(musiDTO);
		}
		return dtos;
	}
/**-------------------------------------------------------------------------------------------------------**/
	public static List<ArtistaBO> convertListaDTOEmBO(List<ArtistaDTO> DTO) {
		List<ArtistaBO> BOS = new ArrayList<>();
		for(ArtistaDTO artistaDTO : DTO) {
			ArtistaBO artiBO = new ArtistaBO();
			artiBO.setId(artistaDTO.getId());
			artiBO.setNome(artistaDTO.getNome());
			artiBO.setIdade(artistaDTO.getIdade());
			artiBO.setListaMusicas(convertListaDTOEmBOS(artistaDTO.getListaMusicas()));
			
			BOS.add(artiBO);
		}
		return BOS;
	}
		
	public static List<MusicaBO> convertListaDTOEmBOS(List<MusicaDTO> DTO) {
		List<MusicaBO> BOS = new ArrayList<>();
		for(MusicaDTO musicaDTO : DTO) {
			MusicaBO musiBO = new MusicaBO();
			musiBO.setId(musicaDTO.getId());
			musiBO.setNome(musicaDTO.getNome());
			musiBO.setDuracao(musicaDTO.getDuracao());
			musiBO.setClassificacao(musicaDTO.getClassificacao());
			musiBO.setDataLancamento(musicaDTO.getDataLancamento());
			musiBO.setGenero(musicaDTO.getGenero());
			musiBO.setTamanhoMusica(musicaDTO.getTamanhoMusica());
			
			BOS.add(musiBO);
		}
		return BOS;
	}
	
	
/**-------------------------------------------------------------------------------------------------------**/

	public static List<ArtistaBO> convertListaEntityEmBo(List<ArtistaEntity> entity) {
		List<ArtistaBO> bos = new ArrayList<>();
		for(ArtistaEntity artistaEntity : entity) {
			ArtistaBO artiBO = new ArtistaBO();
			artiBO.setId(artistaEntity.getId());
			artiBO.setNome(artistaEntity.getNome());
			artiBO.setIdade(artistaEntity.getIdade());
			artiBO.setListaMusicas(convertListaEntityEmBos(artistaEntity.getListaMusicasEntity()));
			
			bos.add(artiBO);
		}
		return bos;
	}
	
	public static List<MusicaBO> convertListaEntityEmBos(List<MusicaEntity> entity) {
		List<MusicaBO> bos = new ArrayList<>();
		for(MusicaEntity musicaEntity : entity) {
			MusicaBO musiBO = new MusicaBO();
			musiBO.setId(musicaEntity.getId());
			musiBO.setNome(musicaEntity.getNome());
			musiBO.setDuracao(musicaEntity.getDuracao());
			musiBO.setClassificacao(musicaEntity.getClassificacao());
			musiBO.setDataLancamento(musicaEntity.getDataLancamento());
			musiBO.setGenero(musicaEntity.getGenero());
			musiBO.setTamanhoMusica(musicaEntity.getTamanhoMusica());
			
			bos.add(musiBO);
		}
		return bos;
	}
	
/**-------------------------------------------------------------------------------------------------------**/
	
	public static List<ArtistaEntity> convertListaBoEmEntity(List<ArtistaBO> bo){
		List<ArtistaEntity> entitys = new ArrayList<>();
		for(ArtistaBO artBO : bo) {
			ArtistaEntity artEntity = new ArtistaEntity();
			artEntity.setId(artBO.getId());
			artEntity.setNome(artBO.getNome());
			artEntity.setIdade(artBO.getIdade());
			artEntity.setListaMusicasEntity(convertListaBoEmEntitys(artBO.getListaMusicas()));
		
			entitys.add(artEntity);
		}
		return entitys;
	}
	
	public static List<MusicaEntity> convertListaBoEmEntitys(List<MusicaBO> bo){
		List<MusicaEntity> entitys = new ArrayList<>();
		for(MusicaBO musiBO : bo) {
			MusicaEntity musiEntity = new MusicaEntity();
			musiEntity.setId(musiBO.getId());
			musiEntity.setNome(musiBO.getNome());
			musiEntity.setDuracao(musiBO.getDuracao());
			musiEntity.setGenero(musiBO.getGenero());
			musiEntity.setDataLancamento(musiBO.getDataLancamento());
			musiEntity.setClassificacao(musiBO.getClassificacao());
			musiEntity.setTamanhoMusica(musiBO.getTamanhoMusica());
			
			entitys.add(musiEntity);
		}
		return entitys;
	}
}
/**-------------------------------------------------------------------------------------------------------**/
	
	

	
	
			
		
	
	
	

	
	

