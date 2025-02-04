package com.ids.ProgettoIDS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Services.ComuneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProgettoIdsApplicationTests {

	@Autowired
	private ComuneService comuneService;

	@Test
	public void testSerializzazioneComune() throws JsonProcessingException {
		List<Comune> comuni = comuneService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(comuni);
		System.out.println(json);
	}

}
