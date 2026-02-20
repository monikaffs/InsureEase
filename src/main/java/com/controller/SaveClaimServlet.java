package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.db.DBConnection;
import com.model.ClaimBean;

@WebServlet("/SaveClaimServlet")
public class SaveClaimServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    ClaimBean claim = (ClaimBean) session.getAttribute("claimData");

	    String sql = "INSERT INTO claims(name,email,phone,policyNumber,policyType,claimAmount,hospitalName,accidentDate,description,status) VALUES (?,?,?,?,?,?,?,?,?,?)";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	    ) {

	        ps.setString(1, claim.getName());
	        ps.setString(2, claim.getEmail());
	        ps.setString(3, claim.getPhone());
	        ps.setString(4, claim.getPolicyNumber());
	        ps.setString(5, claim.getPolicyType());
	        ps.setString(6, claim.getClaimAmount());
	        ps.setString(7, claim.getHospitalName());
	        ps.setString(8, claim.getAccidentDate());
	        ps.setString(9, claim.getDescription());
	        ps.setString(10, "Pending");

	        ps.executeUpdate();

	        // 🔥 GET AUTO GENERATED ID
	        int claimId = 0;
	        try (java.sql.ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                claimId = rs.getInt(1);
	            }
	        }

	        // Store formatted claim ID in session
	        session.setAttribute("generatedClaimId", "CLM-" + claimId);

	        // Clear form data session
	        session.removeAttribute("claimData");

	        response.sendRedirect("success.jsp");

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().println("Database Error Occurred");
	    }
	}
}