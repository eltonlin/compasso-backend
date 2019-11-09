package com.compasso.compasso.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.compasso.compasso.entity.Client;

public interface IClientRepository extends MongoRepository<Client, String> {

	public List<Client> findByFullNameContains(String fullName);
	
}
