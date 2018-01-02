package br.fundatec.lp2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContatoTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crudContato() throws Exception {
		postContatoDTO();
		getListaContatoDTO();
		putContatoDTO();
		getContatoDTO();
		deletaContatoDTO();
	}
	
	@Test
	public void crudContato2() throws Exception {
	getContatoIdInexistente();
	deletaContatoIdInexistente();
	postContatoAtributosInvalidos();
	putContatoAtributosInvalidos();
	}
/**------------------------------------------------------------------------------------------------------------------------------------------------------------------------**/

		/** TESTES DE ERRO **/
	private void putContatoAtributosInvalidos() throws Exception {
		String location = "/agenda/contatos/1";
		
		// Objeto Json
		String json = "{\"nome\":\"\",\"telefone\":\"\",\"email\":\"\"}";

		// Request da informação
		mockMvc.perform(put(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E")
				.content(json))

				// Response da informação
				.andExpect(status().isBadRequest());
	}
/**------------------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void postContatoAtributosInvalidos() throws Exception{
		String location = "/agenda/contatos";
	
		// Objeto Json
		String json = "{\"nome\":\"\",\"telefone\":\"\",\"email\":\"\"}";

		// Request da informação
		mockMvc.perform(post(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E")
				.content(json))

				// Response da informação
				.andExpect(status().isBadRequest());
	}
/**------------------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void deletaContatoIdInexistente() throws Exception {
		String location = "/agenda/contatos/2";
		
		//Request da informação
		mockMvc.perform(delete(location).header("Content-Type", "application/json").header("token", 
			"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E"))
		
		//Response da informação
		.andExpect(status().isNotFound());
	}
/**------------------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void getContatoIdInexistente() throws Exception {
		String location = "/agenda/contatos/2";
		
		//Request da informação
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E"))
		
		//Response da informação
			.andExpect(status().isNotFound());
	}
/**------------------------------------------------------------------------------------------------------------------------------------------------------------------------**/
		/** TESTES FELIZES **/
	private void getContatoDTO() throws Exception {
		String location = "/agenda/contatos/1";

		//Request da informação
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E"))
		
		//Response da informação
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("Arthas")).andExpect(jsonPath("$.telefone").value("85123456")).andExpect(jsonPath("$.email").value("arthas@gmail.com"));
	}
/**----------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void getListaContatoDTO() throws Exception {
		String location = "/agenda/contatos";

		//Request da informação
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E"))

		//Response da informação
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].nome").value("Muradin")).andExpect(jsonPath("$[0].telefone").value("99123456")).andExpect(jsonPath("$[0].email").value("muradin@gmail.com"));

	}
/**----------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void postContatoDTO() throws Exception {
		String location = "/agenda/contatos";

		// Objeto Json
		String json = "{\"nome\":\"Muradin\", \"telefone\":\"99123456\", \"email\":\"muradin@gmail.com\"}";

		// Request da informação
		mockMvc.perform(post(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E")
				.content(json))

				// Response da informação
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("Muradin")).andExpect(jsonPath("$.telefone").value("99123456")).andExpect(jsonPath("$.email").value("muradin@gmail.com"));

	}
/**----------------------------------------------------------------------------------------------------------------------------------------------------------------**/

	private void deletaContatoDTO() throws Exception {
		String location = "/agenda/contatos/1";
		
		//Request da informação
		mockMvc.perform(delete(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E"))

		//Response da informação
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$").value("Contato deletado com sucesso"));
	}
/**----------------------------------------------------------------------------------------------------------------------------------------------------------------**/
	private void putContatoDTO() throws Exception {
		String location = "/agenda/contatos/1";

		//Objeto Json
		String json = "{\"nome\":\"Arthas\", \"telefone\":\"85123456\", \"email\":\"arthas@gmail.com\"}";

		//Request da informação
		mockMvc.perform(put(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xOSAyMDoyMjoyNy43MTIiLCJ1c3VhcmlvIjoiYXJ0aHVyIn0.gckw8dNDm_j9xqExbnSHaLU2j5cjlI90mcyxwj63e6E")
				.content(json))
		
		//Response da informação
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("$.nome").value("Arthas")).andExpect(jsonPath("$.telefone").value("85123456")).andExpect(jsonPath("$.email").value("arthas@gmail.com"));
	}

}
