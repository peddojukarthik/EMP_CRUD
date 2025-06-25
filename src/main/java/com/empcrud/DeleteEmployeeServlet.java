package com.empcrud;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        empADA dao = new empADA();
         res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        try {
            dao.deleteEmployee(id);
            out.println("<h2>Employee deleted successfully!</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Failed to delete employee.</h2>");
        }
    }
}
