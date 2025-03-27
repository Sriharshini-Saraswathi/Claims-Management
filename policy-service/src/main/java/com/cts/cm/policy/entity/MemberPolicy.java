package com.cts.cm.policy.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member_policy")
public class MemberPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long mpoId;
	@Column(name="member_id")
	long memberId;
	
	@Column(name="policy_id")
	long policyId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="subscription_date")
	Date subscriptionDate;
	
	int tenure;
	
	@Column(name="benefit_id")
	long benefitId;
	
	@Column(name="cap_amount")
	double capAmount;
}
