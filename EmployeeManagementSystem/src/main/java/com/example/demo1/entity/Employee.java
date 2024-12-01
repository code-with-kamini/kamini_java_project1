package com.example.demo1.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;



@Entity
@Table(name = "employees")
public class Employee {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotBlank(message = "Enter a valid Employee Name")
	private String name;
	

	@NotNull
	@Size(min =5, message = "Employee salary should have at least 5 number")
	private int salary;
	
	@NotNull(message = "Department cannot be null")
	private String Department;
	
	@Email(message = "Please enter a valid email Id")
	@NotNull(message = "Email cannot be Null")
	private String Email;
	
	@NotNull(message = "Birthday date cannot be Null")
	private  LocalDate Birthday;
	
	
	public Employee() {
		
	}


	public Employee(int id, String name, int salary, String department, String email, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		Department = department;
		Email = email;
		Birthday = birthday;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public LocalDate getBirthday() {
		return Birthday;
	}


	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", Department=" + Department
				+ ", Email=" + Email + ", Birthday=" + Birthday + "]";
	}


}
	

	
	
	



