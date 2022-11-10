package com.springreact.reactspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springreact.reactspring.Respository.UserRep;

@Service
public class BalanceService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserRep userRep;
	
	public String totalBalance(String id) {
		
		String sql = "SELECT balance FROM user WHERE id=?";
		
		return jdbcTemplate.queryForObject(sql, String.class, id);
		
	}
	
}
