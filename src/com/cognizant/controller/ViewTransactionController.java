package com.cognizant.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ViewTransactionController {
	@Autowired
	PerformTransactionService service;
	TransactionDetails transactionDetails;

	private static final Logger LOG = Logger.getLogger(ViewTransactionController.class);

	@RequestMapping(value = "/getTransaction", method = RequestMethod.GET)
	public String searchUserTransaction(Model model,@RequestParam("AccNo") String AccNo,@RequestParam("AccName") String AccName) {
		model.addAttribute("msg", AccNo);
		model.addAttribute("name",AccName);
		return "getTransaction";
	}

	@RequestMapping(value = "/getTransactionDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<TransactionDetails> getUserDetails(@RequestParam("AccNo") String msg) {
		long accountNumber=Long.parseLong(msg);
		//System.out.println(msg);
		//System.out.println(accountNumber);

		List<TransactionDetails> transactionDetailsList = service.retrieveTransactionDetails(accountNumber);

		LOG.info("controller:" + transactionDetailsList);
		return transactionDetailsList;

	}

}
