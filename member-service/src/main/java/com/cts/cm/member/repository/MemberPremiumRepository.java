package com.cts.cm.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.cm.member.entity.MemberPremium;

@Repository
public interface MemberPremiumRepository extends JpaRepository<MemberPremium, Long>{
	MemberPremium findAllByPolicyIdAndMemberId(long policyId, long memberId);
	
	
	
}
