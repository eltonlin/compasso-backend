package com.compasso.compasso.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.compasso.compasso.api.CityController;
import com.compasso.compasso.entity.City;
import com.compasso.compasso.service.ICityService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CityController.class)
public class CityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ICityService cityService;

	@Test
	public void createNewCity() throws Exception {
		City mockCity = new City( "Recife", "PE");
		Mockito.when(cityService.saveCity(Mockito.any(City.class))).thenReturn(mockCity);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/city")
			      .content(asJsonString(new City("Recife", "PE")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
	}
	
	@Test
	public void getCityByName() throws Exception {
		City mockCity = new City("Recife", "PE");
		
		Mockito.when(cityService.findByName(Mockito.anyString())).thenReturn(mockCity);
		Mockito.when(cityService.findByState(Mockito.anyString())).thenReturn(mockCity);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/city")
				.param("name", "Recife")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	@Test
	public void getCityByState() throws Exception {
		City mockCity = new City("Recife", "PE");
		
		Mockito.when(cityService.findByState(Mockito.anyString())).thenReturn(mockCity);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/city")
				.param("state", "Recife")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	
	private String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
