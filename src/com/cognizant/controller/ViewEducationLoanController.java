package com.cognizant.controller;

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

import com.cognizant.entity.EducationLoan;
import com.cognizant.service.ViewEducationLoanService;

@Controller
public class ViewEducationLoanController {

	@Autowired
	ViewEducationLoanService service;
	List<EducationLoan> eduLoan;

	private static final Logger LOG = Logger.getLogger(ViewEducationLoanController.class);

	@RequestMapping(value = "/viewEducationLoanDetails", method = RequestMethod.GET)
	public String getEducationLoans(Model model,@RequestParam("AccNo") String AccNo,@RequestParam("AccName") String AccName) {
		model.addAttribute("msg", AccNo);
		model.addAttribute("name",AccName);
		return "viewEducationLoanDetails";
	}

	@RequestMapping(value = "/viewEducationLoanDetails1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<EducationLoan> getEduLoan(@RequestParam("AccNo") String msg) {
		long accountNumber=Long.parseLong(msg);
		//System.out.println(msg);
		//System.out.println(accountNumber);


		List<EducationLoan> eduLoan = service.retriveEducationLoanDetails(accountNumber);

		LOG.info("in control");

		LOG.info(eduLoan);

		return eduLoan;

	}

}
