<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Admin Login - InsureEase</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">InsureEase Admin Panel</div>

<div class="login-wrapper">

    <div class="login-card">
        <h2 class="login-title">Admin Login</h2>
        <p class="login-sub">Secure access to dashboard</p>

        <form method="post" action="adminLogin">

            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <button class="btn login-btn">Login to Dashboard</button>

            <% if(request.getAttribute("error") != null){ %>
                <p class="error-msg"><%= request.getAttribute("error") %></p>
            <% } %>

        </form>
    </div>

</div>

</body>
</html>