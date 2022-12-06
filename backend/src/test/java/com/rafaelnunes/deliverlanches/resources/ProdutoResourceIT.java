package com.rafaelnunes.deliverlanches.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProdutoResourceIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 
	 * Devera retorna todos os produtos
	 */
	@Test
	public void findAllShouldReturnProducts() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/produtos").accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	/**
	 * Devera retorna produtos com a categoria hamburguer
	 * @throws Exception 
	 */
	@Test
	public void findShouldReturnProductsWhenCategoryHamburguer() throws Exception {
		ResultActions result = mockMvc.perform(get("/produtos?categoriaId=1").accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.[0].id").isNotEmpty());
	}

}
