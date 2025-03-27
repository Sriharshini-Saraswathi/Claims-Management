package com.cts.cm.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberId;
	@NotNull
	@Column(name="member_name")
	private String memberName;
	@NotNull
	@Column(name="phone_number")
	private long phoneNumber;
	@NotNull
	private int age;
	@NotNull
	private String gender; 
	@NotNull
	@Positive
	private double salary;
	
}