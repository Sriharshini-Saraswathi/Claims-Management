package com.cts.cm.policy.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class BenefitsTest {

	@Mock
	Benefits benefits;
	
	@Test
	void test1() {
		benefits = new Benefits(1,"Covid top up");//mock(Benefits.class);
		assertNotNull(benefits);
	}
	
	void test2() {
		benefits = new Benefits(1,"Covid top up");
		assertEquals(1,benefits.getBenefitId());
	}
	
	void test3() {
		benefits = new Benefits(1,"Covid top up");
		assertEquals("Covid top up",benefits.getBenefitsAvailed());
	}

}
