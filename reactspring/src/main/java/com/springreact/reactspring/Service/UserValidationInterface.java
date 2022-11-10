package com.springreact.reactspring.Service;

import com.springreact.reactspring.models.User;

public interface UserValidationInterface {

	public int validateUser(String id);
	public int validateBeneficiary(String beneficiary, String  beneficiary_ACCT, String beneficiary_ACCT_TYPE);
	public String transact(String id, String beneficiary_ACCT, String amount);
	public User getUser(String id);
	public String getUsername(String id);
	public String getUserAccountType(String id);
}
