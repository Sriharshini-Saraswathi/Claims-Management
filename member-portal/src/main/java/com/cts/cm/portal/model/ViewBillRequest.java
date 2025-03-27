package com.cts.cm.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBillRequest {
	private long memberId;
	private long policyId;
}
