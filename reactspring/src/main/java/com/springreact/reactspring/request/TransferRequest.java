package com.springreact.reactspring.request;




public class TransferRequest {
	
	private String myacctid;
	
	private String beneficiary;
	private String beneficiary_ACCT;
	private String beneficiary_IFSC;
	private String beneficiary_ACCT_TYPE;
	private String amount;
	private String remarks;
	
	

	public String getMyacctid() {
		return myacctid;
	}


	public void setMyacctid(String myacctid) {
		this.myacctid = myacctid;
	}

	public String getBeneficiary() {
		return beneficiary;
	}


	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}


	public String getBeneficiary_ACCT() {
		return beneficiary_ACCT;
	}


	public void setBeneficiary_ACCT(String beneficiary_ACCT) {
		this.beneficiary_ACCT = beneficiary_ACCT;
	}


	public String getBeneficiary_IFSC() {
		return beneficiary_IFSC;
	}


	public void setBeneficiary_IFSC(String beneficiary_IFSC) {
		this.beneficiary_IFSC = beneficiary_IFSC;
	}


	public String getBeneficiary_ACCT_TYPE() {
		return beneficiary_ACCT_TYPE;
	}


	public void setBeneficiary_ACCT_TYPE(String beneficiary_ACCT_TYPE) {
		this.beneficiary_ACCT_TYPE = beneficiary_ACCT_TYPE;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TransferRequest [account_ID=" + myacctid + ", beneficiary=" + beneficiary + ", beneficiary_ACCT="
				+ beneficiary_ACCT + ", beneficiary_IFSC=" + beneficiary_IFSC + ", beneficiary_ACCT_TYPE="
				+ beneficiary_ACCT_TYPE + ", amount=" + amount + ", remarks=" + remarks + "]";
	}
	
	
	

}
