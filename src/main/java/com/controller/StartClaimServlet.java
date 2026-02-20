package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/startClaim")
public class StartClaimServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 LOGIN PROTECTION (VERY IMPORTANT)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // ✅ get insurance type from URL
        String type = request.getParameter("type");

        // ✅ session → used in multi-step form
        session.setAttribute("insuranceType", type);

        // ✅ cookie → remember last selected insurance
        Cookie insuranceCookie = new Cookie("lastInsurance", type);
        insuranceCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(insuranceCookie);

        // ✅ go to step 1
        response.sendRedirect("personalDetails.jsp");
    }
}