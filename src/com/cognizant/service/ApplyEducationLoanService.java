package com.cognizant.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankMangementException;

@Component
@Transactional
public class ApplyEducationLoanService {

	@Autowired
	ApplyEducationLoanDAO dao;
	EducationLoan edu;
	UserDetails user;
	ApplyEducationLoanService service;
	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanService.class);

	public String generateLoanId(long l) {

		String idcard = String.valueOf(l).substring(0, 5);
		String id = "EL-" + idcard;
		return id;
	}

	public long generateLoanAccountNumber() {
		Long num = (long) (Math.random() * 100000000000000L);
		return num;
	}

	public void insertEducationLoanDetails(UserDetails user) {
		// TODO Auto-generated method stub
		dao.insertEducationLoanDetails(user);
		LOG.info("inservice");
	}

	public void updateEducationLoanDetails(EducationLoan e1, long i) {
		
		String id = generateLoanId(e1.getIdCardNumber());
		e1.setEducationLoanID(id);
		e1.setEduLoanAccountNumber(generateLoanAccountNumber());
		Double courseFee= e1.getCourseFee();// TODO Auto-generated method stub
		/*if(e1.getEduLoanDuration()!=5 || e1.getEduLoanDuration()!=10 )
		{
			throw new BankMangementException("eduLoanDuration:Duration of Loan can be 5 or 10 years only.");
		}
		*/
		if(courseFee> 2000000 ) 
		{
			throw new BankMangementException("courseFee:Course Fee cannot be greater than 20 lacks.");
		}
		
		String name=e1.getFatherName();
		 char[] chars = name.toCharArray();
int count=0;
		    for (char c : chars) {
		        if(!Character.isLetter(c)) {
		        	count++;
		        	
		        }
		    }
		    if(count>=1)
		{
			throw new BankMangementException("fatherName:Father name should contain only alphabets and space.");
		}
		
		
		user = dao.updateEducationLoanDetails(i);

		List<EducationLoan> eduList = user.getEduLoan();
		e1.setUser(user);
		LOG.info(e1);
		eduList.add(e1);
		user.setEduLoan(eduList);
		LOG.info(user);
		
		
		

	}

}
