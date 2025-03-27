package com.cts.cm.member.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
//@Table(name = "member_claim")
public class MemberClaim {
	@Id
	@Column(name="claim_id")
	private long claimId;
	@Column(name="member_id")
	private long memberId;
	@Column(name="policy_id")
	private long policyId;
	@NotNull
	@Column(name="claim_status")
	private String claimStatus;
	@Column(name="claim_remarks")
	private String claimRemarks;
}
