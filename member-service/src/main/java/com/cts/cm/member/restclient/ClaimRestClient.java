package com.cts.cm.member.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.cm.member.dto.ClaimStatus;

//@FeignClient(name="CLAIM-SERVICE",url = "claim-claimlb-935172-357172545.ap-northeast-1.elb.amazonaws.com")
@FeignClient(name="CLAIM-SERVICE",url = "localhost:8087")
public interface ClaimRestClient {
	
	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ClaimStatus getClaimStatus(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long claimId, @PathVariable long policyId,
			@PathVariable long memberId);
	
	@PostMapping("/submitClaim/{policyId}/{memberId}/{hospitalId}/{benefitId}/{totalBilledAmount}/{totalClaimedAmount}")
	public ClaimStatus submitClaim( 
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId,@PathVariable long memberId,@PathVariable long hospitalId,
			@PathVariable long benefitId,@PathVariable double totalBilledAmount,@PathVariable double totalClaimedAmount);

}
