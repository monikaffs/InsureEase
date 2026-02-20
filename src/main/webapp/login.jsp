<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>User Login - InsureEase</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">InsureEase Login</div>

<div class="login-wrapper">

    <div class="login-card">
        <h2 class="login-title">Welcome Back</h2>
        <p class="login-sub">Login to manage your claims</p>

        <form method="post" action="userLogin">

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <button class="btn login-btn">Login</button>

            <% if(request.getAttribute("error") != null){ %>
                <p class="error-msg"><%= request.getAttribute("error") %></p>
            <% } %>

        </form>

        <p style="margin-top:18px; font-size:14px;">
            New user?
            <a href="register.jsp" style="color:#2563eb; font-weight:600;">
                Create account
            </a>
        </p>

    </div>

</div>

</body>
</html> 