package com.cts.cm.policy.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.cm.policy.entity.ProviderPolicy;
import com.cts.cm.policy.entity.ValidatingDTO;
import com.cts.cm.policy.restclient.AuthorizationClient;
import com.cts.cm.policy.service.PolicyServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class PolicyControllerTest {
	
	@Mock
	AuthorizationClient authorizationClient;
	
	@Mock
	PolicyServiceImpl policyServiceImpl; 
	
	@Mock
	PolicyController policyController; 
	
	@Mock
	ProviderPolicy pp;
	
	@Autowired
	MockMvc mvc;

	@Test
	void testGetChainOfHealthProviders1() {
		
		authorizationClient = mock(AuthorizationClient.class);
		policyServiceImpl = mock(PolicyServiceImpl.class);
		policyController = mock(PolicyController.class);
		
		ValidatingDTO dto = new ValidatingDTO(true);
		List<ProviderPolicy> list = new ArrayList<ProviderPolicy>();
		list.add(new ProviderPolicy(1,601,"Kims",1001,"Hyderabad"));
		
		when(authorizationClient.validatingAuthorizationToken("token")).thenReturn(dto);
		when(policyServiceImpl.getChainOfHealthProviders(1001)).thenReturn(list);
		ResponseEntity<?> response = policyController.getChainOfHealthProviders("token", 1001);
		
		assertNotNull(policyServiceImpl.getChainOfHealthProviders(1001));
	}
	

}
