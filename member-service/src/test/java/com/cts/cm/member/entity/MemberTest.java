package com.cts.cm.member.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
	@Mock
	Member member;
	@DisplayName("Checking if Member class is loading or not.")
	@Test
	void testIfMemberDetailsIsPresent() {
		assertThat(member).isNotNull();
	}
	@DisplayName("Checking if Member class is responding correctly or not.")
	@Test
	void checkingMemberDetails() {
		member = new Member();
		member.setMemberId(1);
		member.setMemberName("john");
		member.setPhoneNumber(912345678);
		member.setSalary(25000.75);
		member.setAge(22);
		member.setGender("male");
		
		assertEquals(1, member.getMemberId());
		assertEquals("john", member.getMemberName());
		assertEquals(912345678, member.getPhoneNumber());
		assertEquals(25000.75, member.getSalary());
		assertEquals(22, member.getAge());
		assertEquals("male", member.getGender());
	}
}
