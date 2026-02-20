package com.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.db.DBConnection;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

    // 🔐 hashing method (MUST match register)
    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT name, password FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbHashedPassword = rs.getString("password");
                String inputHashed = hashPassword(password);

                // ✅ password match
                if (dbHashedPassword.equals(inputHashed)) {

                    HttpSession session = request.getSession();
                    session.setAttribute("loggedUser", rs.getString("name"));
                    session.setAttribute("userEmail", email);

                    response.sendRedirect("index.jsp");
                    return;
                }
            }

            // ❌ invalid login
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Login Error");
        }
    }
}