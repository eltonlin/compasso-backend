package com.compasso.compasso.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class City {
	
	@Id
	private String id;
	@NotBlank(message = "The name of the city can't be empty")
	@NotNull(message = "The name of the city can't be null")
	private String name;
	@NotBlank(message = "The state of the city can't be empty")
	@NotNull(message = "The state of the city can't be null")
	@Size(min=2, message = "The state should be have 2 characteres in the minimum")
	private String state;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
