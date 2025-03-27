package com.cts.cm.member.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBillDto {
	private long memberId;
	private long policyId;
	private double dueAmount;
	private double charges;
	private Date paidDate;
	private Date dueDate;
}
