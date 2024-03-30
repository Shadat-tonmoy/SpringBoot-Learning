package com.example.crudrestdemo.data.dao;

import com.example.crudrestdemo.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
