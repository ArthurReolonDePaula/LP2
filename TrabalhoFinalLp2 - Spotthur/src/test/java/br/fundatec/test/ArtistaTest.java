package br.fundatec.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class ArtistaTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crudSpotthur() throws Exception {
		postArtista();
		getArtista();
		getArtistaEspecifico();
	}

	private void getArtistaEspecifico() throws Exception {
		String location = "/spotthur/artista/{id}";

		String json = "{\"nome\":\"FulanoA\"," + "\"idade\":23,";
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMDowMjoyNS44NjMiLCJ1c3VhcmlvIjoiYWRtIn0.3Pn87bt3xbvS16Pe-Kvy52HD57Nqjq0BPKfxH6xczzw\r\n"
						+ "")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("FulanoA")).andExpect(jsonPath("$.idade").value("23"));
	}

	private void getArtista() throws Exception {
		String location = "/spotthur/artista/";

		String json = "{\"nome\":\"FulanoA\"," + "\"idade\":23,";
		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMDowMjoyNS44NjMiLCJ1c3VhcmlvIjoiYWRtIn0.3Pn87bt3xbvS16Pe-Kvy52HD57Nqjq0BPKfxH6xczzw\r\n"
						+ "")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("FulanoA")).andExpect(jsonPath("$.idade").value("23"));
	}

	private void postArtista() throws Exception {
		String location = "/spotthur/artista/";
		
		String json = "{\"nome\":\"FulanoA\"," + "\"idade\":23,";
		mockMvc.perform(post(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMDowMjoyNS44NjMiLCJ1c3VhcmlvIjoiYWRtIn0.3Pn87bt3xbvS16Pe-Kvy52HD57Nqjq0BPKfxH6xczzw\r\n"
						+ "")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.nome").value("FulanoA")).andExpect(jsonPath("$.idade").value("23"));
	}
}
