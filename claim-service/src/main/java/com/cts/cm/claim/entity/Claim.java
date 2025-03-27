package com.cts.cm.claim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="claim_id")
	private long claimId;
	@Column(name="claim_status")
	private String claimStatus;
	@Column(name="member_id")
	private long memberId;
	@Column(name="claim_remarks")
	private String claimRemarks;
	@Column(name="policy_id")
	private long policyId;
	@Column(name="hospital_id")
	private long hospitalId;
	@Column(name="benefit_id")
	private long benefitId; 
	@Column(name="total_bill_amount")
	private double totalBillAmount;
	@Column(name="claimed_amount")
	private double claimedAmount;
	@Column(name="settled")
	private String settled;
	public long getClaimId() {
		return claimId;
	}


	

}
