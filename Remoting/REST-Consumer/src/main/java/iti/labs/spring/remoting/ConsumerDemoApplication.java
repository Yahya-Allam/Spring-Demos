package iti.labs.spring.remoting;

import iti.labs.spring.remoting.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{

		return  args -> {

			String uri = "http://localhost:8080/api/";
			Customer customer = restTemplate.getForObject(uri+"customers/1", Customer.class);
			System.out.println(customer);

			HttpEntity<Customer> httpEntity = new HttpEntity<>(new Customer("ITI", "Smart Village", "0123456789"));
			Customer responseCustomer = restTemplate.postForObject(uri+"/customers",httpEntity, Customer.class);
			logger.info("Returned Customer {}", responseCustomer);

		};
	}

}
