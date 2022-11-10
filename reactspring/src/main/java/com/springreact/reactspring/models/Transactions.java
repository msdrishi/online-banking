package com.springreact.reactspring.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Transactions {

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	@TableGenerator(name = "Address_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen", initialValue = 10000, allocationSize = 10000)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
	private String transactionDate;
	private String beneficiary;
	private String beneficiary_acct;
	private String accountType; // savings, current etc...
	private String transactionType; //debit or credit
	private String amount;
	


	public Transactions( String transactionDate, String beneficiary, String beneficiary_acct ,String accountType,
			String transactionType, String amount) {
		super();
//		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.beneficiary = beneficiary;
		this.beneficiary_acct = beneficiary_acct;
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	
	
	public String getBeneficiary_acct() {
		return beneficiary_acct;
	}


	public Transactions(int transactionId, String transactionDate, String beneficiary, String beneficiary_acct,
			String accountType, String transactionType, String amount) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.beneficiary = beneficiary;
		this.beneficiary_acct = beneficiary_acct;
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.amount = amount;
	}


	public void setBeneficiary_acct(String beneficiary_acct) {
		this.beneficiary_acct = beneficiary_acct;
	}


	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
