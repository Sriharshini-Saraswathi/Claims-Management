package com.cts.cm.member.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLEngineResult.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.cm.member.dto.ClaimStatus;
import com.cts.cm.member.entity.MemberPremium;
import com.cts.cm.member.exception.FileNotFoundException;
import com.cts.cm.member.repository.MemberPremiumRepository;
import com.cts.cm.member.restclient.ClaimRestClient;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberPremiumRepository memberRepository;
	@Autowired
	private ClaimRestClient client;
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public MemberPremium viewBills(long memberId, long policyId) throws FileNotFoundException{	
		MemberPremium mp=memberRepository.findAllByPolicyIdAndMemberId(policyId, memberId);
		LOGGER.info("Start");
		LOGGER.info("memberId:{}",memberId);
		LOGGER.info("policyId:{}",policyId);
		if(mp!=null)
		{
		if(mp.getPaidDate().before(mp.getDueDate()))
			mp.setCharges(0);
		else {
			 long diffInMillies = Math.abs(mp.getPaidDate().getTime() - mp.getDueDate().getTime());
			 if(diffInMillies>0)
				 mp.setCharges(mp.getDueAmount()*0.01 * TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
		}
		memberRepository.save(mp);
		LOGGER.info("END");
		return mp;
		}
		
		throw new FileNotFoundException("Record Not Found");
	}

	@Override
	public ClaimStatus getClaimStaus(String requestTokenHeader,long claimId, long policyId, long memberId) {
		return client.getClaimStatus(requestTokenHeader,claimId, policyId, memberId);
	}
	@Override
	public ClaimStatus submitClaim(String requestTokenHeader,long policyId, long memberId, long hospitalId, long benefitId,
			double totalBilledAmount, double totalClaimedAmount) {
		return client.submitClaim(requestTokenHeader,policyId, memberId, hospitalId, benefitId, totalBilledAmount, totalClaimedAmount);
	}

	

}
