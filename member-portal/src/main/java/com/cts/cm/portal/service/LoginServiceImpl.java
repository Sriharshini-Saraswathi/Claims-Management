package com.cts.cm.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cm.portal.dto.AuthResponse;
import com.cts.cm.portal.entity.AuthRequest;
import com.cts.cm.portal.repository.LoginRepo;
import com.cts.cm.portal.restclient.AuthorizationClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepo repo;
	@Autowired
	AuthorizationClient authClient;
	@Override
	public AuthRequest LoginSaveService(AuthRequest authObj) {
		log.info("saving login details");
		repo.save(authObj);
		log.info("saved login details");
		return authObj;
	}

	@Override
	public boolean getValidity(String token) {
		log.info("checking token validity details");
		boolean vals = authClient.validatingAuthorizationToken(token).isValidStatus();
		log.debug("Vals: {}",vals);
		log.info("validity status sent");
		return vals;
	}

	@Override
	public AuthResponse login(AuthRequest model) {
		log.info("generate token");
		model = LoginSaveService(model);
		return authClient.createAuthorizationToken(model);
	}

}
