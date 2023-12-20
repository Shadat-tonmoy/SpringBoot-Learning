package com.example.crudrestdemo.data.dao;

import com.example.crudrestdemo.data.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    Employee getById(int id);

    int update(Employee employee);
}
