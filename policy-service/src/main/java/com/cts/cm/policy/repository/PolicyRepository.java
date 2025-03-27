package com.cts.cm.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.cm.policy.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long>{

}
