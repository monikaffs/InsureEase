package com.model;

import java.io.Serializable;

public class ClaimBean implements Serializable {

    // Personal Details
    private String name;
    private String email;
    private String phone;

    // Policy Details
    private String policyNumber;
    private String policyType;
    private String claimAmount;

    // Claim Details
    private String hospitalName;
    private String accidentDate;
    private String description;
    
    private int id;
    private String status;

    public ClaimBean() {}

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public String getClaimAmount() { return claimAmount; }
    public void setClaimAmount(String claimAmount) { this.claimAmount = claimAmount; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getAccidentDate() { return accidentDate; }
    public void setAccidentDate(String accidentDate) { this.accidentDate = accidentDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
