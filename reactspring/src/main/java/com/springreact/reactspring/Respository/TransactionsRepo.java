package com.springreact.reactspring.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springreact.reactspring.models.Transactions;
import com.springreact.reactspring.response.TransResponse;


@Repository
public interface TransactionsRepo extends JpaRepository<Transactions,Integer>{

//	@Query("SELECT new com.springreact.reactspring.response.TransResponse(CAST( transaction_id AS varchar),  transaction_date,  beneficiary,  beneficiary_acct,  account_type,  transaction_type,  amount, CAST( fk_uid AS varchar)) FROM Transaction WHERE  fk_uid=:id")
//	public List<TransResponse> getTransInfo(@Param("id") int id);
	
	// reference -  https://www.baeldung.com/spring-data-jpa-query
    
    
}
