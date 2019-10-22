package com.sls.report.services;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.sls.report.dto.JuteRateReportDTO;

public interface JuteRateReportService {
	
	public ResponseEntity<InputStreamResource> getJuteRateReport();
	
	public List<JuteRateReportDTO> getJuteRateReportJSON();

}
