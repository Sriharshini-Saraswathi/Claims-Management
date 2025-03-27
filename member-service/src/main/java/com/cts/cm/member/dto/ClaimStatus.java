package com.cts.cm.member.dto;

import lombok.Data;

@Data
public class ClaimStatus {
	private long claimId;
	private String claimStatus;
	private String claimStatusDescription;

}
