package com.sls.report.services.serviceImpl;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sls.report.component.ScmMrHdrComponent;
import com.sls.report.component.ScmMrLineItemComponent;
import com.sls.report.dto.SummaryRecieptRegisterReportDTO;
import com.sls.report.entity.ScmMrHdr;
import com.sls.report.entity.ScmMrLineItem;
import com.sls.report.services.SummeryRecieptRegisterReportService;
import com.sls.report.services.GeneratedPdfService.SummaryRecieptRegisterReportGeneratedPDF;

@Service
public class SummaryRecieptRegisterReposrtServiceImpl implements SummeryRecieptRegisterReportService{
	
	@Autowired
	ScmMrLineItemComponent issuelineitemDao;
	
	@Autowired
	ScmMrHdrComponent issuehdrDao;

	@Override
	public ResponseEntity<InputStreamResource> getSummaryRecieptRegisterReport(Date date) {
		List<SummaryRecieptRegisterReportDTO> sumaryreport = new ArrayList<>();
		
		try {
			List<ScmMrLineItem> issuehdrs = issuelineitemDao.getAllScmMrLineItem();
			issuehdrs.forEach(issuehdt->{
				ScmMrHdr mrhdr = issuehdrDao.getMrHdrById(issuehdt.getJuteReceiveNo());
				System.out.println(mrhdr.getGoodReceiptDate());
				if(date.equals(mrhdr.getChalanDate())) {
					sumaryreport.add(prepareIssueRegiDTO(issuehdt));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream bis = null;
		bis = SummaryRecieptRegisterReportGeneratedPDF.createReport(sumaryreport);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "inline; filename=storereport.pdf");
		
		
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	private SummaryRecieptRegisterReportDTO prepareIssueRegiDTO(ScmMrLineItem issuehdt) {
		SummaryRecieptRegisterReportDTO issueregister = new SummaryRecieptRegisterReportDTO();
		ScmMrHdr mrhdr = issuehdrDao.getMrHdrById(issuehdt.getJuteReceiveNo());
		
		issueregister.setActualQuality(issuehdt.getActualQuality());
		issueregister.setActualWeight(issuehdt.getActualWeight());
		issueregister.setBales(issuehdt.getTotalPrice());
		issueregister.setChallanDate(mrhdr.getChalanDate());
		issueregister.setChallanNo(mrhdr.getChalanNo());
		issueregister.setQuantityUnit(issuehdt.getQuantityUnit());
		issueregister.setWarehouseNo(issuehdt.getWarehouseNo());
		
		
		return issueregister;
	}

	@Override
	public List<SummaryRecieptRegisterReportDTO> getSummaryRecieptRegisterReportJSON(Date date) {
		List<SummaryRecieptRegisterReportDTO> sumaryreport = new ArrayList<>();
		
		try {
			List<ScmMrLineItem> issuehdrs = issuelineitemDao.getAllScmMrLineItem();
			issuehdrs.forEach(issuehdt->{
				ScmMrHdr mrhdr = issuehdrDao.getMrHdrById(issuehdt.getJuteReceiveNo());
				System.out.println(mrhdr.getGoodReceiptDate());
				if(date.equals(mrhdr.getChalanDate())) {
					sumaryreport.add(prepareIssueRegiDTO(issuehdt));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sumaryreport;
	}

}
