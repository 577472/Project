package com.cognizant.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cognizant.entity.UserDetails;

@Entity
//@Table(name="Home_Loan_Details")
public class HomeLoan {

	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	String homeLoanId;
	
	// @Column(name="LOAN_AMOUNT")
	long loanAmount;
	
	// @Column(name="LOAN_DURATION")
	 int loanDuration;
	 
	 //long accountNumber;
	
	 String loanApplyDate;
	 long annualIncome;
	 String companyName;
	 String designation;
	 int totalExperience;
	 int currentExperience;
		
	 @Id
	 long loanAccountNumber;
//	 public long getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(long accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	public long getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}


	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinColumn(name = "ACCOUNT_NUMBER")
		private UserDetails userDtails;
	 
	 public UserDetails getUserDtails() {
		return userDtails;
	}
	public void setUserDtails(UserDetails userDtails) {
		this.userDtails = userDtails;
	}



	 
	public String getHomeLoanId() {
		return homeLoanId;
	}
	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}
	
	public String getLoanApplyDate() {
		return loanApplyDate;
	}
	public void setLoanApplyDate(String loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}
	public long getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getTotalExperience() {
		return totalExperience;
	}
	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}
	public int getCurrentExperience() {
		return currentExperience;
	}
	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}
	
	
	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", loanAmount=" + loanAmount + ", loanDuration=" + loanDuration
				+ ", loanApplyDate=" + loanApplyDate + ", annualIncome=" + annualIncome + ", companyName=" + companyName
				+ ", designation=" + designation + ", totalExperience=" + totalExperience + ", currentExperience="
				+ currentExperience + ", loanAccountNumber=" + loanAccountNumber + "]";
	}
	public HomeLoan(long loanAmount, int loanDuration, String loanApplyDate,
			long annualIncome, String companyName, String designation, int totalExperience, int currentExperience,UserDetails userDetails) {
		super();
	//this.loanAccountNumber=loanAccountNumber;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;
		
		this.currentExperience = currentExperience;
		this.userDtails=userDetails;
	}
	
	  
	public HomeLoan(){}	
}
