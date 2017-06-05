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
	public String getEducationLoan(Model model) {
		model.addAttribute("educationLoan", new EducationLoan());
		return "insertEducationLoan";
	}

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.POST)
	public String initiateEducationLoan(@ModelAttribute("educationLoan") @Valid EducationLoan educationLoan,
			BindingResult result, Model model) {

		String id = service.generateLoanId(educationLoan.getIdCardNumber());
		educationLoan.setEducationLoanID(id);
		educationLoan.setEduLoanAccountNumber(service.generateLoanAccountNumber());

		try {
			service.updateEducationLoanDetails(educationLoan, 1234567890123456L);
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

		if (result.hasErrors()) {
			return "insertEducationLoan";
		}
		if(flag)

		return "successEducationLoan";
		else
			return "insertEducationLoan";
			

	}
}