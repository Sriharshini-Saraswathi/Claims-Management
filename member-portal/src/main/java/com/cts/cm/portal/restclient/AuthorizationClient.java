package com.cts.cm.portal.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.cm.portal.dto.AuthResponse;
import com.cts.cm.portal.dto.ValidatingDTO;
import com.cts.cm.portal.entity.AuthRequest;

@FeignClient(name="AUTHORIZATION-SERVICE", url = "localhost:8008/authorization")
//@FeignClient(name="AUTHORIZATION-SERVICE", url = "claim-authlb-935172-888390088.ap-northeast-1.elb.amazonaws.com/authorization")
public interface AuthorizationClient {
	@PostMapping("/login")
    public AuthResponse createAuthorizationToken(@RequestBody AuthRequest request);
	
	@GetMapping( path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ValidatingDTO validatingAuthorizationToken(@RequestHeader(name = "Authorization" ) String token);
	
	
}
