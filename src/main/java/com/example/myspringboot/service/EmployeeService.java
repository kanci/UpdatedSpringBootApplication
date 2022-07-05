package com.example.myspringboot.service;

import java.util.List;

import com.example.myspringboot.model.Employee;


public interface EmployeeService {

	public Employee saveEmployee(Employee e);
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void deleteById(int theId);
}