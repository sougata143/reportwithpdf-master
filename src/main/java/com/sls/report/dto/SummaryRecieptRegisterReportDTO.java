package com.sls.report.dto;

import java.sql.Date;

public class SummaryRecieptRegisterReportDTO {

	private String actualQuality;
	private String warehouseNo;
	private long bales;
	private String quantityUnit;
	private long actualWeight;
	private String challanNo;
	private Date challanDate;
	public String getActualQuality() {
		return actualQuality;
	}
	public void setActualQuality(String actualQuality) {
		this.actualQuality = actualQuality;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public long getBales() {
		return bales;
	}
	public void setBales(long bales) {
		this.bales = bales;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public long getActualWeight() {
		return actualWeight;
	}
	public void setActualWeight(long actualWeight) {
		this.actualWeight = actualWeight;
	}
	public String getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}
	public Date getChallanDate() {
		return challanDate;
	}
	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}
	@Override
	public String toString() {
		return "SummaryRecieptRegisterReportDTO [actualQuality=" + actualQuality + ", warehouseNo=" + warehouseNo
				+ ", bales=" + bales + ", quantityUnit=" + quantityUnit + ", actualWeight=" + actualWeight
				+ ", challanNo=" + challanNo + ", challanDate=" + challanDate + "]";
	}
	public SummaryRecieptRegisterReportDTO(String actualQuality, String warehouseNo, long bales, String quantityUnit,
			long actualWeight, String challanNo, Date challanDate) {
		super();
		this.actualQuality = actualQuality;
		this.warehouseNo = warehouseNo;
		this.bales = bales;
		this.quantityUnit = quantityUnit;
		this.actualWeight = actualWeight;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
	}
	public SummaryRecieptRegisterReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
