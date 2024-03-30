package com.example.crudrestdemo.data.dao;

import com.example.crudrestdemo.data.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return employeeQuery.getResultList();
    }

    @Override
    public Employee getById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public Employee save(Employee employee) {
        Employee updatedEmployee = entityManager.merge(employee);
        return updatedEmployee;
    }

    @Override
    public int deleteById(int id) {
        Query deleteQuery = entityManager.createQuery("DELETE FROM Employee WHERE id = :id");
        deleteQuery.setParameter("id", id);
        System.out.println("Delete By Id : " + id);
        int result = deleteQuery.executeUpdate();
        System.out.println("Delete Query Result : " + result);
        return result;
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }


}
