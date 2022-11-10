package com.springreact.reactspring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springreact.reactspring.Respository.TransactionsRepo;
import com.springreact.reactspring.Respository.TransferRepo;
import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.mappers.TransRowMapper;
import com.springreact.reactspring.models.Transactions;
import com.springreact.reactspring.response.TransResponse;

@Service
public class TransactionService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TransactionsRepo transactionRepo;
	
	@Autowired
	UserRep userRep;
	
	public List<Transactions> filterTransactions(String id) {
		
		String sql = String.format("SELECT transaction_id,  transaction_date,  beneficiary,  beneficiary_acct,  account_type,  transaction_type,  amount FROM transactions WHERE  fk_uid=%s ORDER BY transaction_id DESC", id);
		
		return jdbcTemplate.query(sql, new TransRowMapper());
		
	}
	
}
