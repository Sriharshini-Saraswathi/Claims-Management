package com.cts.cm.policy.service;

import java.util.List;

import com.cts.cm.policy.entity.Benefits;
import com.cts.cm.policy.entity.ProviderPolicy;

public interface PolicyService {

	List<ProviderPolicy> getChainOfHealthProviders(long policyId);

	List<Benefits> getEligibleBenefits(long policyId, long memberId);
	public double getEligibleClaimAmount(long policyId, long memberId);
}
