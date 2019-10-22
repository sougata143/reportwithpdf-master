package com.sls.report.services.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sls.report.component.JuteGateEntryDtlComponent;
import com.sls.report.component.JuteGateEntryHdrComponent;
import com.sls.report.component.ScmMrLineItemComponent;
import com.sls.report.dto.ReceiptRegisterDTO;
import com.sls.report.entity.JuteEntryHeader;
import com.sls.report.entity.JuteGateEntryDtl;
import com.sls.report.entity.ScmMrLineItem;
import com.sls.report.services.ReceiptRegisterService;
import com.sls.report.services.GeneratedPdfService.ReceiptRegisterGeneratedPDFReport;

@Service
public class ReceiptRegisterServiceImpl implements ReceiptRegisterService{
	
	@Autowired
	JuteGateEntryDtlComponent juteentrydtlDao;
	
	@Autowired
	JuteGateEntryHdrComponent juteentryhdrDao;
	
	@Autowired
	ScmMrLineItemComponent mrlineitemDao;

	@Override
	public ResponseEntity<InputStreamResource> getAllReceiptRegister(Date date) {
		List<ReceiptRegisterDTO> reportDtoList = new ArrayList<>();
		
		try {
			List<JuteGateEntryDtl> entrydtl = juteentrydtlDao.getAllJuteGateEntryDtl();
			entrydtl.forEach(entry->{
				reportDtoList.add(prepareReportDTO(entry, date));
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		ByteArrayInputStream bis = null;
		try {
			bis = ReceiptRegisterGeneratedPDFReport.receiptRegister(reportDtoList);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "inline; filename=storereport.pdf");
		
		
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	private ReceiptRegisterDTO prepareReportDTO(JuteGateEntryDtl entry, Date date) {
		ReceiptRegisterDTO registerdto = new ReceiptRegisterDTO();
		JuteEntryHeader jutehdr = juteentryhdrDao.getJuteEntryHeaderById(entry.getHdrId());
		Date challanDate = jutehdr.getChalanDate();
		System.out.println(date + "  "+challanDate+"  "+(date == challanDate));
		List<ScmMrLineItem> lineitem = mrlineitemDao.getScmMrLineItemById(jutehdr.getMrNo());
		List<String> claims = new ArrayList<>();
		
		if(date.equals(challanDate)) {
			lineitem.forEach(claimm->{
				claims.add(claimm.getClaimsCondition());
			});
			
			registerdto.setActualQuality(entry.getActualQuality());
			registerdto.setActualQuantity(entry.getActualQuantity());
			registerdto.setUom(entry.getUom());
			if(jutehdr!=null) {
				registerdto.setChallanDate(jutehdr.getChalanDate());
				registerdto.setBrokerAddress(jutehdr.getBrokerAddress());
				registerdto.setVehicleNo(jutehdr.getVehicleNo());
			}else {
				registerdto.setBrokerAddress("Not Found");
			}
			
			registerdto.setClaimsCondition(claims);
		}
		
		return registerdto;
	}

	@Override
	public List<ReceiptRegisterDTO> getAllReceiptRegisterJSON(Date date) {
		List<ReceiptRegisterDTO> reportDtoList = new ArrayList<>();
		
		try {
			List<JuteGateEntryDtl> entrydtl = juteentrydtlDao.getAllJuteGateEntryDtl();
			entrydtl.forEach(entry->{
				reportDtoList.add(prepareReportDTO(entry, date));
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reportDtoList;
	}
	
	

}
