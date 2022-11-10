package com.springreact.reactspring.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springreact.reactspring.models.Transactions;


public class TransRowMapper implements RowMapper<Transactions>{

	@Override
	public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Transactions trans = new Transactions();
		trans.setTransactionId(rs.getInt("transaction_id"));
		trans.setTransactionDate(rs.getString("transaction_date"));
		trans.setBeneficiary(rs.getString("beneficiary"));
		trans.setBeneficiary_acct(rs.getString("beneficiary_acct"));
		trans.setAccountType(rs.getString("account_type"));
		trans.setTransactionType(rs.getString("transaction_type"));
		trans.setAmount(rs.getString("amount"));
		
		return trans;
		
	}
	
}
