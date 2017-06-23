package com.cognizant.controller;

import java.util.ArrayList;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewHomeLoanService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ViewHomeLoanController {

	@Autowired
	ViewHomeLoanService viewHomeLoanService;
	private List<HomeLoan> homeLoans = new ArrayList<HomeLoan>();

	private static final Logger LOG = Logger.getLogger(ViewHomeLoanController.class);

	@RequestMapping(value = "/viewHomeLoan", method = RequestMethod.GET)
	public String getHOmeLoan(Model model,@RequestParam("AccNo") String AccNo,@RequestParam("AccName") String AccName) {
		model.addAttribute("msg", AccNo);
		model.addAttribute("name",AccName);
		return "viewHomeLoan";
	}

	@RequestMapping(value = "/viewHomeLoan1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<HomeLoan> gethomeLoan(@RequestParam("AccNo") String msg) {
		long accountNumber=Long.parseLong(msg);
		//System.out.println(msg);
		//System.out.println(accountNumber);

		homeLoans = viewHomeLoanService.retrieveHomeDetails(accountNumber);
//System.out.println(homeLoans);
		LOG.info("in control");

		LOG.info(homeLoans);

		return homeLoans;

	}

}
