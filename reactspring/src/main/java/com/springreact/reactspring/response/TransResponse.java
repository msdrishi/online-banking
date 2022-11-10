package com.springreact.reactspring.response;

public class TransResponse {

	 	private String transactionId;
		private String transactionDate;
		private String beneficiary;
		private String beneficiary_acct;
		private String accountType; // savings, current etc...
		private String transactionType; //debit or credit
		private String amount;
		private String userId;
		
		
		public TransResponse() {
			super();
			// TODO Auto-generated constructor stub
		}


		public TransResponse(String transactionId, String transactionDate, String beneficiary, String beneficiary_acct,
				String accountType, String transactionType, String amount, String userId) {
			super();
			this.transactionId = transactionId;
			this.transactionDate = transactionDate;
			this.beneficiary = beneficiary;
			this.beneficiary_acct = beneficiary_acct;
			this.accountType = accountType;
			this.transactionType = transactionType;
			this.amount = amount;
			this.userId = userId;
		}


		public String getTransactionId() {
			return transactionId;
		}


		public void setTransactionId(String transactionId) {
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


		public String getBeneficiary_acct() {
			return beneficiary_acct;
		}


		public void setBeneficiary_acct(String beneficiary_acct) {
			this.beneficiary_acct = beneficiary_acct;
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


		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		
	
}
