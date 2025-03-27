package com.cts.cm.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.cm.authorization.exception.LoginException;
import com.cts.cm.authorization.model.AuthenticationRequest;
import com.cts.cm.authorization.repository.AuthRequestRepo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	AuthRequestRepo authRequestRepo;
	
	
	/**
	 * This method loads UserDetails containing userName and Password from Database
	 * @param userName
	 * @return userDetails
	 * @throws UsernameNotFoundException
	 */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("BEGIN - [loadUserByUsername()]");
		log.debug(userName);
	  	UserDetails userDetails=null;
    	AuthenticationRequest authenticationRequest = authRequestRepo.findById(userName).orElse(null);
		if(authenticationRequest!=null) 
		{
			userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(), new ArrayList<>());
			log.debug("User : " + userDetails);
			log.info("User : " + userDetails);
			log.info("END - [loadUserByUsername()]");
		}		
		return userDetails;
    }

    
    /**
     * This method updates the oldPassword with the newPassword of the user
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return newPassword
	 * @throws UsernameNotFoundException
	 * @throws LoginException
	 */
    public String changePassword(String userName, String oldPassword, String newPassword) throws LoginException, UsernameNotFoundException{
		log.info("BEGIN - [updateUserPassword()]");
		log.debug("Current Password : "+ oldPassword);
		AuthenticationRequest authenticationRequest = authRequestRepo.findById(userName).orElse(null);
		if(authenticationRequest!=null){
			if(authenticationRequest.getPassword().equals(oldPassword)) {
				authenticationRequest.setPassword(newPassword);
			}
			else{
				throw new LoginException("Old Password is Incorrect");
			}
		}
		else{
			throw new LoginException("Invalid Username");
		}
		authRequestRepo.save(authenticationRequest);
		UserDetails user = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(), new ArrayList<>());
		log.info("END - [updateUserPassword()]");
		return user.getPassword();
	}
} 
  