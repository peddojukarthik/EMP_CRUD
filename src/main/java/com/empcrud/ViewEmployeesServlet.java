package com.empcrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

 @WebServlet("/view-employees")
public class ViewEmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        empADA dao = new empADA();
        List<Employee> list;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            list = dao.getAllEmployees();
            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Dept</th><th>Email</th><th>Salary</th></tr>");
            for (Employee e : list) {
                out.println("<tr>");
                out.println("<td>" + e.getId() + "</td>");
                out.println("<td>" + e.getName() + "</td>");
                out.println("<td>" + e.getDepartment() + "</td>");
                out.println("<td>" + e.getEmail() + "</td>");
                out.println("<td>" + e.getSalary() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error loading employee list.");
        }
    }
}

