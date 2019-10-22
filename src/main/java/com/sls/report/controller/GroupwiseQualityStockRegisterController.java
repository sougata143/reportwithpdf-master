package com.sls.report.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sls.report.dto.GroupwiseQualityStockRegisterGeneratedPdfReportDTO;
import com.sls.report.services.serviceImpl.GroupwiseQualityStockRegisterReportServiceImpl;
import com.sls.report.services.serviceImpl.ReceiptRegisterServiceImpl;


/*
 * Controller class for PhysicalStock
 */

@RestController
@RequestMapping("report")
public class GroupwiseQualityStockRegisterController {
	
	@Autowired
	GroupwiseQualityStockRegisterReportServiceImpl physicalstockService;
	
	@GetMapping("/GroupwiseQualityStockRegister/{date}")
	public ResponseEntity<InputStreamResource> getPhysicalStock(@PathVariable("date") Date date){
		
		return physicalstockService.getGroupwiseQualityStockRegisterGeneratedPdfReport(date);
		
	}
	
	@GetMapping("/GroupwiseQualityStockRegisterJSON/{date}")
	public List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> getPhysicalStockJSON(@PathVariable("date") Date date){
		
		return physicalstockService.getGroupwiseQualityStockRegisterGeneratedPdfReportJSON(date);
		
	}
	
}
