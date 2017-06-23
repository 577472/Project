package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.UserDetailsDAO;

import com.cognizant.entity.UserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestUserDetails {

	@Autowired
	UserDetailsDAO dao;

	//@Before
	public void setup() {
		UserDetails user = new UserDetails(5446464484894949L, "savings", "Akshay", 24000d);
		dao = new UserDetailsDAO();
	}

	 @Test
	public void addUser() {
		UserDetails user = new UserDetails(1234567890123456L,  "savings","sumit", 85000d);
		dao.addUser(user);
		assertTrue(true);

	}

}
