<html>
<head>
<title>Insurance Claim - Step 2</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Insurance Claim System</div>

<div class="hero">
<h2>Step 2: Policy Details</h2>

<c:if test="${not empty error}">
    <div style="color:red; text-align:center; margin-bottom:15px;">
        ${error}
    </div>
</c:if>

<form action="PolicyDetailsServlet" method="post">

Policy Number:<br>
<input type="number" name="policyNumber" required><br><br>

Policy Type:<br>
<select name="policyType">
    <option>Life Insurance</option>
    <option>Health Insurance</option>
    <option>Vehicle Insurance</option>
</select><br><br>


Claim Amount:<br>
<input type="number" name="claimAmount" required min="1"><br><br>


<button type="button" class="btn" onclick="history.back()"> Go Back </button>

<button type="submit" class="btn">Next >>> Claim Details</button>


</form>
</div>

<div class="footer">Multi Step Insurance Claim System</div>

</body>
</html>
