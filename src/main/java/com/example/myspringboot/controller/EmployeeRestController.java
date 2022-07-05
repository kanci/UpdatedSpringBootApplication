package com.example.myspringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringboot.dto.EmployeeDTO;
import com.example.myspringboot.exception.EmployeeNotFoundException;
import com.example.myspringboot.model.Employee;
import com.example.myspringboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	
	//add mapping for POST /employees - add new employee, (create)
	
	@PostMapping("/employees") 
	public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO request) {
		//also just in case they pass and id in JSON... set id to 0
		
		//make sure to convert employeedto to employee entity
		Employee employee = new Employee();
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setGender(request.getGender());	
		employee.setEmail(request.getEmail());
				
		Employee savedEmployee = employeeService.saveEmployee(employee);
		
		//convert Employee entity to employeeDTO class, response
		EmployeeDTO employeeResponse = new EmployeeDTO();
		employeeResponse.setId(savedEmployee.getId());
		employeeResponse.setFirstName(savedEmployee.getFirstName());
		employeeResponse.setLastName(savedEmployee.getLastName());
		employeeResponse.setGender(savedEmployee.getGender());
		employeeResponse.setEmail(savedEmployee.getEmail());
		
		return new ResponseEntity<EmployeeDTO>(employeeResponse, HttpStatus.CREATED);
	}
	
	//expose "/employees" and return list of employees,
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	//add mapping for GET /employees/{employeeId}, read
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found - "+employeeId);//this should WORK!!
		}
		return theEmployee;
	}
	
	//add mapping for PUT /employees - update existing employee
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="employeeId") int id,    @Valid @RequestBody Employee theEmployee) throws Exception {
		Employee tempEmployee = employeeService.findById(id);
		if(tempEmployee!=null) {
			tempEmployee.setId(theEmployee.getId());
			tempEmployee.setFirstName(theEmployee.getFirstName());
			tempEmployee.setLastName(theEmployee.getLastName());
			tempEmployee.setGender(theEmployee.getGender());
			tempEmployee.setEmail(theEmployee.getEmail());
			final Employee updatedEmployee=employeeService.saveEmployee(theEmployee);
			
			//make sure to save id... 
			//return theEmployee
			return ResponseEntity.ok(updatedEmployee);
		}
		else {
			throw new EmployeeNotFoundException("Employee id not found - "+id);
		}
	}
	
	//add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		
		//throw exception if null
		if (tempEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
		}
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - "+employeeId;
	}
}