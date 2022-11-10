package com.springreact.reactspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Transfer {

	@TableGenerator(name = "Address_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Addr_Gen", initialValue = 10000, allocationSize = 10000)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transferId;
	private String SrcAccNum;
	private String DestAccNum;
	private String DestAccTypeID;
	private String TransferAmount;
	
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transfer(String srcAccNum, String destAccNum, String destAccTypeID,
			String transferAmount) {
		super();
		SrcAccNum = srcAccNum;
		DestAccNum = destAccNum;
		DestAccTypeID = destAccTypeID;
		TransferAmount = transferAmount;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getSrcAccNum() {
		return SrcAccNum;
	}

	public void setSrcAccNum(String srcAccNum) {
		SrcAccNum = srcAccNum;
	}

	public String getDestAccNum() {
		return DestAccNum;
	}

	public void setDestAccNum(String destAccNum) {
		DestAccNum = destAccNum;
	}

	public String getDestAccTypeID() {
		return DestAccTypeID;
	}

	public void setDestAccTypeID(String destAccTypeID) {
		DestAccTypeID = destAccTypeID;
	}

	public String getTransferAmount() {
		return TransferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		TransferAmount = transferAmount;
	}
	
	
	
	
}
