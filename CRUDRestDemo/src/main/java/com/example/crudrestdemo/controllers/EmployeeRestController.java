package com.example.crudrestdemo.controllers;

import com.example.crudrestdemo.data.dao.EmployeeDao;
import com.example.crudrestdemo.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {


    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeRestController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployeeList() {
        try {
            List<Employee> employees = employeeDao.getAll();
            System.out.println("GetEmployeeCalled");
            return employees;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
