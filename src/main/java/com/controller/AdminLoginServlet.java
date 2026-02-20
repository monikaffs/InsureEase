package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 🔐 demo credentials (perfect for project)
        if ("admin".equals(username) && "admin123".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("adminUser", username);

            response.sendRedirect("admin");

        } else {
            request.setAttribute("error", "Invalid admin credentials");
            request.getRequestDispatcher("adminLogin.jsp")
                   .forward(request, response);
        }
    }
}