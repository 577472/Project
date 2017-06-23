package com.cognizant.controller;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankMangementException;
import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {

	@Autowired
	ApplyEducationLoanService service;
	UserDetails user;
	boolean flag = true;
	
	
	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanController.class);

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.GET)
	public String getEducationLoan(Model model,@RequestParam("AccName") String AccName,@RequestParam("AccNo") String AccNo) {
		model.addAttribute("educationLoan", new EducationLoan());
		//System.out.println(model.addAttribute("name", AccName));
		model.addAttribute("msg", AccNo);

		model.addAttribute("name", AccName);
		return "insertEducationLoan";
	}

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.POST)
	public String initiateEducationLoan(@ModelAttribute("educationLoan") @Valid EducationLoan educationLoan,
			BindingResult result, Model model,@RequestParam("AccNo") String msg) {
		long accountNumber=Long.parseLong(msg);
		//System.out.println(msg);
		//System.out.println(accountNumber);

		
		try {
			service.updateEducationLoanDetails(educationLoan, accountNumber);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				// result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
				// result.rejectValue(arg0, arg1, arg2);
			}
		} catch (BankMangementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			LOG.error("Validation message: "+e.getMessage());
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			
			result.rejectValue(sb1[0],"", sb1[1]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("m1", educationLoan.getEducationLoanID());
		model.addAttribute("m2", educationLoan.getEduLoanAccountNumber());
		model.addAttribute("msg",msg );

		if (result.hasErrors()) {
			return "insertEducationLoan";
		}

		
		else
			return "successEducationLoan";
			

	}
}