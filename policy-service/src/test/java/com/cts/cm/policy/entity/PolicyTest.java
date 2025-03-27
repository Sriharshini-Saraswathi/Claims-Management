package com.cts.cm.policy.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PolicyTest {

	@Mock
	Policy policy;
	
	@Test
	void testPolicyNotNull() {
		policy = new Policy();
		assertNotNull(policy);
	}
	
	@Test
	void testPolicyCreation() {
		
		policy = new Policy(1001L,200000D,24,501L);
		
		assertEquals(1001L,policy.getPolicyId());
		assertEquals(200000D, policy.getPremiumAmount());
		assertEquals(24,policy.getTenure());
		assertEquals(501L,policy.getBenefitId());
	}

}
