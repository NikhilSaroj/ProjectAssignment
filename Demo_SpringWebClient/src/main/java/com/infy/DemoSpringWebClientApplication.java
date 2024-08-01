package com.infy;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import com.infy.dto.CustomerDTO;
import com.infy.dto.CustomerTransactionDTO;


@SpringBootApplication
public class DemoSpringWebClientApplication implements CommandLineRunner{

	private static final Logger LOGGER = LogManager.getLogger(DemoSpringWebClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringWebClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//to get the specific customer details
		//getCustomerTransaction(2);
		System.out.println("Hello");
		//To add the customer details
//		CustomerTransactionDTO customer =  new CustomerTransactionDTO();
//		customer.setCustomerId(103);
//		customer.setTransactId(5);
//		customer.setTransactDate(null);
//		customer.setSpentDetails("Shopping");
//		customer.setAmount(300);
//		addCustomerTransaction(customer);
//		
		//To update the customer details
//		CustomerTransactionDTO customer1 =  new CustomerTransactionDTO();
//		customer1.setTransactId(1);
//		customer1.setSpentDetails("Shopping");
//		updateCustomerTransaction(customer1);
		
		//To delete the customer details
//		deleteCustomerTransaction(1);		
	}
	
	public void getCustomerTransaction(Integer transactId) {
		
		String url = "http://localhost:8765/reward/customersTransaction/{transactId}";
		WebClient webclient = WebClient.create();
		
		CustomerTransactionDTO customertransactionDTO = webclient.get()
				.uri(url,transactId)
				.retrieve()
				.bodyToMono(CustomerTransactionDTO.class)
				.block();
		
		LOGGER.info(customertransactionDTO);
        LOGGER.info("\n");		
	}
	
	public void addCustomerTransaction(CustomerTransactionDTO customertransactionDTO) {
		
		String url = "http://localhost:8765/reward/customersTransaction";
		WebClient webclient = WebClient.create();
		
		String response = webclient.post()
				.uri(url)
				.bodyValue(customertransactionDTO)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		LOGGER.info(response);
		LOGGER.info("\n");
	}
	
	public void updateCustomerTransaction(CustomerTransactionDTO customertransactionDTO) {
		
		String url = "http://localhost:8765/reward/customersTransaction";
		
		WebClient webclient = WebClient.create();
		
		String response = webclient.put()
				.uri(url,customertransactionDTO.getTransactId())
				.bodyValue(customertransactionDTO)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		LOGGER.info(response);
		LOGGER.info("\n");

	}
	
	
	public void deleteCustomerTransaction(Integer transactId) {
		
		String url="http://localhost:8765/reward/customersTransaction/{transactId}";
		
		WebClient webclient = WebClient.create();
		webclient.delete()
		         .uri(url,transactId)
		         .exchange()
		         .subscribe( response -> {
		        	 if(response.statusCode().value()==200)
		        		 LOGGER.info("Customer Deleted");
		        	 else
		        		 LOGGER.error("Failed to Delete");
		         });
	}

}
