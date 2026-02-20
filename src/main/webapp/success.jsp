<html>
<head>
<title>Success</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Insurance Claim System</div>

<div class="hero">

<h1>Claim Submitted Successfully!</h1>

<h2>
Your Claim ID: 
<%= session.getAttribute("generatedClaimId") %>
</h2>

<p>Please save this ID for future reference.</p>

<br>

<a href="index.jsp">
<button class="btn">Submit Another Claim</button>
</a>

<div class="footer">Insurance Claim System</div>

</body>
</html>
