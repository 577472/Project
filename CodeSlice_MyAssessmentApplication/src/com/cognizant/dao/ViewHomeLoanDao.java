package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
@Component
public class ViewHomeLoanDao {
	 @PersistenceContext
	    private EntityManager em;

	@Transactional
	public List<HomeLoan> retrieveHomeDetails(long l) {
		UserDetails retrive=em.find(UserDetails.class,l); 
		System.out.println(retrive);
		System.out.println(retrive.getHomeLoan());
	
		return null;
	}
	

}
