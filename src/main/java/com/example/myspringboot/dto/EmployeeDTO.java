package com.example.myspringboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.myspringboot.enums.EmployeeEnumsGender;

//request page, like dto, it will come from front end application, postman...
//dto may include some validations, dto is data transfer object..
public class EmployeeDTO {
	private int id;

	//name should not be null or empty, at least 2 characters
	@NotBlank
	@Size(min=2, message="at least 2 characters")
	private String firstName;
	
	@NotBlank
	@Size(min=2, message="at least 2 characters")
	private String lastName;

	 @NotNull(message = "ERROR_EMPTY_VALUE")
	private EmployeeEnumsGender gender;	
	
	@Email
	private String email;
		
	//constructors
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(String firstName, String lastName, EmployeeEnumsGender gender, 
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender=gender;
		this.email = email;
	}

	//setters and getters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public EmployeeEnumsGender getGender() {
		return gender;
	}
	
	public void setGender(EmployeeEnumsGender gender) {
		this.gender=gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}