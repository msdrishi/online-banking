package com.springreact.reactspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MetaService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getFullName(String username) {
		
		String space = " ";
		
		String sql = "SELECT CONCAT(your_name, ?, last_name) FROM user WHERE username=?";
		
		return jdbcTemplate.queryForObject(sql, String.class, space, username);
		
	}
	
	
	public String getUserId(String username) {
		
		String sql = "SELECT id FROM user WHERE username=?";
		
		return jdbcTemplate.queryForObject(sql, String.class, username);
		
	}
	
	public String getBalance(String username) {
		
		String sql = "SELECT balance FROM user WHERE username=?";
		
		return jdbcTemplate.queryForObject(sql, String.class, username);
		
	}

}