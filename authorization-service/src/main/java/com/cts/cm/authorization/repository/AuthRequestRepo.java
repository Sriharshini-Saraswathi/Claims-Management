package com.cts.cm.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cm.authorization.model.AuthenticationRequest;

public interface AuthRequestRepo extends JpaRepository<AuthenticationRequest, String> {

}
