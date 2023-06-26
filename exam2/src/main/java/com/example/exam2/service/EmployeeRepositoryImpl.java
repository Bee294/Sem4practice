package com.example.exam2.service;

import com.example.exam2.config.DbConnection;
import com.example.exam2.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    Connection connection = DbConnection.openConnection();

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (fullName, dateOfBirth, address, position, department) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFullName());
            statement.setDate(2, new java.sql.Date(employee.getBirthDay().getTime()));
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPosition());
            statement.setString(5, employee.getDepartment());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                Date dateOfBirth = resultSet.getDate("birthDay");
                String address = resultSet.getString("address");
                String position = resultSet.getString("position");
                String department = resultSet.getString("department");
                Employee employee = new Employee(id, fullName, dateOfBirth, address, position, department);
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public void UpdateEmployee(Employee employee, int id) throws SQLException {

        String query = "update employee set fullName =?, birthDay =?, address =?, position = ?,department =?  where id =?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getFullName());
        preparedStatement.setDate(2, (Date) employee.getBirthDay());
        preparedStatement.setString(3,employee.getAddress());
        preparedStatement.setString(4,employee.getPosition());
        preparedStatement.setString(5, employee.getDepartment());
        preparedStatement.setInt(6,employee.getId());
        preparedStatement.executeUpdate();
    }


    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        String query = "delete from product where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        return true;
    }


}
