package com.cts.cm.portal.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.cm.portal.exception.FileNotFoundException;
import com.cts.cm.portal.dto.ClaimStatus;
import com.cts.cm.portal.dto.MemberPremiumDto;

@FeignClient(name="MEMBER-SERVICE", url = "localhost:8085/member")
//@FeignClient(name="MEMBER-SERVICE", url = "claim-memberlb-935172-1116821159.ap-northeast-1.elb.amazonaws.com/member")
public interface MemberClient {

	@GetMapping("/viewbill/{memberId}/{policyId}")
	public MemberPremiumDto viewBills(@RequestHeader(value="Authorization",required=true) String requestTokenHeader,@PathVariable(value = "memberId") long memberId,@PathVariable(value = "policyId") long policyId) throws FileNotFoundException;
	
	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ClaimStatus getClaimStatus(@RequestHeader(value="Authorization",required=true) String requestTokenHeader,@PathVariable long claimId, @PathVariable long policyId,@PathVariable long memberId);

	@PostMapping("/submitClaim/{policyId}/{memberId}/{hospitalId}/{benefitId}/{totalBilledAmount}/{totalClaimedAmount}")
	public ClaimStatus submitClaim(@RequestHeader(value="Authorization",required=true) String requestTokenHeader, @PathVariable long policyId,@PathVariable long memberId,@PathVariable long hospitalId,
			@PathVariable long benefitId,@PathVariable double totalBilledAmount,@PathVariable double totalClaimedAmount);
}
