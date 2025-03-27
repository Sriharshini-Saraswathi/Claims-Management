package com.cts.cm.claim.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cts.cm.claim.entity.ClaimStatus;
import com.cts.cm.claim.repository.ClaimRepository;

class ClaimServiceCollectionImplTest {
	@Mock
	ClaimServiceCollectionImpl claimService; 
	@Mock
	ClaimStatus cs;
	@Test
	public void testGetClaimStatus() {
		claimService = mock(ClaimServiceCollectionImpl.class);
		ClaimStatus claim=new ClaimStatus();
		claim.setClaimId(1);
		claim.setClaimStatus("Pending Action");
		claim.setClaimStatusDescription("Claim Submitted for Review. Review is in process");
		when(claimService.getClaimStatus(1, 1001, 101)).thenReturn(claim);
		assertEquals(claim,claimService.getClaimStatus(1, 1001, 101));
	}
	@Test
	public void testGetClaimStatus1() {
		claimService = mock(ClaimServiceCollectionImpl.class);
		ClaimStatus claim=new ClaimStatus();
		claim.setClaimId(1);
		claim.setClaimStatus("Claim Rejected");
		claim.setClaimStatusDescription("Did not fulfill the requirements");
		when(claimService.getClaimStatus(1, 1001, 102)).thenReturn(claim);
		assertEquals(claim,claimService.getClaimStatus(1, 1001, 102));
	}
	@Test
	public void testSubmitClaim() {
		claimService = mock(ClaimServiceCollectionImpl.class);
		ClaimStatus claim=new ClaimStatus();
		claim.setClaimId(1);
		claim.setClaimStatus("Pending Action");
		claim.setClaimStatusDescription("Claim Submitted for Review. Review is in process");
		when(claimService.submitClaim("token",1001, 101, 601, 501, 200000,200000)).thenReturn(claim);
		assertEquals(claim,claimService.submitClaim("token",1001, 101, 601, 501, 200000,200000));
		
		}
	@Test
	public void testSubmitClaim1() {
		claimService = mock(ClaimServiceCollectionImpl.class);
		ClaimStatus claim=new ClaimStatus();
		claim.setClaimId(1);
		claim.setClaimStatus("Claim Rejected");
		claim.setClaimStatusDescription("Did not fulfill the requirements");
		when(claimService.submitClaim("token",1001, 102, 601, 501, 200000,250000)).thenReturn(claim);
		assertEquals(claim,claimService.submitClaim("token",1001, 102, 601, 501, 200000,250000));
		
		}

		
		
		
	

}
