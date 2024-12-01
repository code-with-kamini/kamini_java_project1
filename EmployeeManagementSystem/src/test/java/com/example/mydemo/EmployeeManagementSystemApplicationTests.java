package com.example.mydemo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo1.EmployeeManagementSystemApplication;
import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;





@SpringBootTest(classes = EmployeeManagementSystemApplication.class)


class EmployeeManagementSystemApplicationTests {
	
		
	
	
    @Autowired
	private EmployeeRepository repo;
    
    @Test
    public void testGetAllData() {
    	
    	Iterable<Employee> ee = repo.findAll();
    	assertThat(ee).size().isGreaterThan(0);
    }
  
    
   
   @Test
	public void testInsert() {
    	Employee e = new Employee();
    	e.setId(45);
    	e.setName("Kamini Chavan");
    	e.setSalary(250000);
    	e.setDepartment("Manager");
      
    	
   }
    
    @Test
    public void testRealAll() {
    	
    	List<Employee> List = repo.findAll();
    	assertThat(List).size().isGreaterThan(0);
    }
    
 
    
 
    
    @Test
    public void testDelete() {
    	
    	repo.deleteById(45);
    	assertThat(repo.existsById(45)).isFalse();
    }
    
    
}
