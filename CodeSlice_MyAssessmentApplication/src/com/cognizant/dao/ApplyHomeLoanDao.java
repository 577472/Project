package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;


@Component
public class ApplyHomeLoanDao {
	@PersistenceContext
    private EntityManager em;
	@Transactional
	public void insertHomeDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		System.out.println(userDetails);
		em.persist(userDetails);
		System.out.println("after");
	
		
	}
	public UserDetails updateHOmeLoanDetails(long l) {
		UserDetails retrive=em.find(UserDetails.class,l); 
		System.out.println(retrive);
		return retrive;
		
	
		
		
	}
	
	
	
		
		
	

}
