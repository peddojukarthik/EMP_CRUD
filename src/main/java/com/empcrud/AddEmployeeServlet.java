package com.empcrud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Employee emp = new Employee();
       
        emp.setName(req.getParameter("name"));
        emp.setDepartment(req.getParameter("department"));
        emp.setEmail(req.getParameter("email"));
        emp.setSalary(Double.parseDouble(req.getParameter("salary")));

        empADA dao = new empADA();
         res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        try {
            dao.addEmployee(emp);
            out.println("<h2>Employee added successfully!</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Failed to add employee.</h2>");
        }
    }
}