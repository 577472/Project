package test.java;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyEducationLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestEducationLoan {

	@Autowired
	ApplyEducationLoanService service;

	private List<EducationLoan> eduLoan;
	private UserDetails user;

	@Before
	public void setup() {
		user = new UserDetails(4544523456799999L, "current", "Raman", 70000d);

		long loanAccountNumber1 = service.generateLoanAccountNumber();
		long loanAccountNumber2 = service.generateLoanAccountNumber();

		Date date1 = new Date(12, 05, 1997);
		Date date2 = new Date(13, 05, 1997);

		EducationLoan e1 = new EducationLoan(16900d, date1, 2, 9000d, 160000d, "BA", "Ajax", 399991310l, user);
		EducationLoan e2 = new EducationLoan(16000d, date2, 2, 9000d, 160000d, "BA", "Ajax", 399991310l, user);

		String eduLoanId1 = service.generateLoanId(e1.getIdCardNumber());
		String eduLoanId2 = service.generateLoanId(e2.getIdCardNumber());
		e1.setEduLoanAccountNumber(loanAccountNumber1);
		e2.setEduLoanAccountNumber(loanAccountNumber2);
		e1.setEducationLoanID(eduLoanId1);
		e2.setEducationLoanID(eduLoanId2);
		eduLoan = new ArrayList<EducationLoan>();
		eduLoan.add(e1);
		eduLoan.add(e2);

	}

	@Test
	public void testinsertEducationLoanDetails() {
		try {
			user.setEduLoan(eduLoan);
			service.insertEducationLoanDetails(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not supplied valid name");
		}
	}

	// @Test
	public void testupdateEducationLoanDetails() {
		long i = 1234567994124577L;
		Date date1 = new Date(12, 05, 1997);
		EducationLoan e = new EducationLoan(79000d, date1, 2, 9000d, 160000d, "BSC", "Ramesh", 348771310l, user);
		String eduLoanId = service.generateLoanId(e.getIdCardNumber());
		long loanAccountNumber = service.generateLoanAccountNumber();
		e.setEduLoanAccountNumber(loanAccountNumber);
		e.setEducationLoanID(eduLoanId);

		service.updateEducationLoanDetails(e, i);

	}
}
