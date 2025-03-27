package com.cts.cm.member.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
//@Table(name = "mpolicy")
public class MemberPolicy {
	@Id
	@Column(name="policy_id")
	private long policyId;
	@Column(name="member_id")
	private long memberId;	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="policy_date")
	private Date policyDate;
	@Column(name="premium_amount")
	private double premiumAmount;
	@Column(name="top_up")
	private String topUp;
}
