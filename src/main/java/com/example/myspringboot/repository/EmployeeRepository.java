package com.example.myspringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.myspringboot.model.Employee;


@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//you don't have to add anything...
}
