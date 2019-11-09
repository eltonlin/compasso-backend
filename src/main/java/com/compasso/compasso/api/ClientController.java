package com.compasso.compasso.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.compasso.entity.Client;
import com.compasso.compasso.service.IClientService;

@RequestMapping("/client")
@RestController
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> saveClient(@Valid @RequestBody Client client) {
		
		Client clientSaved =  clientService.saveClient(client);
		
		return new ResponseEntity<>(clientSaved, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findClientById(@PathVariable String id) {
		
		Client client = clientService.findClientById(id);
		
		return new ResponseEntity<>(client, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findClientByFullName(
			@RequestParam(value = "fullName", required = false ) String fullName ) {
		
		List<Client> client = clientService.findClientByName(fullName);
		
		return new ResponseEntity<>(client, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClientById(@PathVariable String id) {
		
		try {
			clientService.deleteClientById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(null, HttpStatus.OK); 
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateFullNameOfClientById(@PathVariable String id, @Valid @RequestBody Client client) {
		
		Client clientUpdated = clientService.updateClient(id, client);
		
		return new ResponseEntity<>(clientUpdated, HttpStatus.OK);
		
	}
	
	
}
