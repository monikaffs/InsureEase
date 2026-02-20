package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/startClaim")
public class StartClaimServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");

        // SESSION → used during multi-step form
        HttpSession session = request.getSession();
        session.setAttribute("insuranceType", type);

        // COOKIE → remember last selected insurance
        Cookie insuranceCookie = new Cookie("lastInsurance", type);
        insuranceCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(insuranceCookie);

        response.sendRedirect("personalDetails.jsp");
    }
}
