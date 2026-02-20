package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.ClaimBean;

@WebServlet("/PolicyDetailsServlet")
public class PolicyDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data from policyDetails.jsp
        String policyNumber = request.getParameter("policyNumber");
        String policyType = request.getParameter("policyType");
        String claimAmount = request.getParameter("claimAmount");

        
     // policy number numeric check
        if (policyNumber == null || !policyNumber.matches("\\d+")) {
            request.setAttribute("error", "Policy number must be numeric");
            request.getRequestDispatcher("policyDetails.jsp").forward(request, response);
            return;
        }

        // claim amount numeric check
        if (claimAmount == null || !claimAmount.matches("\\d+")) {
            request.setAttribute("error", "Claim amount must be numeric");
            request.getRequestDispatcher("policyDetails.jsp").forward(request, response);
            return;
        }
        
        
        // Get bean from session
        HttpSession session = request.getSession();
        ClaimBean claim = (ClaimBean) session.getAttribute("claimData");

        // Update bean with policy details
        claim.setPolicyNumber(policyNumber);
        claim.setPolicyType(policyType);
        claim.setClaimAmount(claimAmount);

        // Save back to session
        session.setAttribute("claimData", claim);

        // Forward to next page
        request.getRequestDispatcher("claimDetails.jsp").forward(request, response);
    }
}
