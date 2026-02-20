<html>
<head>
<title>Insurance Claim - Step 3</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Insurance Claim System</div>

<div class="hero">
<h2>Step 3: Claim Details</h2>

<c:if test="${not empty error}">
    <div style="color:red; text-align:center; margin-bottom:15px;">
        ${error}
    </div>
</c:if>

<form action="ClaimDetailsServlet" method="post">

Hospital Name for Life or Health Insurance / Garage Name for Vehicle Insurance:<br>
<input type="text" name="hospitalName" required><br><br>

Accident / Treatment Date:<br>
<input type="date" name="accidentDate" required><br><br>

Claim Description:<br>
<textarea name="description" required minlength="10"></textarea><br><br>


<button type="button" class="btn" onclick="history.back()"> Go Back </button>
 
<button class="btn">View Summary</button>

</form>
</div>

<div class="footer">Multi Step Insurance Claim System</div>

</body>
</html>
