package com.cts.cm.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Policy {
	
	@Id
	@Column(name="policy_id")
	long policyId;
	
	@Column(name="premium_amount")
	double premiumAmount;
	
	int tenure;
	
	@Column(name="benefit_id")
	long benefitId;

}
