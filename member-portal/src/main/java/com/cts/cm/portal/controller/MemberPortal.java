package com.cts.cm.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cts.cm.portal.dto.AuthResponse;
import com.cts.cm.portal.dto.ClaimStatus;
import com.cts.cm.portal.dto.MemberPremiumDto;
import com.cts.cm.portal.entity.AuthRequest;
import com.cts.cm.portal.exception.FileNotFoundException;
import com.cts.cm.portal.model.ViewBillRequest;
import com.cts.cm.portal.restclient.AuthorizationClient;
import com.cts.cm.portal.restclient.MemberClient;
import com.cts.cm.portal.service.LoginServiceImpl;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
@Api(value="memberportal", description="MVC Member Portal")
public class MemberPortal {

	@Autowired
	AuthorizationClient authClient;

	@Autowired
	MemberClient memberClient;
	@Autowired
	LoginServiceImpl service;

	@GetMapping("/login")
	public ModelAndView showLogin() {
		log.info("Login Page");
		ModelAndView model = new ModelAndView("loginpage");
		model.addObject("model", new AuthRequest());
		return model;
	}

	@PostMapping("/login")
	@ApiOperation(value="navigate to home page",notes="User will be able to navigate to the Home page",response=ModelAndView.class)
	public ModelAndView performLogin(@Valid @ModelAttribute("model") AuthRequest model, BindingResult result,
			HttpServletRequest request) throws FeignException {
		ModelAndView mv = new ModelAndView("loginpage");
		log.info("Post Login");
		log.debug("Login details: {}", model);
		log.info("Before Token generation");
		AuthResponse token = null;
		try {
			token = service.login(model);
		} catch (Exception e) {
			log.info("Exception");
			mv.addObject("loggedout", "Invalid Credentials");
			return mv;
		}

		request.getSession().setAttribute("Authorization", "Bearer " + token.getJwtAuthToken());
		request.getSession().setAttribute("user", model.getUserName());
		log.info(token.getJwtAuthToken());
		log.info("After Token generation");

		return new ModelAndView(new RedirectView("homepage"));
	}

	@GetMapping("/homepage")
	public ModelAndView displayHomePage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("Authorization");
		log.info(token);
		ModelAndView mv =  new ModelAndView("homepage");
		return mv;
	}

	@GetMapping("/viewbills")
	public ModelAndView displayViewBillsPage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("Authorization");
		log.info(token);
		ModelAndView mv = new ModelAndView("viewbills");
		mv.addObject("model", new MemberPremiumDto());
		return mv;
	}

	@PostMapping("/showbill")
	public ModelAndView postViewBills(@RequestParam("memberId") long memberId, @RequestParam("policyId") long policyId,
			HttpServletRequest request) throws FileNotFoundException{
		ModelAndView mv = new ModelAndView("viewbills");
		String token = (String) request.getSession().getAttribute("Authorization");
		ViewBillRequest model = new ViewBillRequest(memberId, policyId);
		log.info(token);
		boolean valid = service.getValidity(token);
		if (valid) {
			try {
				MemberPremiumDto memberpremium = memberClient.viewBills(token, model.getMemberId(),
						model.getPolicyId());
				log.debug("member details:{}", memberpremium);
				mv = new ModelAndView("showbill");
				mv.addObject("memberpremium", memberpremium);
				return mv;
			} catch (Exception ex) {
				log.info("exception");
				mv = new ModelAndView("viewbills");
				mv.addObject("invalidMessage", "Record Not Found!");
				return mv;
			}
		} else {
			mv = new ModelAndView("loginpage");
			mv.addObject("invalidMessage", "Your session is expired. Please login again");
			return mv;
		}
	}

	@GetMapping("/claimstatus")
	public ModelAndView displayClaimStatusPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("claimstatus");
		log.debug("Token at claim status:{}", request.getSession().getAttribute("Authorization"));
		return mv;
	}

	@PostMapping("/claimstatus")
	public ModelAndView displayClaimStatusOutputPage(ModelMap model, @RequestParam("claimId") long claimId,
			@RequestParam("policyId") long policyId, @RequestParam("memberId") long memberId,
			HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("Authorization");
		ModelAndView mv = new ModelAndView("claimStatusOutput");
		log.info(token);
		try {
			ClaimStatus claimStatus = memberClient.getClaimStatus(token, claimId, policyId, memberId);
			model.put("claimStatus", claimStatus);
			log.debug("claim status:{}", claimStatus);
			mv = new ModelAndView("claimStatusOutput");
			mv.addObject("claimstatus", claimStatus);
			return mv;

		} catch (Exception e) {
			mv = new ModelAndView("claimstatus");
			log.info("exception");
			mv.addObject("invalidMessage", "claim status not found");
			return mv;
		}

	}

	@GetMapping("/submitclaim")
	public ModelAndView displaySubmitClaimPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("submitclaim");
		log.debug("Token at claim status:{}", request.getSession().getAttribute("Authorization"));
		return mv;
	}

	@PostMapping("/submitclaim")
	public ModelAndView displaySubmitClaimStatusPage(ModelMap model, @RequestParam("policyId") long policyId,
			@RequestParam("memberId") long memberId, @RequestParam("hospitalId") long hospitalId,
			@RequestParam("benefitId") long benefitId, @RequestParam("totalBilledAmount") double totalBilledAmount,
			@RequestParam("totalClaimedAmount") double totalClaimedAmount, HttpServletRequest request) {
		log.debug("policyId:{}", policyId);
		log.debug("memberId:{}", memberId);
		log.debug("benefitId:{}", benefitId);
		log.debug("hospitalId:{}", hospitalId);
		log.debug("totalBilledAmount:{}", totalBilledAmount);
		log.debug("totalClaimedAmount:{}", totalClaimedAmount);
		String token = (String) request.getSession().getAttribute("Authorization");
		ModelAndView mv = new ModelAndView("submitclaim");
		log.info(token);
		try {
			ClaimStatus claimStatus = memberClient.submitClaim(token, policyId, memberId, hospitalId, benefitId, totalBilledAmount, totalClaimedAmount);
			model.put("claimStatus", claimStatus);
			log.debug("claim status:{}", claimStatus);
			mv = new ModelAndView("claimStatusOutput");
			mv.addObject("claimstatus", claimStatus);
			return mv;

		} catch (Exception e) {
			mv = new ModelAndView("claimStatusOutput");
			mv.addObject("invalidMessage", "Invalid Credentials entered");
			return mv;
		}
	}

	@GetMapping("/logout")
	public String logoutpage(ModelMap model) {
		model.addAttribute("loggedout", "Successfully Logged Out");
		return "loginpage";
	}

}
