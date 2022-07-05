package com.example.myspringboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringboot.exception.EmployeeNotFoundException;
import com.example.myspringboot.model.Employee;
import com.example.myspringboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}
		
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result=employeeRepository.findById(theId);

		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			//we didn't find the employee
			new EmployeeNotFoundException("Did not find employee id - "+theId);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}