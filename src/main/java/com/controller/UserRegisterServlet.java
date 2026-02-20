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

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {

    // 🔐 password hashing method (SHA-256)
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

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            // ✅ check if email already exists
            String checkSql = "SELECT id FROM users WHERE email=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setString(1, email);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                request.setAttribute("error", "Email already registered");
                request.getRequestDispatcher("register.jsp")
                       .forward(request, response);
                return;
            }

            // 🔐 hash password
            String hashedPassword = hashPassword(password);

            // ✅ insert user
            String insertSql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);

            ps.executeUpdate();

            request.setAttribute("success", "Account created successfully. Please login.");
            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Registration Error");
        }
    }
}