package com.compasso.compasso.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Client {
	
	@Id
	private String id;	
	@NotBlank(message = "The full name can't be empty")
	@NotNull(message = "The full name can't be null")
	private String fullName;
	@Past(message = "The birthday can't be a future date")
	@NotNull(message = "The birthday can't be null")
	private Date birthday;
	@NotBlank(message = "The gender can't be empty")
	@NotNull(message = "The gender can't be null")
	private String gender;
	@NotNull(message = "The city cant'be be null")
	@DBRef
	private City city;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
