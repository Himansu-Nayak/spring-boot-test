package com.org.test.controller;

import com.org.test.entity.Item;
import com.org.test.service.ItemBusinessService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@MockBean
	private ItemBusinessService businessService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHelloWorld() throws Exception {

//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/hello-world")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
//				.andReturn();

		mockMvc.perform(get("/hello-world")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.param("type", "")
				.param("id", "b6b94d9f-215f-474b-a72c-dc0b6f4a0078")
				.param("id", "b6b94d9f-215f-474b-a72c-dc0b6f4a0070")
		).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
//				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$.id", Matchers.is(1)))
				.andExpect(jsonPath("$.name", Matchers.is("Ball")))
				.andExpect(jsonPath("$.price", Matchers.is(10)))
				.andExpect(jsonPath("$.quantity", Matchers.is(100)));
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void retrieveListOfItems() throws Exception {
		when(businessService.retrieveHardcodedItem()).thenReturn(asList(new Item(1, "Ball", 10, 100)));

		mockMvc.perform(get("/item-from-service-service")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", Matchers.is(1)))
				.andExpect(jsonPath("$[0].name", Matchers.is("Ball")))
				.andExpect(jsonPath("$[0].price", Matchers.is(10)))
				.andExpect(jsonPath("$[0].quantity", Matchers.is(100)));

	}

}
