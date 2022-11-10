package com.springreact.reactspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.Service.BalanceService;
import com.springreact.reactspring.request.BalanceRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class BalanceController {

	@Autowired
	private UserRep userRep;
	
	@Autowired
	private BalanceService service;
	
	@PostMapping(value = "/balance")
	public String totalBalance(@RequestBody BalanceRequest request) {
		
		return service.totalBalance(request.getId());
		
	}
	
}
