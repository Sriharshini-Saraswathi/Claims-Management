package com.cts.cm.member;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.cm.member.controller.MemberController;

@AutoConfigureMockMvc
@SpringBootTest
class MemberServiceApplicationTests {
	@Autowired
	MockMvc mvc;
	@Autowired
	MemberController member;
	
	@Test
	public void test() {
		assertNotNull(member);
	}
	
}