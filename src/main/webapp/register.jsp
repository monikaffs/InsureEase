<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>User Registration - InsureEase</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Join InsureEase</div>

<div class="login-wrapper">

    <div class="login-card">
        <h2 class="login-title">Create Your Account</h2>
        <p class="login-sub">Start managing your insurance claims securely</p>

        <form method="post" action="userRegister">

            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required minlength="6">
            </div>

            <button class="btn login-btn">Create Account</button>

            <% if(request.getAttribute("error") != null){ %>
                <p class="error-msg"><%= request.getAttribute("error") %></p>
            <% } %>

            <% if(request.getAttribute("success") != null){ %>
                <p style="color:#16a34a; margin-top:12px;">
                    <%= request.getAttribute("success") %>
                </p>
            <% } %>

        </form>

        <p style="margin-top:18px; font-size:14px;">
            Already have an account?
            <a href="login.jsp" style="color:#2563eb; font-weight:600;">
                Login
            </a>
        </p>

    </div>

</div>

</body>
</html>