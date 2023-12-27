package com.example.crudrestdemo.services;

import com.example.crudrestdemo.data.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    int update(Employee employee);

    Employee save(Employee employee);

    void delete(Employee employee);

    int deleteById(int id);


}
