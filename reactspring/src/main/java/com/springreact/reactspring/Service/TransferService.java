package com.springreact.reactspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.reactspring.Respository.TransferRepo;
import com.springreact.reactspring.models.Transfer;

@Service
public class TransferService {

	@Autowired
	TransferRepo transfer;

	
	public Transfer saveTransferData(Transfer input) {
		
		return transfer.save(input);
		
	}
	
}
