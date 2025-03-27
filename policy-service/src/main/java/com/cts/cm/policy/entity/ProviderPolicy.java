package com.cts.cm.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="provider_policy")
public class ProviderPolicy {

	@Override
	public String toString() {
		return "ProviderPolicy [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", policyId=" + policyId
				+ ", location=" + location + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long ppId;
	@Column(name="hospital_id")
	long hospitalId;
	
	@Column(name="hospital_name")
	String hospitalName;
	
	@Column(name="policy_id")
	long policyId;
	
	String location;
	
}
