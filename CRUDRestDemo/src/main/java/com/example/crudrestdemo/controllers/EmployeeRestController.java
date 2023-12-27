package com.example.crudrestdemo.controllers;

import com.example.crudrestdemo.data.dao.EmployeeDao;
import com.example.crudrestdemo.data.entities.Employee;
import com.example.crudrestdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployeeList() {
        try {
            List<Employee> employees = employeeService.getAll();
            System.out.println("GetEmployeeCalled");
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) throws Exception {
        try {
            Employee employee = employeeService.getById(id);
            System.out.println("GetEmployeeWithId : " + id);
            if (employee == null) {
                throw new Exception("Employee Not Found With Id : " + id);
            } else {
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping("/employee")
    Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }


    @PutMapping("/employee")
    Employee updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }
}
