package com.rafaelnunes.deliverlanches.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class CategoriaResourceIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 
	 * Devera retorna todas as categorias
	 */
	@Test
	public void findAllShouldReturnCategoriesWhenSortByName() throws Exception {
		
		ResultActions result = 
						mockMvc.perform(get("/categorias")
										.accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}

}
