package com.cts.cm.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.cm.claim.entity.Claim;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	List<Claim> findAllByMemberIdAndPolicyId(long memberId, long policyId);
}
