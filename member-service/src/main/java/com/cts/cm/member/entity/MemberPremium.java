package com.cts.cm.member.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="member_premium")
public class MemberPremium {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mpId;
	@Column(name="member_id")
	private long memberId;
	@Column(name="policy_id")
	private long policyId;
	@Positive
	@Column(name="due_amount")
	private double dueAmount;
	private double charges;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="paid_date")
	private Date paidDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="due_date")
	private Date dueDate;
	
}