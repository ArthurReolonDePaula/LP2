package br.fundatec.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

public class MusicaTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crudSpotthur() throws Exception {
		postMusicaDoArtista();
		getMusica();
		deletarMusica();
		putMusica();
	}

	private void postMusicaDoArtista() throws Exception {
		String location = "/spotthur/musica/{idArtista}";

		String json = "{\"nome\":\"Prismo-Stronger\"," + "\"duracao\":\"3:32\"," + "\"genero\":\"eletronica\","
				+ "\"dataLancamento\":\"2017-11-10\"," + "\"classificacao\":\"otima\"," + "\"tamanhoMusica\":\"5mb\",";
		mockMvc.perform(post(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("Prismo-Stronger")).andExpect(jsonPath("$.duracao").value("3:32"))
				.andExpect(jsonPath("$.genero").value("eletronica"))
				.andExpect(jsonPath("$.dataLançamento").value("2017-11-10"))
				.andExpect(jsonPath("$.classificacao").value("otima"))
				.andExpect(jsonPath("$.tamanhoMusica").value("5mb"));
	}

	private void getMusica() throws Exception {
		String location = "/spotthur/musica/{idMusica}";

		String json = "{\"nome\":\"Prismo-Stronger\"," + "\"duracao\":\"3:32\"," + "\"genero\":\"eletronica\","
				+ "\"dataLancamento\":\"2017-11-10\"," + "\"classificacao\":\"otima\"," + "\"tamanhoMusica\":\"5mb\",";
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("Prismo-Stronger")).andExpect(jsonPath("$.duracao").value("3:32"))
				.andExpect(jsonPath("$.genero").value("eletronica"))
				.andExpect(jsonPath("$.dataLançamento").value("2017-11-10"))
				.andExpect(jsonPath("$.classificacao").value("otima"))
				.andExpect(jsonPath("$.tamanhoMusica").value("5mb"));
	}

	private void deletarMusica() throws Exception {
		String location = "/spotthur/musica/{idArtista}/{idMusica}";

		mockMvc.perform(delete(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				).andExpect(status().isOk()).andExpect(jsonPath("$").value("Musica Deletada com Sucesso"));
		}

	private void putMusica() throws Exception {
		String location = "/spotthur/musica/{idMusica}";

		String json = "{\"nome\":\"Dezembra\"," + "\"duracao\":\"3:18\"," + "\"genero\":\"eletronica\","
				+ "\"dataLancamento\":\"2017-11-15\"," + "\"classificacao\":\"boa\"," + "\"tamanhoMusica\":\"3mb\",";
		mockMvc.perform(put(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("Dezembra")).andExpect(jsonPath("$.duracao").value("3:18"))
				.andExpect(jsonPath("$.genero").value("eletronica"))
				.andExpect(jsonPath("$.dataLançamento").value("2017-11-15"))
				.andExpect(jsonPath("$.classificacao").value("boa"))
				.andExpect(jsonPath("$.tamanhoMusica").value("3mb"));
	}
}
