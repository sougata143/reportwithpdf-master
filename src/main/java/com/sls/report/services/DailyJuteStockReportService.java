package com.sls.report.services;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.sls.report.dto.DailyJuteStockReportDTO;

public interface DailyJuteStockReportService {
	
	public ResponseEntity<InputStreamResource> getDailyJuteStockReport();
	
	public List<DailyJuteStockReportDTO> getDailyJuteStockReportJSON();

}
