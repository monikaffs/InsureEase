package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.db.DBConnection;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String status = request.getParameter("status");

        String sql = "UPDATE claims SET status=? WHERE id=?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, status);
            ps.setInt(2, Integer.parseInt(id));

            ps.executeUpdate();

            // redirect back to admin page
            response.sendRedirect("admin");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating status");
        }
    }
}