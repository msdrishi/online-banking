package com.springreact.reactspring.controller;

import java.time.LocalDate;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.reactspring.request.TransferRequest;
import com.springreact.reactspring.Respository.TransferRepo;
import com.springreact.reactspring.Respository.UserRep;
import com.springreact.reactspring.Service.TransferService;
import com.springreact.reactspring.Service.UserServiceImpl;
import com.springreact.reactspring.Service.UserValidation;
import com.springreact.reactspring.models.Transactions;
import com.springreact.reactspring.models.User;
import com.springreact.reactspring.models.Transfer;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class FundTransfer {

	
	@Autowired
	private UserValidation validation;
	
	@Autowired
    UserRep userRep;
	
	@Autowired
	TransferService transferService;
	
	@PostMapping(value="/fundTransfer")
	public int transferFunds(@RequestBody TransferRequest request) {
		

		System.out.println(request.getBeneficiary());
		System.out.println(request.getMyacctid());
		System.out.println(request.getBeneficiary_ACCT());
		System.out.println(request.getBeneficiary_ACCT_TYPE());
		int valid_id = validation.validateUser(request.getMyacctid());
		System.out.println(valid_id);
		int valid_beneficiary = validation.validateBeneficiary(request.getBeneficiary(), request.getBeneficiary_ACCT(), request.getBeneficiary_ACCT_TYPE());
		System.out.println(valid_beneficiary);


		if (valid_id == 1 && valid_beneficiary == 1){
			String status = validation.transact(request.getMyacctid(), request.getBeneficiary_ACCT(), request.getAmount());
			
			if (status == "Low Balance") {
				System.out.println("lowbalance");
				return 1;
			}
			else {
				
				Transfer insert_transfer_info = new Transfer(request.getMyacctid(), request.getBeneficiary_ACCT(), request.getBeneficiary_ACCT_TYPE(), request.getAmount());
				
				transferService.saveTransferData(insert_transfer_info);
				
				
				
				// set of below lines of code is for user's transaction
				Transactions insert_trans_user = new Transactions(LocalDate.now().toString(), request.getBeneficiary(), request.getBeneficiary_ACCT(), request.getBeneficiary_ACCT_TYPE(), "Debit", request.getAmount());
				
				
				User user_instance = validation.getUser(request.getMyacctid());
				user_instance.getTrans().add(insert_trans_user);
				
				userRep.save(user_instance);
				
				// set of below lines of code is for beneficiary's transaction
				// we swap them with the use of their id's
				
				String user_name = validation.getUsername(request.getMyacctid());
				String user_account_type_id = validation.getUserAccountType(request.getMyacctid());
				
				Transactions insert_trans_beneficiary = new Transactions(LocalDate.now().toString(), user_name, request.getMyacctid(), user_account_type_id, "Credit", request.getAmount());
				
				User beneficiary_instance = validation.getUser(request.getBeneficiary_ACCT());
				beneficiary_instance.getTrans().add(insert_trans_beneficiary);
				
				userRep.save(beneficiary_instance);
				
				System.out.println("Done");
				//return "Transaction complete";
				return 2;
				
			}
		}
		else if (valid_id != 1 && valid_beneficiary != 1){
			
			//return "Account Number and Beneficiary details are invalid";
			return 3;
		}
		else if (valid_id != 1) {
			
			//return "Invalid account number";
			return 4;
		}
		else {
			
			//return "Invalid beneficiary details";
		    return 5;
		}
	}


}
