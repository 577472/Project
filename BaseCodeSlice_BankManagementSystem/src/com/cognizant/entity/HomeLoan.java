package com.cognizant.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.cognizant.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "HOME_LOAN_DETAILS ")
public class HomeLoan {

	// @GeneratedValue(strategy=GenerationType.AUTO)

	private String homeLoanId;

	// @Column(name="LOAN_AMOUNT")
	@NotNull(message = "Mandatory field")
	@Min(1)
	//@Size(max=11)
	private Long loanAmount;
	// @Column(name="LOAN_DURATION")
	@NotNull(message = "Mandatory field")
	private Integer loanDuration;
	// long accountNumber;
	//@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date loanApplyDate;
	@NotNull(message = "Mandatory field")
	private Long annualIncome;
	
	//@NotNull(message = "Mandatory field")
	@NotEmpty
	private String companyName;
	//@NotNull(message = "Mandatory field")
@NotEmpty
	private String designation;
	@NotNull(message = "Mandatory field")

	private Integer totalExperience;
	@NotNull(message = "Mandatory field")

	private Integer currentExperience;

	@Id
	private Long loanAccountNumber;

	public Long getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(Long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
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

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Integer getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(Integer currentExperience) {
		this.currentExperience = currentExperience;
	}

	/*
	 * @Override public String toString() { return "HomeLoan [homeLoanId=" +
	 * homeLoanId + ", loanAmount=" + loanAmount + ", loanDuration=" +
	 * loanDuration + ", loanApplyDate=" + loanApplyDate + ", annualIncome=" +
	 * annualIncome + ", companyName=" + companyName + ", designation=" +
	 * designation + ", totalExperience=" + totalExperience +
	 * ", currentExperience=" + currentExperience + ", loanAccountNumber=" +
	 * loanAccountNumber + "]"; }
	 */
	public HomeLoan(Long loanAmount, Integer loanDuration, Date loanApplyDate, Long annualIncome, String companyName,
			String designation, Integer totalExperience, Integer currentExperience, UserDetails user) {
		super();
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;

		this.currentExperience = currentExperience;
		this.user = user;
	}

	public HomeLoan() {
	}
}
