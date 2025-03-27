package com.cts.cm.member.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.cm.member.dto.ViewBillDto;
import com.cts.cm.member.entity.MemberPremium;
import com.cts.cm.member.exception.FileNotFoundException;
import com.cts.cm.member.repository.MemberPremiumRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberServiceImplTest {
	@InjectMocks
	private MemberServiceImpl service;
	private MemberPremium member;
	private ViewBillDto bill;
	@Mock
	private MemberPremiumRepository repo;
	
	@Test
	void repairServiceImplNotNullTest() {
		assertThat(service).isNotNull();
	}
	@BeforeEach
	void setUp() throws ParseException {
		member = new MemberPremium();
		member.setMpId(1);
		member.setMemberId(101);
		member.setPolicyId(1001);
		member.setCharges(60600);
		member.setDueDate(new Date(2014, 02, 11));
		member.setPaidDate(new Date(2014, 12, 11));
		member.setDueAmount(20000);
		
		bill = new ViewBillDto();
		bill.setMemberId(101);
		bill.setPolicyId(1001);
		bill.setCharges(60600);
		bill.setDueAmount(20000);
		bill.setDueDate(new Date(2014, 02, 11));
		bill.setPaidDate(new Date(2014, 12, 11));
	}
	@Test
	void testViewBillsPositive() {
		assertEquals(bill.getMemberId(), member.getMemberId());
		assertEquals(bill.getPolicyId(), member.getPolicyId());
		assertEquals(bill.getCharges(), member.getCharges());
		assertEquals(bill.getDueAmount(), member.getDueAmount());
		assertEquals(bill.getDueDate(), member.getDueDate());
		assertEquals(bill.getPaidDate(), member.getPaidDate());
	}
	@Test
	void testViewBillsNegative() throws FileNotFoundException {
		FileNotFoundException thrown = Assertions.assertThrows(FileNotFoundException.class,
				() -> service.viewBills(1, 2));
		assertEquals("Record Not Found", thrown.getMessage());

	}
}
