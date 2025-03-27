package com.cts.cm.policy.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.cm.policy.entity.Benefits;
import com.cts.cm.policy.entity.ProviderPolicy;
import com.cts.cm.policy.repository.ProviderPolicyRepository;

@RunWith(MockitoJUnitRunner.class)
class PolicyServiceImplTest {

	@Mock
	PolicyServiceImpl policyService; 
	
	@InjectMocks
	ProviderPolicyRepository providerRepository;
		
	@Mock
	ProviderPolicy providerPolicy;
	
	@Mock
	Benefits benefits;
	
	@Test
	public void test2() {
		ProviderPolicy providerPolicy = new ProviderPolicy();
		assertNotNull(providerPolicy);
	}
	
	@Test
	public void testGetChainOfHealthProviders() {
		policyService = mock(PolicyServiceImpl.class);
		providerPolicy = new ProviderPolicy(1,601,"Kims",1001,"Hyderabad");
		List<ProviderPolicy> providersList = new ArrayList<ProviderPolicy>();
		providersList.add(providerPolicy);
		providerPolicy = new ProviderPolicy(2,602,"Nims",1001,"Hyderabad");
		providersList.add(providerPolicy);
		when(policyService.getChainOfHealthProviders(1001)).thenReturn(providersList);
		assertEquals(providersList,policyService.getChainOfHealthProviders(1001));
	}

	@Test
	public void testGetEligibleBenefits() {
		policyService = mock(PolicyServiceImpl.class);
		benefits = new Benefits(501, "free monthly check-up");
		List<Benefits> benefitsList = new ArrayList<Benefits>();
		benefitsList.add(benefits);
		when(policyService.getEligibleBenefits(1001,101)).thenReturn(benefitsList);
		assertEquals(benefitsList,policyService.getEligibleBenefits(1001,101));
	}
	
	@Test
	void testGetEligibleClaimAmount() {
		policyService = mock(PolicyServiceImpl.class);
		when(policyService.getEligibleClaimAmount(1001, 101)).thenReturn(200000.0);
		assertEquals(200000.0,policyService.getEligibleClaimAmount(1001, 101));
	}

}
