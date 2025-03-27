package com.cts.cm.portal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LoginDetails")

@Getter
@Setter
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest{
	@Id
	private String userName;
	private String password;
}