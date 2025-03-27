package com.cts.cm.policy.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.cm.policy.entity.ValidatingDTO;



//@FeignClient(name="AUTHORIZATION-SERVICE",url = "claim-authlb-935172-888390088.ap-northeast-1.elb.amazonaws.com/authorization")
@FeignClient(name="AUTHORIZATION-SERVICE",url = "localhost:8008/authorization")
public interface AuthorizationClient {
	@GetMapping( path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ValidatingDTO validatingAuthorizationToken(@RequestHeader(value="Authorization",required=true) String requestTokenHeader);

}
