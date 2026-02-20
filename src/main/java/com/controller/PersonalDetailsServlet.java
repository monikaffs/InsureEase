package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.ClaimBean;

@WebServlet("/PersonalDetailsServlet")
public class PersonalDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
     // ===== SERVER SIDE VALIDATION =====

     // name check
     if (name == null || name.trim().isEmpty()) {
         request.setAttribute("error", "Name is required");
         request.getRequestDispatcher("personalDetails.jsp").forward(request, response);
         return;
     }

     // email check
     if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
         request.setAttribute("error", "Enter valid email address");
         request.getRequestDispatcher("personalDetails.jsp").forward(request, response);
         return;
     }

     // phone check (10 digits)
     if (phone == null || !phone.matches("\\d{10}")) {
         request.setAttribute("error", "Phone must be 10 digits");
         request.getRequestDispatcher("personalDetails.jsp").forward(request, response);
         return;
     }
        // Create JavaBean
        ClaimBean claim = new ClaimBean();
        claim.setName(name);
        claim.setEmail(email);
        claim.setPhone(phone);

        // SESSION → store form data
        HttpSession session = request.getSession();
        session.setAttribute("claimData", claim);

        // COOKIE → remember username
        Cookie userCookie = new Cookie("username", name);
        userCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(userCookie);

        request.getRequestDispatcher("policyDetails.jsp").forward(request, response);
    }
}
