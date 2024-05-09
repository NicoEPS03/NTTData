package com.nttdata.prueba;

import com.nttdata.prueba.entity.Cliente;
import com.nttdata.prueba.service.imp.IClienteServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IClienteServiceImp service;

	@Test
	void obtenerCliente() throws Exception {
		doReturn( new Cliente("C", "23445322", "Juan", "Luis",
				"González", "Rodríguez", "978312312", "calle punto a #12a12", "Madrid")).when(service).getClient("C", "23445322");
		mockMvc.perform(get("/cliente/obtener/C/23445322"))
				.andExpect(status().isOk());
	}

	@Test
	void calcularFactorial_OK() throws Exception {
		mockMvc.perform(get("/api/factorial/5"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numero").value(5))
				.andExpect(jsonPath("$.factorial").value(120));
	}

	@Test
	void obtenerSaludo_OK() throws Exception {
		mockMvc.perform(get("/api/hola/kraken"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.mensaje").value("¡Hola desde kraken!"));
	}


}
