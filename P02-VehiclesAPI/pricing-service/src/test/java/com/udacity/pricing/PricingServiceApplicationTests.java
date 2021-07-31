package com.udacity.pricing;

//import org.junit.Test;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



import static com.udacity.pricing.service.PricingService.getPrice;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(PricingController.class)
//@SpringBootTest
public class PricingServiceApplicationTests {

	@MockBean
	PricingService pricingService;

	@Autowired
	MockMvc mocMvc;
	@Test
	public void contextLoads() {
	}

}
