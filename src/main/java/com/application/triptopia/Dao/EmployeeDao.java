package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;

import java.util.Collection;

public interface EmployeeDao {
    Collection<Employee> getAllEmployee();

    void addEmployee(int key, Employee newEmployee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    void updateEmployee(Employee employee);

    void insertEmployeeToDB(Employee employee);
}