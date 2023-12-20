package com.example.crudrestdemo.data.dao;

import com.example.crudrestdemo.data.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("FROM employee", Employee.class);
        return employeeQuery.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }
}
