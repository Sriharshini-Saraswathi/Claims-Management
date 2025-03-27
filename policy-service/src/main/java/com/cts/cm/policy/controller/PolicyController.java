package com.cts.cm.policy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cm.policy.restclient.AuthorizationClient;
import com.cts.cm.policy.entity.Benefits;
import com.cts.cm.policy.entity.Policy;
import com.cts.cm.policy.entity.ProviderPolicy;
import com.cts.cm.policy.exception.AuthorizationException;
import com.cts.cm.policy.repository.MemberPolicyRepository;
import com.cts.cm.policy.service.PolicyServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping
@Api(value = "policyservices", description = "Provides chain of providers and eligible claim and benefit amount")
@RestController
public class PolicyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);

	@Autowired
	MemberPolicyRepository memberPolicyRepository;
	@Autowired
	PolicyServiceImpl policyService;
	@Autowired
	AuthorizationClient authClient;

	@ApiOperation(value = "Gives Chain of Health Providers", notes = "Chain of Health Providers will be displayed", response = ProviderPolicy.class)
	@GetMapping("/getChainOfProviders/{policyId}")
	public ResponseEntity<?> getChainOfHealthProviders(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable long policyId) {
		LOGGER.info("Start");
		List<ProviderPolicy> list = policyService.getChainOfHealthProviders(policyId);
		LOGGER.debug("Provider List : {}", list);
		LOGGER.info("End");
		if (authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus())
			return new ResponseEntity<>(list,HttpStatus.OK);
		else
			return null;
	}

	@ApiOperation(value = "Retrieve Eligible Claim Amount", notes = "Provides Eligible Claim Amount", response = Policy.class)
	@GetMapping("/getEligibleClaimAmount/{policyId}/{memberId}/{benefitId}")
	public ResponseEntity<?> getEligibleClaimAmount(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable long policyId, @PathVariable long memberId, @PathVariable long benefitId)
			throws AuthorizationException {
		LOGGER.info("Start");
		if (authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus()) {
			LOGGER.info("End");
			return new ResponseEntity<>(policyService.getEligibleClaimAmount(policyId, memberId),HttpStatus.OK);
		}
		else {
			LOGGER.info("End");
			throw new AuthorizationException("Invaid User");
		}
	}

	@ApiOperation(value = "Retrieves List of Benefits", notes = "Provides List of Benefits", response = Policy.class)
	@GetMapping("/getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<?> getEligibleBenefits(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable long policyId, @PathVariable long memberId) throws AuthorizationException {
		LOGGER.info("Start");
		if (authClient.validatingAuthorizationToken(requestTokenHeader).isValidStatus()) {
			return new ResponseEntity<>(policyService.getEligibleBenefits(policyId, memberId), HttpStatus.OK);
		}
		else {
			LOGGER.info("End");
			throw new AuthorizationException("Invaid User");
		}
	}
	

}
