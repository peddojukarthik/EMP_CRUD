package com.empcrud;

import java.io.IOException;

import java.sql.*;
import java.util.*;

public class empADA 
{
  public void addEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO employees (name, department, email, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setString(3, emp.getEmail());
            stmt.setDouble(4, emp.getSalary());
            stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
          
        }
    }

    // Read all employees
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setEmail(rs.getString("email"));
                emp.setSalary(rs.getDouble("salary"));
                list.add(emp);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
          
        }
        return list;
       
    }

    // Update employee
    public void updateEmployee(Employee emp) throws SQLException {
        String query = "UPDATE employees SET name=?, department=?, email=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setString(3, emp.getEmail());
            stmt.setDouble(4, emp.getSalary());
            stmt.setInt(5, emp.getId());
            stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
          
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
          
        }
    }
}
