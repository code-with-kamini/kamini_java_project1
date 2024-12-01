package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;
@RestController
public class EmployeeController {
	
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome Employee Management System Project";
	}
	
	@Autowired
	EmployeeRepository repo;
	
	//get all the employee
	//localhost:8080/employee
	@GetMapping("/employee")
	public List<Employee>getAllEmployee(){
		List<Employee>employee = repo.findAll();
		
		return employee;
	}
	
	//localhost:8080/employee/1
		@GetMapping("/employee/{id}")
		public Employee getEmployee(@PathVariable int id) {
	    Employee employee =	repo.findById(id).get();
		return employee;
			
		}
		
		@PostMapping("/employee/add")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void createEmployee(@RequestBody Employee employee) {
			repo.save(employee);
			
		}
		
		@PutMapping("/employee/update/{id}")
		public Employee updateEmployee(@PathVariable int id) {
			Employee employee = repo.findById(id).get();
			employee.setName("tanishka");
			employee.setId(6);
			repo.save(employee);
			return employee;
			
		}
		@DeleteMapping("/employee/delete/{id}")
		public void removeEmployee(@PathVariable int id) {
			Employee employee = repo.findById(id).get();
			repo.delete(employee);
		}
}

