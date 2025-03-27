package com.cts.cm.member.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberClaimTest {
	@Mock
	MemberClaim memberClaim;
	@DisplayName("checking if member claim details is loading or not")
	@Test
	void testMemberClaimClass() {
		assertThat(memberClaim).isNotNull();
	}
	@DisplayName("checking if member claim class is responding correctly or not")
	@Test
	void testMemberClaimDetails() {
		memberClaim = new MemberClaim();
		memberClaim.setClaimId(1);
		memberClaim.setMemberId(101);
		memberClaim.setPolicyId(1001);
		memberClaim.setClaimStatus("Pending actions");
		memberClaim.setClaimRemarks("Claim is still pending for approval");
		
		assertEquals(1, memberClaim.getClaimId());
		assertEquals(101, memberClaim.getMemberId());
		assertEquals(1001, memberClaim.getPolicyId());
		assertEquals("Pending actions", memberClaim.getClaimStatus());
		assertEquals("Claim is still pending for approval", memberClaim.getClaimRemarks());
	}
}
