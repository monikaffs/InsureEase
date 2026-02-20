<%@ page import="javax.servlet.http.Cookie" %>
c
<%
String userName = "";
String lastInsurance = "";

Cookie[] cookies = request.getCookies();
if(cookies != null){
    for(Cookie c : cookies){
        if(c.getName().equals("username"))
            userName = c.getValue();
        if(c.getName().equals("lastInsurance"))
            lastInsurance = c.getValue();
    }
}

String loggedUser = (String) session.getAttribute("loggedUser");
%>


<html>
<head>
<meta charset="UTF-8">
<title>Insurance Claim Portal</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>

<body>

<!--  NAVBAR  -->

<div class="navbar">

    <span class="nav-left">
        Welcome to <span class="brand">InsureEase</span>
    </span>

    <span class="nav-right">

        <% if (loggedUser != null) { %>

            <span class="welcome-text">
                Welcome, <b><%= loggedUser %></b>
            </span>
            <span class="nav-divider">|</span>
            <a href="userLogout" class="nav-link">Logout</a>

        <% } else { %>

            <a href="login.jsp" class="nav-link">Login</a>
            <span class="nav-divider">|</span>
            <a href="register.jsp" class="nav-link">Register</a>

        <% } %>

    </span>

</div>


<h3 style="text-align:center">

<% if(loggedUser != null){ %>
    Welcome <%= loggedUser %>
<% } else { %>
    Welcome Guest
<% } %>

<% if(!lastInsurance.equals("")){ %>
 | Last selected: <%= lastInsurance %> Insurance
<% } %>

</h3>

<section class="hero-section">
<div class="hero-left">
    <h1>Let's find you <br><span class="highlight">the Best Insurance</span></h1>
    <p class="hero-desc">
        We provide government-approved and legally verified insurance
        policies to ensure your financial safety and peace of mind.
        Compare plans, choose the best coverage, and file claims easily
        through our secure digital platform.
    </p>

    <a href="#insuranceOptions" class="btn-primary">Explore Plans</a>
</div>

<div class="hero-right">
    <img src="images/insurance-hero.png" alt="Insurance">
</div>


</section>

<section class="trust-strip">
  <p>
    Trusted digital platform for secure and government-compliant insurance claim processing.
  </p>
</section>


<section class="services-section">
<h2 class="section-title">How InsureEase Supports You</h2>
  <p class="services-sub">
   The Services, Smart tools and guided workflows designed to simplify insurance and provider management.
  </p>

  <div class="services-grid">
<div class="service-card">
  <h4>Efficient Claim Processing</h4>
  <p>
    Automates the entire claim lifecycle from submission to approval.
Reduces manual paperwork and repetitive data entry.
Provides real-time status tracking for better transparency. </p> </div>

<div class="service-card">
  <h4>Clear, Guided Workflows</h4>
  <p>
    Step-by-step navigation simplifies complex insurance tasks.
Minimizes user errors through structured process guidance.
Improves productivity with an intuitive, user-friendly interface. </p> </div>

<div class="service-card">
  <h4>Smart Provider Matching</h4>
  <p>
    Uses intelligent logic to recommend suitable providers.
Matches users based on needs, coverage, and preferences.
Saves time spent searching and comparing options manually.
</p>
    </div>

<div class="service-card">
  <h4>Enhanced security and fraud detection</h4>
  <p>
  Protects sensitive data with advanced security measures.
Monitors claim activity to detect suspicious patterns early.
Reduces the risk of fraud through automated checks. </p>
 </div>
 </div>
</section>

<div id="insuranceOptions" class="hero" style="width:80%">

<h1 class="insurance-title">Choose Your Insurance Type</h1>
<p class="insurance-sub">Select insurance to start your claim</p>

<br>

<div class="card-container">

<div class="card">
  <h3>Term Life Insurance</h3>
  <p>Secure your family's future</p>
  <a href="startClaim?type=Life">
    <button class="btn">Start Claim</button>
  </a>
</div>

<div class="card">
  <h3>Health Insurance</h3>
  <p>Coverage for medical expenses</p>
  <a href="startClaim?type=Health">
    <button class="btn">Start Claim</button>
  </a>
</div>

<div class="card">
  <h3>Vehicle Insurance</h3>
  <p>Protection for your vehicle</p>
  <a href="startClaim?type=Vehicle">
    <button class="btn">Start Claim</button>
  </a>
</div>
</div>
</div>

<section class="extra-section">

<h1 class="insurance-title">More Insurance Products</h1>

<div class="mini-cards">

<div class="mini-card">Term Insurance (Women)</div>
<div class="mini-card">Child Savings Plans</div>
<div class="mini-card">Retirement Plans</div>
<div class="mini-card">Travel Insurance</div>
<div class="mini-card">Smart Deposit</div>
<div class="mini-card">Employee Group Health</div>
<div class="mini-card">Home Loan Insurance</div>
<div class="mini-card">2-Wheeler Insurance</div>
<div class="mini-card">Brand New Car Insurance</div>

</div>

</section>

<section class="why-choose-section">

  <h2>Why Choose InsureEase</h2>
  <p class="services-sub">
    Built to deliver a secure, transparent, and hassle-free insurance claim experience.
  </p>

  <div class="why-grid">

<div class="why-card">
  <h4>Secure & Reliable</h4>
  <p> Your claim data is handled through validated workflows designed to
maintain accuracy and confidentiality. Built-in safeguards ensure
every submission remains secure and consistent. </p> </div>

<div class="why-card">
  <h4>Fast Claim Processing</h4>
  <p>
    Streamlined multi-step forms reduce delays and help you submit claims
quickly and efficiently. The optimized flow minimizes manual effort
and speeds up processing. </p> </div>

<div class="why-card">
  <h4>Real-Time Tracking</h4>
  <p>
    Monitor your claim status anytime using your unique claim ID without
unnecessary follow-ups. Stay informed at every stage with clear
status updates. </p> </div>

<div class="why-card">
  <h4>Centralized Admin Control</h4>
  <p>
     The dedicated admin dashboard enables structured review and
transparent decision-making. Claims are managed centrally for better
visibility and control. </p> 
</div>
  </div>
</section>

<footer class="site-footer">

<div class="footer-container">

    <div class="footer-col">
        <h3>InsureEase: Insurance Portal</h3>
        <p>Secure and government-approved insurance claim platform for modern users.</p>
        <p style="margin-top:10px;">
<a href="admin" class="admin-link">Admin Access</a>


</p>
        </div>


    <div class="footer-col">
        <h4>Customer Care</h4>
        <p>Email: support@insurance.com</p>
        <p>Phone: +91 18002 18002</p>
    </div>

    <div class="footer-col">
        <h4>Quick Links</h4>
        <p>About Us</p>
        <p>Privacy Policy</p>
        <p>Terms & Conditions</p>
    </div>

</div>

<div class="footer-bottom">
    &copy; 2026 InsureEase - Insurance Claim System. All rights reserved.
</div>    

</footer>

<script>
function showPopup(){
    document.getElementById("customPopup").style.display = "flex";
}

function closePopup(){
    document.getElementById("customPopup").style.display = "none";
}

document.querySelectorAll(".mini-card").forEach(card => {
    card.addEventListener("click", showPopup);
});
</script>

<div id="customPopup" class="popup-overlay">
  <div class="popup-box">
    <h3>Policy Unavailable</h3>
    <p>
      We're sorry, this policy is currently unavailable. Please explore our other insurance options.
    </p>
    <button onclick="closePopup()" class="btn">Okay</button>
  </div>
</div>

</body>
</html>
