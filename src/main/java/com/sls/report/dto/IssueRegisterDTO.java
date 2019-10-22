package com.sls.report.dto;

import java.util.Date;

public class IssueRegisterDTO {
	
	private long issueNo;
	private Date issueDate;
	private String quality;
	private long issueQnty;
	private String warehouseNo;
	private String bales;
	private String loose;
	private String weight;
	
	
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public String getBales() {
		return bales;
	}
	public void setBales(String bales) {
		this.bales = bales;
	}
	public String getLoose() {
		return loose;
	}
	public void setLoose(String loose) {
		this.loose = loose;
	}
	public long getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(long issueNo) {
		this.issueNo = issueNo;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public long getIssueQnty() {
		return issueQnty;
	}
	public void setIssueQnty(long issueQnty) {
		this.issueQnty = issueQnty;
	}
	@Override
	public String toString() {
		return "IssueRegisterDTO [issueNo=" + issueNo + ", issueDate=" + issueDate + ", quality=" + quality
				+ ", issueQnty=" + issueQnty + "]";
	}
	public IssueRegisterDTO(long issueNo, Date issueDate, String quality, long issueQnty) {
		super();
		this.issueNo = issueNo;
		this.issueDate = issueDate;
		this.quality = quality;
		this.issueQnty = issueQnty;
	}
	public IssueRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
