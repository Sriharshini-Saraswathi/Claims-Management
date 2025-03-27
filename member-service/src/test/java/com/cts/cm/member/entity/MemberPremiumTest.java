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
class MemberPremiumTest {
	@Mock
	MemberPremium memberPremium;
	@DisplayName("To validate that member premium is not null")
	@Test
	void testMemberPremium() {
		assertThat(memberPremium).isNotNull();
	}
	@Test
	void testMemberPremiumDetails() {
		memberPremium = new MemberPremium();
		memberPremium.setMpId(1);
		memberPremium.setMemberId(101);
		memberPremium.setPolicyId(1001);
		memberPremium.setCharges(12000.00);
		memberPremium.setDueAmount(12000.00);
		memberPremium.setDueDate(new Date(2014, 02, 11));
		memberPremium.setPaidDate(new Date(2014, 12, 11));
		
		assertEquals(1, memberPremium.getMpId());
		assertEquals(101, memberPremium.getMemberId());
		assertEquals(1001, memberPremium.getPolicyId());
		assertEquals(12000.00, memberPremium.getCharges());
		assertEquals(12000.00, memberPremium.getDueAmount());
		assertEquals(new Date(2014, 02, 11), memberPremium.getDueDate());
		assertEquals(new Date(2014, 12, 11), memberPremium.getPaidDate());
	}

}
