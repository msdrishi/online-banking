package com.springreact.reactspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.models.User;

@Service
public class UserValidation implements UserValidationInterface{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    UserRep userRep;
	
	public int validateUser(String id) {
		//System.out.println(id);
		System.out.println(jdbcTemplate.queryForObject("SELECT 1 FROM user where id=?", Integer.class,  id));
		return jdbcTemplate.queryForObject("SELECT 1 FROM user where id=?", Integer.class,  id);
		
	}
	
	public int validateBeneficiary(String beneficiary, String  beneficiary_ACCT, String beneficiary_ACCT_TYPE) {
		System.out.println(beneficiary + "  " + beneficiary_ACCT + "   " + beneficiary_ACCT_TYPE);
System.out.println(jdbcTemplate.queryForObject("SELECT 1 FROM user WHERE username=? AND id=? AND account_typeid=?", Integer.class,beneficiary, beneficiary_ACCT, beneficiary_ACCT_TYPE));
		return jdbcTemplate.queryForObject("SELECT 1 FROM user WHERE username=? AND id=? AND account_typeid=?", Integer.class,beneficiary, beneficiary_ACCT, beneficiary_ACCT_TYPE );
		
	}
	
	public String transact(String id, String beneficiary_ACCT, String amount) {
		
		int user_balance = jdbcTemplate.queryForObject("SELECT balance FROM user WHERE id=?", Integer.class, id);
		int beneficiary_balance = jdbcTemplate.queryForObject("SELECT balance FROM user WHERE id=?", Integer.class, beneficiary_ACCT);
		
		//System.out.println(user_balance + "         " + beneficiary_balance);
		if (user_balance < Integer.parseInt(amount)) {
			return "Low Balance";
		}
		else {
			jdbcTemplate.update("UPDATE user SET balance = ? WHERE id=?" , user_balance - Integer.parseInt(amount), id);
			jdbcTemplate.update("UPDATE user SET balance = ? WHERE id=?" , beneficiary_balance + Integer.parseInt(amount), beneficiary_ACCT);
			
			return "Transaction Complete";
		}
		
	}
	
	public User getUser(String id) {
		
		return userRep.findById(Integer.parseInt(id)).orElse(null);
		
	}
	
	public String getUsername(String id) {
		
		return jdbcTemplate.queryForObject("SELECT username FROM user where id=?", String.class,  id);
		
	}
	
	public String getUserAccountType(String id) {

		return jdbcTemplate.queryForObject("SELECT account_typeid FROM user where id=?", String.class,  id);

	}

	
	
}
