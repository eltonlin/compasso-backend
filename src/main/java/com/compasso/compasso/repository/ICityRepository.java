package com.compasso.compasso.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.compasso.compasso.entity.City;

public interface ICityRepository extends MongoRepository<City, String> {

	public Optional<City> findByName(String name);
	
	public Optional<City> findByState(String state);
	
}
