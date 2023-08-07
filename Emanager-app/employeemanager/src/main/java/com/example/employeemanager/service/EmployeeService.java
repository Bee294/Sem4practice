package com.example.employeemanager.service;

import com.example.employeemanager.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee updateEmployee(Employee employee);
    public Employee findEmployeeById(Long id);
    public void deleteEmployee(Long id);

}
