package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.db.DBConnection;
import com.model.ClaimBean;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ClaimBean> list = new ArrayList<>();
        String keyword = request.getParameter("search");

        try (Connection con = DBConnection.getConnection()) {
        	// ===== ADMIN STATS =====

        	int total = 0, approved = 0, pending = 0, rejected = 0;

        	try (PreparedStatement statPs = con.prepareStatement(
        	        "SELECT " +
        	        "COUNT(*) AS total, " +
        	        "SUM(status='Approved') AS approved, " +
        	        "SUM(status='Pending') AS pending, " +
        	        "SUM(status='Rejected') AS rejected " +
        	        "FROM claims");
        	     ResultSet statRs = statPs.executeQuery()) {

        	    if (statRs.next()) {
        	        total = statRs.getInt("total");
        	        approved = statRs.getInt("approved");
        	        pending = statRs.getInt("pending");
        	        rejected = statRs.getInt("rejected");
        	    }
        	}

        	// send to JSP
        	request.setAttribute("totalClaims", total);
        	request.setAttribute("approvedClaims", approved);
        	request.setAttribute("pendingClaims", pending);
        	request.setAttribute("rejectedClaims", rejected);
        	
        	
        	
        	
            String sql;
            PreparedStatement ps;

            // 🔍 SEARCH LOGIC
            if (keyword != null && !keyword.trim().isEmpty()) {
                sql = "SELECT * FROM claims WHERE name LIKE ? OR CAST(id AS CHAR) LIKE ? ORDER BY id DESC";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
            } else {
                sql = "SELECT * FROM claims ORDER BY id DESC";
                ps = con.prepareStatement(sql);
            }

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    ClaimBean c = new ClaimBean();

                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setEmail(rs.getString("email"));
                    c.setPhone(rs.getString("phone"));
                    c.setPolicyNumber(rs.getString("policyNumber"));
                    c.setPolicyType(rs.getString("policyType"));
                    c.setClaimAmount(rs.getString("claimAmount"));
                    c.setHospitalName(rs.getString("hospitalName"));
                    c.setAccidentDate(rs.getString("accidentDate"));
                    c.setDescription(rs.getString("description"));
                    c.setStatus(rs.getString("status"));

                    list.add(c);
                }
            }

            request.setAttribute("claimList", list);
            request.getRequestDispatcher("admin.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading admin data");
        }
    }
}