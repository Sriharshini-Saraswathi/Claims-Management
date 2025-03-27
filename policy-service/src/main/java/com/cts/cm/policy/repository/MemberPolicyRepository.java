package com.cts.cm.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.cm.policy.entity.MemberPolicy;

@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy,Long>{

	List<MemberPolicy> findAllByPolicyIdAndMemberId(long policyId, long memberId);
	
	@Query("from MemberPolicy mp where mp.policyId=?1 and mp.memberId=?2")
	MemberPolicy getEligibleClaimAmount(long policyId, long memberId);
}
