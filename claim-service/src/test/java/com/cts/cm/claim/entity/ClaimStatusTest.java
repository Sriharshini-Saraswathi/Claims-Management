package com.cts.cm.claim.entity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
public class ClaimStatusTest {
		@Mock
		ClaimStatus claimStatus;
		@DisplayName("Checking if ClaimStatus class is responding correctly or not.")
		@Test
		void checkingClaimStatusDetails() {
			claimStatus = new ClaimStatus();
			claimStatus.setClaimId(1);
			claimStatus.setClaimStatus("PendingAction");
			claimStatus.setClaimStatusDescription("Claim Submitted for Review. Review is in process");
			
			assertEquals(1, claimStatus.getClaimId());
			assertEquals("Claim Submitted for Review. Review is in process",claimStatus.getClaimStatusDescription());
			assertEquals("PendingAction",claimStatus.getClaimStatus());
			
		}
	}
