package com.cts.cm.member.dto;

import lombok.Data;

@Data
public class Claim {
	private long claimId;
	private String claimStatus;
	private long memeberId;
    private String claimRemarks;
	private long policyId;
	private long hospitalId;
	private long benefitId; 
	private double totalBillAmount;
	private double claimedAmount;
	private String settled;
}