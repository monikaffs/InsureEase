<html>
<head>
<title>Insurance Claim - Step 1</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Insurance Claim System</div>

<div class="hero">
<h2>Step 1: Personal Details</h2>

<c:if test="${not empty error}">
    <div style="color:red; text-align:center; margin-bottom:15px;">
        ${error}
    </div>
</c:if>

<form action="PersonalDetailsServlet" method="post">

Full Name:<br>
<input type="text" name="name" required 
       pattern="[A-Za-z ]+" 
       title="Only letters allowed"><br><br>

Email:<br>
<input type="email" name="email" required><br><br>

Phone Number:<br>
<input type="tel" name="phone" required 
       pattern="[0-9]{10}" 
       title="Enter 10 digit mobile number"><br><br>

<button class="btn">Next >>> Policy Details</button>

</form>

</div>

<div class="footer">Multi Step Insurance Claim System</div>

</body>
</html>
