package com.cts.cm.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Benefits {

	@Id
	@Column(name="benefit_id")
	long benefitId;
	
	@Column(name="benefits_availed")
	String benefitsAvailed;
	
}
