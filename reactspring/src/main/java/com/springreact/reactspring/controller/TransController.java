package com.springreact.reactspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.reactspring.Service.TransactionService;
import com.springreact.reactspring.models.Transactions;
import com.springreact.reactspring.request.TransactionRequest;
import com.springreact.reactspring.response.TransResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class TransController {

	@Autowired
	private TransactionService transactionservice;
	
	@PostMapping("/GetTrans")
	public List<Transactions> retrieveTrans(@RequestBody TransactionRequest request) {
		System.out.println("getting list of transfer id:" +request.getId());
		return transactionservice.filterTransactions(request.getId());
		
	}
	
}

