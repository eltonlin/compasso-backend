package com.compasso.compasso.service.impl;

import java.net.ConnectException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.compasso.entity.City;
import com.compasso.compasso.entity.Client;
import com.compasso.compasso.exception.BusinessException;
import com.compasso.compasso.repository.ICityRepository;
import com.compasso.compasso.repository.IClientRepository;
import com.compasso.compasso.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	private static final String MESSAGE_REQUIRED_ID_CITY = "The city should be have a id";

	private static final String MESSAGE_CITY_NOT_EXIST = "The city not exist";

	private static final String MESSAGE_CLIENT_NOT_EXIST = "The client not exist";
	
	private static final String MESSAGE_REQUIRED_FULLNAME = "The full name is required";
	
	private static final String MESSAGE_REQUIRED_ID_CLIENT = "The id of client is required";

	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public Client saveClient(Client client) {

		if (client.getCity().getId() == null) {
			throw new BusinessException(MESSAGE_REQUIRED_ID_CITY);
		}

		Optional<City> city = null;

		city = cityRepository.findById(client.getCity().getId());

		if (!city.isPresent()) {
			throw new BusinessException(MESSAGE_CITY_NOT_EXIST);
		}

		client.setCity(city.get());
		return clientRepository.save(client);

	}

	@Override
	public Client updateClient(String id, Client client) {
		Optional<Client> clientFounded = clientRepository.findById(id);

		if (!clientFounded.isPresent()) {
			throw new BusinessException(MESSAGE_CLIENT_NOT_EXIST);
		}

		clientFounded.get().setFullName(client.getFullName());

		return clientRepository.save(clientFounded.get());

	}

	@Override
	public List<Client> findClientByName(String fullName) {
		
		if(fullName == null || fullName.isEmpty()) {
			throw new BusinessException(MESSAGE_REQUIRED_FULLNAME);
		}
		return clientRepository.findByFullNameContains(fullName);
	}

	@Override
	public Client findClientById(String id) {
		
		if(id == null || id.isEmpty()) {
			throw new BusinessException(MESSAGE_REQUIRED_ID_CLIENT);
		}
		
		return clientRepository.findById(id).get();
	}

	@Override
	public void deleteClientById(String id) {
		
		if(id == null || id.isEmpty()) {
			throw new BusinessException(MESSAGE_REQUIRED_ID_CLIENT);
		}
		
		clientRepository.deleteById(id);

	}

}
