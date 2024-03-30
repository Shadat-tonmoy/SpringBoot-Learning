package com.example.crudrestdemo.services;

import com.example.crudrestdemo.data.dao.EmployeeDao;
import com.example.crudrestdemo.data.dao.EmployeeRepository;
import com.example.crudrestdemo.data.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    private EmployeeDao employeeDao;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, @Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) return employeeById.get();
        else throw new RuntimeException("Employee Not Found With Id : " + id);
    }

    @Transactional
    @Override
    public int update(Employee employee) {
//        return employeeRepository.update(employee);
        return -1;
    }

    @Transactional
    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }


    @Transactional
    @Override
    public int deleteById(int id) {
        employeeRepository.deleteById(id);
        return 1;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
