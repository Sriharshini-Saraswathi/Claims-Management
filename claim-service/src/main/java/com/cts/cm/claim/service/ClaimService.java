package com.cts.cm.claim.service;

import com.cts.cm.claim.entity.ClaimStatus;

public interface ClaimService {
	public ClaimStatus getClaimStatus(long claimId,long policyId, long memberId);
	public ClaimStatus submitClaim(String requestTokenHeader,long policyId, long memberId,long hosptialId,long benefitId,double totalBilledAmount,double totalClaimedAmount);
}
