package com.wheremystuff.ItemServiceAPI;

import static org.hamcrest.Matchers.containsString;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ItemServiceApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnItem() throws Exception {
		this.mockMvc.perform(get("/api/items/100"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":100,\"name\":\"iPhone 10R\",\"type\":\"Electronics\",\"description\":\"Maksim's iPhone\",\"created_date\":null,\"color\":\"iPhone 10R\"}"));
	}

	@Test
	void shouldReturnType() throws Exception {
		this.mockMvc.perform(get("/api/types/1"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string("{\"id\":100,\"name\":\"iPhone 10R\",\"type\":\"Electronics\",\"description\":\"Maksim's iPhone\",\"created_date\":null,\"color\":\"iPhone 10R\"}"));
	}
}
