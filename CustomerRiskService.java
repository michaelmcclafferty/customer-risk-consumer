package com.example.customerriskconsumer.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerriskconsumer.models.CustomerRisk;
import com.example.customerriskconsumer.models.CustomerRiskDto;
import com.example.customerriskconsumer.repos.CustomerRiskRepository;

@Service
public class CustomerRiskService {
	
	@Autowired
	private CustomerRiskRepository repo;
	
	
	public void saveCustomerRisk(CustomerRiskDto customerRisk) {
		repo.save(customerRisk);
	}
	
	public CustomerRiskDto findbyId(int id) {
		return repo.findById(id);
	}

}
