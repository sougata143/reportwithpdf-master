package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.sls.report.dto.SummaryRecieptRegisterReportDTO;

public interface SummeryRecieptRegisterReportService {
	
	ResponseEntity<InputStreamResource> getSummaryRecieptRegisterReport(Date date);
	
	List<SummaryRecieptRegisterReportDTO> getSummaryRecieptRegisterReportJSON(Date date);

}
