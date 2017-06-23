package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.ViewHomeLoanDao;
import com.cognizant.entity.HomeLoan;
import com.cognizant.service.ViewHomeLoanService;
@Controller
public class restController {
	@Autowired
	ViewHomeLoanDao viewHomeLoanDao;
	private List<HomeLoan> homeLoans = new ArrayList<HomeLoan>();

	private static final Logger LOG = Logger.getLogger(ViewHomeLoanController.class);
	@RequestMapping(value = "/restjsp", method = RequestMethod.GET)
	public String HOmeLoan() {
		
		return "restjsp";
	}
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String getHOmeLoan(Model model,@RequestParam("AccNo") String AccNo,@RequestParam("LoanAccNo") String LoanAccNo) {
		model.addAttribute("msg", AccNo);
		model.addAttribute("loan",LoanAccNo);
		System.out.println(LoanAccNo);
		return "viewreatjsp";
	}

	@RequestMapping(value = "/viewHome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<HomeLoan> gethomeLoan(@RequestParam("LoanAccNo") String loan) {
		long accountNumber=Long.parseLong(loan);
		//System.out.println(msg);
		System.out.println(accountNumber);

		homeLoans = viewHomeLoanDao.retrieve(accountNumber);
System.out.println(homeLoans);
		LOG.info("in control");

		LOG.info(homeLoans);

		return homeLoans;

	}

}

