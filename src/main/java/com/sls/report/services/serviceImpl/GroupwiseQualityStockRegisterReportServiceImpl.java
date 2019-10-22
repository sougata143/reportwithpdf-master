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

import com.sls.report.component.JuteQualityPriceMasterComponent;
import com.sls.report.component.PhysicalStockComponent;
import com.sls.report.component.ScmIssueLineItemComponent;
import com.sls.report.dto.GroupwiseQualityStockRegisterGeneratedPdfReportDTO;
import com.sls.report.entity.JuteQualityPriceMaster;
import com.sls.report.entity.PhysicalStock;
import com.sls.report.entity.ScmIssueLineItem;
import com.sls.report.services.GroupwiseQualityStockRegisterReportService;
import com.sls.report.services.GeneratedPdfService.GroupwiseQualityStockRegisterGeneratedPdfReport;


/*
 * service class for PhysicalStock
 */

@Service
public class GroupwiseQualityStockRegisterReportServiceImpl implements GroupwiseQualityStockRegisterReportService {

	@Autowired
	PhysicalStockComponent physicalstockDao;
	
	@Autowired
	JuteQualityPriceMasterComponent pricemasterDao;
	
	@Autowired
	ScmIssueLineItemComponent lineitemDao;
	
	@Override
	public ResponseEntity<InputStreamResource> getGroupwiseQualityStockRegisterGeneratedPdfReport(Date date) {
		
		List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> physicalstockDTOs = new ArrayList<>();
		try {
//			List<PhysicalStock> physicalstocks =  physicalstockDao.getByModifiedDate(date);
			List<PhysicalStock> physicalstocks =  physicalstockDao.getAllPhysicalStock();
			physicalstocks.forEach(physicalstock->{
				physicalstockDTOs.add(preparePhysicalStockDTO(physicalstock));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream bis = GroupwiseQualityStockRegisterGeneratedPdfReport.groupwiseQualityStockRegister(physicalstockDTOs);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "inline; filename=storereport.pdf");
		
		System.out.println(physicalstockDTOs);
		System.out.println(date);
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	private GroupwiseQualityStockRegisterGeneratedPdfReportDTO preparePhysicalStockDTO(PhysicalStock ps) {
		GroupwiseQualityStockRegisterGeneratedPdfReportDTO physicalstockDTO = 
				new GroupwiseQualityStockRegisterGeneratedPdfReportDTO();
		System.out.println("ps "+ps);
		String qualitycode = ps.getQualityCode();
		System.out.println("quality code "+qualitycode);
		System.out.println("long "+Long.valueOf(qualitycode));
		JuteQualityPriceMaster qualityprice = 
				pricemasterDao.getJuteQualityPriceMasterById(Long.valueOf(qualitycode));
		
		List<ScmIssueLineItem> issuelineitem = lineitemDao.getLineItemsByItem(ps.getItemId());
		if(!issuelineitem.isEmpty()) {
			long issue = 0;
			for(int i = 0 ; i < issuelineitem.size() ; i++) {
				System.out.println("issue qnt "+issuelineitem.get(i).getIssueQty());
				String[] tranid = issuelineitem.get(i).getAdditionalRequirement().split("\\^");
				System.out.println("tran "+tranid[0]+ " ps id "+ps.getId());
				if(tranid[0].equals(String.valueOf(ps.getId()))) {
					issue = issuelineitem.get(i).getIssueQty();
				}
				physicalstockDTO.setIssueWt(String.valueOf(issue));
			}
			
		}
		
		physicalstockDTO.setClosingWt(String.valueOf(ps.getStockInHand()));
		
		physicalstockDTO.setOppenningWt(String.valueOf(ps.getTotalStock()));
		physicalstockDTO.setQualityCode(qualityprice.getJuteQuality());
		physicalstockDTO.setReceiptWt(String.valueOf(ps.getNewStock()));
		
		return physicalstockDTO;
	}

	@Override
	public List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> getGroupwiseQualityStockRegisterGeneratedPdfReportJSON(
			Date date) {
		 List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> physicalstockDTOs = new ArrayList<>();
		try {
//			List<PhysicalStock> physicalstocks =  physicalstockDao.getByModifiedDate(date);
			List<PhysicalStock> physicalstocks =  physicalstockDao.getAllPhysicalStock();
			physicalstocks.forEach(physicalstock->{
				physicalstockDTOs.add(preparePhysicalStockDTO(physicalstock));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return physicalstockDTOs;
	}

}
