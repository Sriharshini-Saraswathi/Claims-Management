package com.cts.cm.policy.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MemberPolicyTest {

	@Mock
	MemberPolicy memberPolicy;
	
	@Test
	void test1() {
		Date date = Date.valueOf("2021-10-05");
		memberPolicy = new MemberPolicy(1L,101L,1001L,date,12,501L,200000D);
		assertNotNull(memberPolicy);
	}
	
	@Test
	void test2() {
		Date date = Date.valueOf("2021-10-05");
		memberPolicy = new MemberPolicy(1L,101L,1001L,date,12,501L,200000D);
		assertEquals(101L, memberPolicy.getMemberId());
		assertEquals(1001L, memberPolicy.getPolicyId());
		assertEquals(200000D, memberPolicy.getCapAmount());
	}

}
