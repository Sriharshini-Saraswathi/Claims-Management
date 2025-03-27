package com.cts.cm.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.cm.policy.entity.ProviderPolicy;

@Repository
public interface ProviderPolicyRepository extends JpaRepository<ProviderPolicy, Long>{

	List<ProviderPolicy> findAllByPolicyIdOrderByLocation(long PolicyId);
	
}
