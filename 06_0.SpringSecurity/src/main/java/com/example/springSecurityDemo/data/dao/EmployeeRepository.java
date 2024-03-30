package com.example.springSecurityDemo.data.dao;

import com.example.springSecurityDemo.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
