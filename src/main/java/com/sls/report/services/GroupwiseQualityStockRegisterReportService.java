package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.sls.report.dto.GroupwiseQualityStockRegisterGeneratedPdfReportDTO;

/*
 * PhysicalStock service interface
 */
public interface GroupwiseQualityStockRegisterReportService {
	
	public ResponseEntity<InputStreamResource> getGroupwiseQualityStockRegisterGeneratedPdfReport(Date date);
	
	public List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> getGroupwiseQualityStockRegisterGeneratedPdfReportJSON(Date date);
	

}
