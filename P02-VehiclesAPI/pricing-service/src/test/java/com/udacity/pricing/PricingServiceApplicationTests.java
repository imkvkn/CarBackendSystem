package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.hamcrest.Matchers;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static com.udacity.pricing.service.PricingService.getPrice;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//@WebMvcTest(PricingController.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@MockBean
	PricingService pricingService;

	@Autowired
	MockMvc mockMvc;
	@Test
	public void test_get_all_prices() throws Exception {
		mockMvc.perform(get("/prices/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded").exists())
				.andExpect(jsonPath("$._embedded.prices").exists())
				.andExpect(jsonPath("$._embedded.prices", Matchers.hasSize(19)));
	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void test_get_price_by_id() throws Exception {
		mockMvc.perform(get("/prices/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.vehicleId").exists())
				.andExpect(jsonPath("$.vehicleId").value(1));
	}



}
