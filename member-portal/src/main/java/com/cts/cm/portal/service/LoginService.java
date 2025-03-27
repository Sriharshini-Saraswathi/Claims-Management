package com.cts.cm.portal.service;

import org.springframework.stereotype.Service;

import com.cts.cm.portal.dto.AuthResponse;
import com.cts.cm.portal.entity.AuthRequest;

@Service
public interface LoginService {

	AuthRequest LoginSaveService(AuthRequest authObj);
	boolean getValidity(String token);
	AuthResponse login(AuthRequest model);
}