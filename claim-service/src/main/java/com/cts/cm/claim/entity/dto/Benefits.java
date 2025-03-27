package com.cts.cm.claim.entity.dto;

import lombok.Data;

@Data
public class Benefits {
	private long benefitId;
	private String benefitsAvailed;
	public long getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(long benefitId) {
		this.benefitId = benefitId;
	}
	public String getBenefitsAvailed() {
		return benefitsAvailed;
	}
	public void setBenefitsAvailed(String benefitsAvailed) {
		this.benefitsAvailed = benefitsAvailed;
	}

	

	
}
