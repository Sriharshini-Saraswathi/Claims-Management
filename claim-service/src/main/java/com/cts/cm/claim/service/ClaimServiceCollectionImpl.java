package com.cts.cm.claim.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cm.claim.entity.Claim;
import com.cts.cm.claim.entity.ClaimStatus;
import com.cts.cm.claim.entity.dto.Benefits;
import com.cts.cm.claim.entity.dto.ProviderPolicy;
import com.cts.cm.claim.repository.ClaimRepository;
import com.cts.cm.claim.restclient.PolicyClient;

@Service
public class ClaimServiceCollectionImpl implements ClaimService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimServiceCollectionImpl.class);

	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private PolicyClient policyClient;

	@Override
	public ClaimStatus getClaimStatus(long claimId, long policyId, long memberId) {
		Claim claim = claimRepository.getOne(claimId);
		List<Claim> claims = claimRepository.findAllByMemberIdAndPolicyId(memberId, policyId);
		for(Claim c: claims) {
			if(c.getClaimId()==claim.getClaimId()) {
				ClaimStatus claimStatus = new ClaimStatus();
				claimStatus.setClaimId(claim.getClaimId());
				claimStatus.setClaimStatus(claim.getClaimStatus());
				claimStatus.setClaimStatusDescription(claim.getClaimRemarks());
				return claimStatus;
			}
				
		}
		ClaimStatus claimStatus = new ClaimStatus();
		claimStatus.setClaimId(claim.getClaimId());
		claimStatus.setClaimStatus("No Record Found");
		claimStatus.setClaimStatusDescription("Please enter valid details");
		return claimStatus;
	}

	@Override
	public ClaimStatus submitClaim(String requestTokenHeader, long policyId, long memberId, long hosptialId,
			long benefitId, double totalBilledAmount, double totalClaimedAmount) {
		int condition = 0;
		Claim claim = new Claim();
		claim.setPolicyId(policyId);
		claim.setMemberId(memberId);
		claim.setHospitalId(hosptialId);
		claim.setBenefitId(benefitId);
		claim.setClaimedAmount(totalClaimedAmount);
		claim.setTotalBillAmount(totalBilledAmount);
		if (policyClient.getEligibleClaimAmount(requestTokenHeader, policyId, memberId, benefitId) >= 0) {

			if (policyClient.getEligibleClaimAmount(requestTokenHeader, policyId, memberId,
					benefitId) == totalClaimedAmount) {
				condition++;
			}
				List<Benefits> benefitList = policyClient.getEligibleBenefits(requestTokenHeader, policyId, memberId);
				LOGGER.debug("benefits list: {}", benefitList);
				for (int i = 0; i < benefitList.size(); i++) {
					if (benefitList.get(i).getBenefitId() == benefitId) {
						condition++;
					}
				}
				List<ProviderPolicy> providerList = policyClient.getChainOfProviders(requestTokenHeader, policyId);
				for (int i = 0; i < providerList.size(); i++) {
					if (providerList.get(i).getHospitalId() == hosptialId) {
						condition++;
					}
				}
				if (condition == 3) {
					claim.setClaimStatus("Pending Action");
					claim.setClaimRemarks("Claim Submitted for Review. Review is in process");
					claim.setSettled("No");
					Claim tempClaim = claimRepository.save(claim);
					ClaimStatus claimStatus = new ClaimStatus();
					claimStatus.setClaimId(tempClaim.getClaimId());
					claimStatus.setClaimStatus(tempClaim.getClaimStatus());
					claimStatus.setClaimStatusDescription(tempClaim.getClaimRemarks());
					return claimStatus;

				} else {
					claim.setClaimStatus("Claim Rejected");
					claim.setClaimRemarks("Did not fulfill the requirements");
					claim.setSettled("No");
					Claim tempClaim = claimRepository.save(claim);
					ClaimStatus claimStatus = new ClaimStatus();
					claimStatus.setClaimId(tempClaim.getClaimId());
					claimStatus.setClaimStatus(tempClaim.getClaimStatus());
					claimStatus.setClaimStatusDescription(tempClaim.getClaimRemarks());
					return claimStatus;
				}
			
		} else {
			claim.setClaimStatus("Insufficient Claim Details");
			claim.setClaimRemarks("Data provided is not available in database");
			claim.setSettled("No");
			Claim tempClaim = claimRepository.save(claim);
			ClaimStatus claimStatus = new ClaimStatus();
			claimStatus.setClaimId(tempClaim.getClaimId());
			claimStatus.setClaimStatus(tempClaim.getClaimStatus());
			claimStatus.setClaimStatusDescription(tempClaim.getClaimRemarks());
			return claimStatus;
		}

	}

}