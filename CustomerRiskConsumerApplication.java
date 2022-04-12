package com.example.customerriskconsumer;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.customerriskconsumer.models.CustomerRisk;
import com.example.customerriskconsumer.models.CustomerRiskDto;
import com.example.customerriskconsumer.services.CustomerRiskService;

@SpringBootApplication
public class CustomerRiskConsumerApplication {

	@Autowired
	private CustomerRiskService customerRiskService;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRiskConsumerApplication.class, args);
	}
	
    @KafkaListener(id = "GazelleCustomerRisk", topics = "gazelleCustomerRisk")
    public void listen(CustomerRisk in) {
	    	  CustomerRiskDto cust = new CustomerRiskDto(in.getId() , in.isCrypto(), in.isGambling(), in.isAtRisk());
	    	  customerRiskService.saveCustomerRisk(cust);
		  }

}
