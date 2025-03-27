package com.cts.cm.member.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberPolicyTest {
	@Mock
	MemberPolicy memberPolicy;
	@DisplayName("checking is member policy is loading or not")
	@Test
	void testMemberPolicyIsPresent() {
		assertThat(memberPolicy).isNotNull();
	}
	void testMemberPolicyDetails() {
		memberPolicy = new MemberPolicy();
		//String sDate = 
		memberPolicy.setMemberId(101);
		memberPolicy.setPolicyId(1001);
		memberPolicy.setPolicyDate(new Date(2014, 02, 11));
		memberPolicy.setPremiumAmount(250000.00);
		memberPolicy.setTopUp("full");
		
		assertEquals(101, memberPolicy.getMemberId());
		assertEquals(1001, memberPolicy.getPolicyId());
		assertEquals(new Date(2014, 02, 11), memberPolicy.getPolicyDate());
		assertEquals(250000.00, memberPolicy.getPremiumAmount());
		assertEquals("full", memberPolicy.getTopUp());
	}
}
