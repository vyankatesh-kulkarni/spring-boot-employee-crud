	 package com.luv2code.springboot.crudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.crudDemo.entity.Employee;
import com.luv2code.springboot.crudDemo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId")int theId) {
		Employee employee = employeeService.findById(theId);
		
		if(employee == null) {
			throw new RuntimeException("Employee not found " + theId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public void saveEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/delete-employee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") int theId) {
		
		employeeService.deleteById(theId);
	}
	
}




 
