<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="navbar">InsureEase Admin Dashboard - Insurance Claims</div>

<div class="hero" style="width:90%">

<h2>All Insurance Claims</h2>


<form method="get" action="admin" style="margin-bottom:20px;text-align:center;">
    <input type="text" name="search" placeholder="Search by Name or ID"
           style="padding:8px;width:220px;border-radius:6px;border:1px solid #ccc;">
    <button class="btn">Search</button>
</form>

<!-- ===== ADMIN STATS ===== -->
<div class="stats-container">

    <div class="stat-card">
        <h3>${totalClaims}</h3>
        <p>Total Claims</p>
    </div>

    <div class="stat-card approved">
        <h3>${approvedClaims}</h3>
        <p>Approved</p>
    </div>

    <div class="stat-card pending">
        <h3>${pendingClaims}</h3>
        <p>Pending</p>
    </div>

    <div class="stat-card rejected">
        <h3>${rejectedClaims}</h3>
        <p>Rejected</p>
    </div>

</div>
<table border="1" width="100%" cellpadding="10" style="border-collapse:collapse">

<tr style="background:#2563eb;color:white">
<th>ID</th>
<th>Name</th>
<th>Policy Type</th>
<th>Amount</th>
<th>Status</th>
<th>Action</th>
</tr>

<c:forEach var="c" items="${claimList}">
<tr>
<td>CLM-${c.id}</td>
<td>${c.name}</td>
<td>${c.policyType}</td>
<td>&#8377; ${c.claimAmount}</td>
<td>
    <span class="status-badge status-${c.status}">
        ${c.status}
    </span>
</td>


<td>
   <div class="action-buttons">
      <a href="updateStatus?id=${c.id}&status=Approved" class="btn-approve">Approve</a>
      <a href="updateStatus?id=${c.id}&status=Pending" class="btn-pending">Pending</a>
      <a href="updateStatus?id=${c.id}&status=Rejected" class="btn-reject">Reject</a>
   </div>
</td>

</tr>
</c:forEach>

</table>

</div>

<div class="footer">InsureEase: Insurance Claim System</div>

</body>
</html>