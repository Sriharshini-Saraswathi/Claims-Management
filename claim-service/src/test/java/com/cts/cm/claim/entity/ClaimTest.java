package com.cts.cm.claim.entity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
	public class ClaimTest {
		@Mock
		Claim claim;
		@DisplayName("Checking if Claim class is responding correctly or not.")
		@Test
		void checkingClaimDetails() {
			claim = new Claim();
			claim.setBenefitId(501);
			claim.setClaimedAmount(200000);
			claim.setClaimId(1);
			claim.setClaimRemarks("Claim Submitted for Review. Review is in process");
			claim.setClaimStatus("PendingAction");
			claim.setHospitalId(601);
			claim.setMemberId(101);
			claim.setPolicyId(1001);
			claim.setSettled("yes");
			claim.setTotalBillAmount(200000);
		
			
			assertEquals(501, claim.getBenefitId());
			assertEquals(200000,claim.getClaimedAmount());
			assertEquals(1,claim.getClaimId());
			assertEquals("Claim Submitted for Review. Review is in process",claim.getClaimRemarks());
			assertEquals("PendingAction",claim.getClaimStatus());
			assertEquals(601,claim.getHospitalId());
			assertEquals(101,claim.getMemberId());
			assertEquals(1001,claim.getPolicyId());
			assertEquals("yes",claim.getSettled());
			assertEquals(200000,claim.getTotalBillAmount());
			
		}
	}
