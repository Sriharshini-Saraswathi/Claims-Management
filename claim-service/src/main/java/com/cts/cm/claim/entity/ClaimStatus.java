package com.cts.cm.claim.entity;

import lombok.Data;

@Data
public class ClaimStatus {
	private long claimId;
	private String claimStatus;
	private String claimStatusDescription;
	
}
