package com.example.customerriskconsumer.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customerriskconsumer.models.CustomerRiskDto;


public interface CustomerRiskRepository extends MongoRepository<CustomerRiskDto, String>{

	public CustomerRiskDto findById(int id);
}
