package com.example.myspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.myspringboot.enums.EmployeeEnumsGender;

@Entity
@Table(name="employee")
public class Employee {
	//define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	//will have to do validator for gender, "Male" request for M response, "Female" request for F response, by using enums
	@Enumerated()
	@Column(name="gender")
	private EmployeeEnumsGender gender;
	
	@Column(name="email")
	private String email;
	
	//default constructor
	public Employee() {
		
	}
	
	//parameterized constructor
	public Employee(String firstName, String lastName, EmployeeEnumsGender gender, int age, 
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}

	//getters and setters
	public EmployeeEnumsGender getGender() {
		return gender;
	}

	public void setGender(EmployeeEnumsGender gender) {
		this.gender = gender;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}