package com.luv2code.springboot.crudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.crudDemo.DAO.EmployeeRepository;
import com.luv2code.springboot.crudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository  employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Employee not found " + id);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
