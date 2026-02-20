<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Claim Summary</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">Insurance Claim Summary</div>

<div class="hero">
<h2>Review Your Claim</h2>

<b>Name:</b> <c:out value="${claim.name}"/><br><br>
<b>Email:</b> <c:out value="${claim.email}"/><br><br>
<b>Phone:</b> <c:out value="${claim.phone}"/><br><br>

<b>Policy Number:</b> <c:out value="${claim.policyNumber}"/><br><br>
<b>Policy Type:</b> <c:out value="${claim.policyType}"/><br><br>
<b>Amount Claimed:</b> ₹<c:out value="${claim.claimAmount}"/><br><br>

<b>Hospital:</b> <c:out value="${claim.hospitalName}"/><br><br>
<b>Date:</b> <c:out value="${claim.accidentDate}"/><br><br>
<b>Description:</b> <c:out value="${claim.description}"/><br><br>

<form action="SaveClaimServlet" method="post">

<button type="button" class="btn" onclick="history.back()"> Go Back </button>

<button class="btn">Submit Claim</button>


</form>

</div>

<div class="footer">Insurance Claim System</div>

</body>
</html>
