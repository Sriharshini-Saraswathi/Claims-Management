package com.cts.cm.policy.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ProviderPolicyTest {

	@Mock
	ProviderPolicy providerPolicy;
	
	@Test
	void test() {
		providerPolicy = new ProviderPolicy(1,601,"Kims",1001,"Hyderabad");
		assertThat(providerPolicy).isNotNull();
	}

	@Test
	void testProviderPolicyCreation() {
		providerPolicy = new ProviderPolicy(1,601,"Kims",1001,"Hyderabad");
		assertNotEquals(501L,providerPolicy.getHospitalId());
		assertEquals(601L,providerPolicy.getHospitalId());
	}
}
