package com.luv2code.springboot.crudDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.crudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
