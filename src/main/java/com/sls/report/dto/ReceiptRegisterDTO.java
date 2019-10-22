package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class ReceiptRegisterDTO {
	
	private Date challanDate;
	private String brokerAddress;
	private String vehicleNo;
	private String uom;
	private String actualQuality;
	private long actualQuantity;
	private List<String> claimsCondition;
	public Date getChallanDate() {
		return challanDate;
	}
	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}
	public String getBrokerAddress() {
		return brokerAddress;
	}
	public void setBrokerAddress(String brokerAddress) {
		this.brokerAddress = brokerAddress;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getActualQuality() {
		return actualQuality;
	}
	public void setActualQuality(String actualQuality) {
		this.actualQuality = actualQuality;
	}
	public long getActualQuantity() {
		return actualQuantity;
	}
	public void setActualQuantity(long actualQuantity) {
		this.actualQuantity = actualQuantity;
	}
	public List<String> getClaimsCondition() {
		return claimsCondition;
	}
	public void setClaimsCondition(List<String> claimsCondition) {
		this.claimsCondition = claimsCondition;
	}
	
	
	

}
