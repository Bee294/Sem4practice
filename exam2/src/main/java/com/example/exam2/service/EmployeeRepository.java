package com.example.exam2.service;

import com.example.exam2.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;

    void UpdateEmployee(Employee employee,int id) throws SQLException;
    boolean deleteEmployee(int id) throws SQLException;
}
