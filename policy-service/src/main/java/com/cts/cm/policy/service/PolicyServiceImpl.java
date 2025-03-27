package com.cts.cm.policy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cm.policy.entity.Benefits;
import com.cts.cm.policy.entity.MemberPolicy;
import com.cts.cm.policy.entity.ProviderPolicy;
import com.cts.cm.policy.repository.BenefitsRepository;
import com.cts.cm.policy.repository.MemberPolicyRepository;
import com.cts.cm.policy.repository.ProviderPolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyServiceImpl.class);
	
	@Autowired
	ProviderPolicyRepository providerPolicyRepository;
	
	@Autowired
	MemberPolicyRepository memberPolicyRepository;
	
	@Autowired
	BenefitsRepository benefitsRepository;
	
	@Override
	public List<ProviderPolicy> getChainOfHealthProviders(long policyId){
		LOGGER.info("Policy Service - getChainOfHealthProviders: Start");
		List<ProviderPolicy> providersList = providerPolicyRepository.findAllByPolicyIdOrderByLocation(policyId);
		LOGGER.info("Policy Service - getChainOfHealthProviders: End");
		return providersList;
	}
	
	@Override
	public List<Benefits> getEligibleBenefits(long policyId, long memberId){
		LOGGER.info("Policy Service - getEligibleBenefits: Start");
		List<MemberPolicy> memberPolicyList = memberPolicyRepository.findAllByPolicyIdAndMemberId(policyId,memberId);
		List<Benefits> benefitsList = new ArrayList<Benefits>();
		for(MemberPolicy mp : memberPolicyList) {
			Optional<Benefits> benefit = benefitsRepository.findById(mp.getBenefitId());
			if(benefit.isPresent()) {
				benefitsList.add(benefit.get());
			}
		}
		LOGGER.info("Policy Service - getEligibleBenefits: End");
		return benefitsList;
	}
	@Override
	public double getEligibleClaimAmount(long policyId, long memberId) {
		LOGGER.info("Policy Service - getEligibleClaimAmount: Start");		
		MemberPolicy temp = memberPolicyRepository.getEligibleClaimAmount(policyId, memberId);
		LOGGER.debug("eligible claim amount: {} ",temp);
		double eligibleClaimAmount;
		if(temp!=null)
			eligibleClaimAmount=temp.getCapAmount();
		else eligibleClaimAmount=-1;
		LOGGER.info("Policy Service - getEligibleClaimAmount: End");
		return eligibleClaimAmount;
		
	}
	
}
