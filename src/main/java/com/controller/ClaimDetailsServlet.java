package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.ClaimBean;

@WebServlet("/ClaimDetailsServlet")
public class ClaimDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from claimDetails.jsp
        String hospitalName = request.getParameter("hospitalName");
        String accidentDate = request.getParameter("accidentDate");
        String description = request.getParameter("description");

        
        if (hospitalName == null || hospitalName.trim().isEmpty()) {
            request.setAttribute("error", "Hospital name is required");
            request.getRequestDispatcher("claimDetails.jsp").forward(request, response);
            return;
        }

        if (description == null || description.trim().isEmpty()) {
            request.setAttribute("error", "Description is required");
            request.getRequestDispatcher("claimDetails.jsp").forward(request, response);
            return;
        }
        
        
        // Get bean from session
        HttpSession session = request.getSession();
        ClaimBean claim = (ClaimBean) session.getAttribute("claimData");

        // Update bean with claim details
        claim.setHospitalName(hospitalName);
        claim.setAccidentDate(accidentDate);
        claim.setDescription(description);

        // Send bean to summary page using request scope
        request.setAttribute("claim", claim);

        // Forward to summary page
        request.getRequestDispatcher("claimSummary.jsp").forward(request, response);
    }
}
