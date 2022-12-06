package com.rafaelnunes.deliverlanches.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PedidoResourceIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	private String email;
	private String senha;
	
	@BeforeEach
	void setUp() throws Exception {
		
		email = "rafael@gmail.com";
		senha = "123456";
	}
	
	/**
	 * Devera retonar todos os pedidos quando o usuario estiver logado;
	 * 
	 */
	@Test
	public void findAllShouldRetunOrdersWhenLoggedUser() throws Exception {
		
		String token = tokenUtil.obterAccessToken(mockMvc, email, senha);
		
		ResultActions result = mockMvc.perform(get("/pedidos")
												.header("Authorization", "Bearer " + token)
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$[0].id").isNotEmpty());
	}

}
