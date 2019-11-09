package com.compasso.compasso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compasso.compasso.entity.City;
import com.compasso.compasso.repository.ICityRepository;
import com.compasso.compasso.service.ICityService;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City findByName(String name) {
		return cityRepository.findByName(name).get();
	}

	@Override
	public City findByState(String state) {
		return cityRepository.findByState(state).get();
	}

}
