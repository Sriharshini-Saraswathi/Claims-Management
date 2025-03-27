package com.cts.cm.claim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.cm.claim.entity.ClaimStatus;
import com.cts.cm.claim.exception.AuthorizationException;
import com.cts.cm.claim.restclient.AuthorizationClient;
import com.cts.cm.claim.service.ClaimService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping
@Api(value="claimservices", description="Valid Premium Member can submit and get claim status")
@RestController
public class ClaimController {
	@Autowired
	ClaimService claimService;
	@Autowired
	AuthorizationClient authClient;
	@ApiOperation(value="retrieves claim status",notes="Member can check claim status",response=ClaimStatus.class)
	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ResponseEntity<ClaimStatus> getClaimStatus(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long claimId, @PathVariable long policyId,
			@PathVariable long memberId) throws AuthorizationException {
		
		if(authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus())
		return new ResponseEntity<>(claimService.getClaimStatus(claimId, policyId, memberId),HttpStatus.OK);
		else
			throw new AuthorizationException("Invaild User");
	}
	@ApiOperation(value="Member can submit claim",notes="Premium Member can Submit Claim",response=ClaimStatus.class)
	@PostMapping("/submitClaim/{policyId}/{memberId}/{hospitalId}/{benefitId}/{totalBilledAmount}/{totalClaimedAmount}")
	public ResponseEntity<ClaimStatus> submitClaim( 
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId,@PathVariable long memberId,@PathVariable long hospitalId,
			@PathVariable long benefitId,@PathVariable double totalBilledAmount,@PathVariable double totalClaimedAmount) throws AuthorizationException {
		if(authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus())
		return  new ResponseEntity<>( claimService.submitClaim(requestTokenHeader,policyId, memberId,hospitalId,benefitId,totalBilledAmount,totalClaimedAmount),HttpStatus.OK);
		else
			throw new AuthorizationException("Invaild User");
		
	}
	

}
