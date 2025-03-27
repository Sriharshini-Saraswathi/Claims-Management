package com.cts.cm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cm.member.exception.AuthorizationException;
import com.cts.cm.member.dto.ClaimStatus;
import com.cts.cm.member.entity.MemberPremium;
import com.cts.cm.member.exception.FileNotFoundException;
import com.cts.cm.member.restclient.AuthorizationClient;
import com.cts.cm.member.service.MemberServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
@Api(value="memberservice", description="Premium Member can view bills")
public class MemberController {
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	AuthorizationClient authClient;
	@ApiOperation(value="to view bills",notes="Valid Premium Member can view bills",response=MemberPremium.class)
	@GetMapping("/viewbill/{memberId}/{policyId}")
	public ResponseEntity<?> viewBills(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable(value = "memberId") long memberId,@PathVariable(value = "policyId") long policyId) throws FileNotFoundException , AuthorizationException{
		log.info(requestTokenHeader);
		boolean vals = authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus();
		log.debug("validity check:{}",authClient.validatingAuthorizationToken(requestTokenHeader));
		if(vals)
		return new ResponseEntity<MemberPremium>(memberService.viewBills(memberId, policyId),HttpStatus.OK);
		else
			throw new AuthorizationException("Invaid User");
	}
	@ApiOperation(value="retrieves claim status",notes="Member can check claim status",response=ClaimStatus.class)
	@GetMapping("getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ResponseEntity<?> getClaimStatus(
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long claimId, @PathVariable long policyId,
			@PathVariable long memberId)throws AuthorizationException {
		boolean vals = authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus();
		if(vals)
		return new ResponseEntity<ClaimStatus>(memberService.getClaimStaus(requestTokenHeader, claimId, policyId, memberId),HttpStatus.OK);
		else
			throw new AuthorizationException("Invaid User");
	
	}
	@ApiOperation(value="Member can submit claim",notes="Premium Member can Submit Claim",response=ClaimStatus.class)
	@PostMapping("submitClaim/{policyId}/{memberId}/{hospitalId}/{benefitId}/{totalBilledAmount}/{totalClaimedAmount}")
	public ResponseEntity<?> submitClaim( 
			@RequestHeader(value="Authorization",required=true) String requestTokenHeader,
			@PathVariable long policyId,@PathVariable long memberId,@PathVariable long hospitalId,
			@PathVariable long benefitId,@PathVariable double totalBilledAmount,@PathVariable double totalClaimedAmount)throws AuthorizationException {
		boolean vals = authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus();
		if(vals)
		return new ResponseEntity<ClaimStatus>(memberService.submitClaim(requestTokenHeader, policyId, memberId, hospitalId, benefitId, totalBilledAmount, totalClaimedAmount),HttpStatus.OK);
		else
			throw new AuthorizationException("Invaid User");
	}
}
