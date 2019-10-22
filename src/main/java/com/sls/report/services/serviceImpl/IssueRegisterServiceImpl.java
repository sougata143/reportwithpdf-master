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

import com.sls.report.component.PhysicalStockComponent;
import com.sls.report.component.ScmIssueHdrComponent;
import com.sls.report.component.ScmIssueLineItemComponent;
import com.sls.report.dto.IssueRegisterDTO;
import com.sls.report.entity.PhysicalStock;
import com.sls.report.entity.ScmIssueHdr;
import com.sls.report.entity.ScmIssueLineItem;
import com.sls.report.services.IssueRegisterService;
import com.sls.report.services.GeneratedPdfService.IssueRegisterGeneratedPDFReport;


@Service
public class IssueRegisterServiceImpl implements IssueRegisterService {
	
	@Autowired
	ScmIssueHdrComponent issuehdrDao;
	
	@Autowired
	ScmIssueLineItemComponent issuelineitemDao;
	
	@Autowired
	PhysicalStockComponent physicalstockDao;

	@Override
	public ResponseEntity<InputStreamResource> createReport(Date date) {
		List<IssueRegisterDTO> recieptregiDTO = new ArrayList<>(); 
		
		try {
			List<ScmIssueHdr> issuehdrs = issuehdrDao.getScmIssuHdrByCreateDate(date);
			issuehdrs.forEach(issuehdt->{
				recieptregiDTO.add(prepareIssueRegiDTO(issuehdt));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream bis = null;
		bis = IssueRegisterGeneratedPDFReport.issueRegister(recieptregiDTO);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "inline; filename=storereport.pdf");
		
		
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	private IssueRegisterDTO prepareIssueRegiDTO(ScmIssueHdr issuehdt) {
		IssueRegisterDTO issueregister = new IssueRegisterDTO();
		ScmIssueLineItem lineitem = issuelineitemDao.getIssueLineItem(String.valueOf(issuehdt.getId()));
		String[] additionalreq = lineitem.getAdditionalRequirement().split("\\^");
		PhysicalStock physicalstock = physicalstockDao.getPhysicalStockById(Long.parseLong(additionalreq[0]));
		
		issueregister.setIssueDate(issuehdt.getIssueDate());
		issueregister.setIssueNo(issuehdt.getId());
		
		issueregister.setIssueQnty(lineitem.getIssueQty());
		issueregister.setQuality(lineitem.getQuality());
		
		issueregister.setWarehouseNo(physicalstock.getWareHouseNo());
		if(physicalstock.getConversionUnit().equalsIgnoreCase("BALE")) {
			issueregister.setBales(String.valueOf(lineitem.getIssueQty())+" BALES");
			issueregister.setWeight(String.valueOf(lineitem.getIssueQty())+" PCS");
		}else if(physicalstock.getConversionUnit().equalsIgnoreCase("LOOSE")) {
			issueregister.setLoose(String.valueOf(lineitem.getIssueQty())+" LOOSE");
			issueregister.setWeight(String.valueOf(lineitem.getIssueQty())+" QNT");
		}
		
		System.out.println(" "+lineitem+ " "+physicalstock.getId()+" "+issuehdt);
		
		return issueregister;
	}

	@Override
	public List<IssueRegisterDTO> createReportJSON(Date date) {
		List<IssueRegisterDTO> recieptregiDTO = new ArrayList<>(); 
		
		try {
			List<ScmIssueHdr> issuehdrs = issuehdrDao.getScmIssuHdrByCreateDate(date);
			issuehdrs.forEach(issuehdt->{
				recieptregiDTO.add(prepareIssueRegiDTO(issuehdt));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return recieptregiDTO;
	}

	

}
