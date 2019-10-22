package com.sls.report.dto;

import java.util.Date;

import javax.persistence.Column;

public class GroupwiseQualityStockRegisterGeneratedPdfReportDTO {
	
	private String qualityCode;
	private String oppenningWt;
	private String receiptWt;
	private String issueWt;
	private String closingWt;
	public String getQualityCode() {
		return qualityCode;
	}
	public void setQualityCode(String qualityCode) {
		this.qualityCode = qualityCode;
	}
	public String getOppenningWt() {
		return oppenningWt;
	}
	public void setOppenningWt(String oppenningWt) {
		this.oppenningWt = oppenningWt;
	}
	public String getReceiptWt() {
		return receiptWt;
	}
	public void setReceiptWt(String receiptWt) {
		this.receiptWt = receiptWt;
	}
	public String getIssueWt() {
		return issueWt;
	}
	public void setIssueWt(String issueWt) {
		this.issueWt = issueWt;
	}
	public String getClosingWt() {
		return closingWt;
	}
	public void setClosingWt(String closingWt) {
		this.closingWt = closingWt;
	}
	@Override
	public String toString() {
		return "GroupwiseQualityStockRegisterGeneratedPdfReportDTO [qualityCode=" + qualityCode + ", oppenningWt="
				+ oppenningWt + ", receiptWt=" + receiptWt + ", issueWt=" + issueWt + ", closingWt=" + closingWt + "]";
	}
	public GroupwiseQualityStockRegisterGeneratedPdfReportDTO(String qualityCode, String oppenningWt, String receiptWt,
			String issueWt, String closingWt) {
		super();
		this.qualityCode = qualityCode;
		this.oppenningWt = oppenningWt;
		this.receiptWt = receiptWt;
		this.issueWt = issueWt;
		this.closingWt = closingWt;
	}
	public GroupwiseQualityStockRegisterGeneratedPdfReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
