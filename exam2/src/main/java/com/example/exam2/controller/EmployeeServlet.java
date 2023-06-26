package com.example.exam2.controller;

import com.example.exam2.entity.Employee;
import com.example.exam2.service.EmployeeRepositoryImpl;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeServlet extends HttpServlet {
    private EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            employeeRepository.getAllEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String birthDay = request.getParameter("birthDay");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDay1 = null;
        try {
            birthDay1 = new Date(dateFormat.parse(birthDay).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        Employee employee = new Employee(0, fullName, birthDay1, address, position, department);
        try {
            employeeRepository.addEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/list.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = request.getParameter(Employee);
        String id = request.getParameter("id");
        try {
            employeeRepository.UpdateEmployee(Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            employeeRepository.deleteEmployee(Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }



}
