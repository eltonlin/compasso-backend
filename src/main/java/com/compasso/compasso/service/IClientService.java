package com.compasso.compasso.service;

import java.util.List;

import com.compasso.compasso.entity.Client;

public interface IClientService {
	
	public Client saveClient(Client client);
	
	public Client updateClient(String id, Client fullName);
	
	public List<Client> findClientByName(String fullName);
	
	public Client findClientById(String id);
	
	public void deleteClientById(String id);
	
	
	
	
}
