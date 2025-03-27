package com.cts.cm.member.service;

import com.cts.cm.member.dto.ClaimStatus;
import com.cts.cm.member.entity.MemberPremium;
import com.cts.cm.member.exception.FileNotFoundException;

public interface MemberService {
	public MemberPremium viewBills(long memberId,long policyId) throws FileNotFoundException;
	public ClaimStatus getClaimStaus(String requestTokenHeader,long claimId,long policyId, long memberId);
	public ClaimStatus submitClaim(String requestTokenHeader,long policyId, long memberId, long hospitalId,long benefitId,double totalBilledAmount,double totalClaimedAmount);
}