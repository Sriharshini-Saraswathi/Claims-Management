package com.cts.cm.claim.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.cm.claim.entity.dto.Benefits;
import com.cts.cm.claim.entity.dto.ProviderPolicy;


//@FeignClient(name="POLICY-SERVICE", url="http://claim-policylb-935172-1041464674.ap-northeast-1.elb.amazonaws.com")
@FeignClient(name="POLICY-SERVICE", url="localhost:8089")
public interface PolicyClient {
	
	@GetMapping("/getEligibleClaimAmount/{policyId}/{memberId}/{benefitId}")
	public double getEligibleClaimAmount(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId, @PathVariable long memberId,@PathVariable long benefitId);
	
	@GetMapping("/getEligibleBenefits/{policyId}/{memberId}")
	public List<Benefits> getEligibleBenefits(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId, @PathVariable long memberId); 
	
	@GetMapping("/getChainOfProviders/{policyId}")
	public List<ProviderPolicy> getChainOfProviders(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId);
	
	
	

	

}
