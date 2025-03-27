package com.cts.cm.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.cm.portal.entity.AuthRequest;

@Repository
public interface LoginRepo extends JpaRepository<AuthRequest, String>{

}
