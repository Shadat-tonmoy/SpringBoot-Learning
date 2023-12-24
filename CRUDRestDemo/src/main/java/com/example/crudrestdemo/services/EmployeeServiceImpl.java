package com.example.crudrestdemo.services;

import com.example.crudrestdemo.data.dao.EmployeeDao;
import com.example.crudrestdemo.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Transactional
    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Transactional
    @Override
    public int delete(Employee employee) {
        return employeeDao.delete(employee);
    }
}
