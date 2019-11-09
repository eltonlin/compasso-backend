package com.compasso.compasso.service;

import com.compasso.compasso.entity.City;

public interface ICityService {
	
	/**
	 * Service to save the city
	 * 
	 * @param city
	 * @return city
	 */
	public City saveCity(City city);
	
	/**
	 * Service to find a city by name of city
	 * 
	 * @param name
	 * @return city
	 */
	public City findByName(String name);
	
	
	/**
	 * Service to find a city by state of city
	 * 
	 * @param state
	 * @return city
	 */
	public City findByState(String state);
	
}
