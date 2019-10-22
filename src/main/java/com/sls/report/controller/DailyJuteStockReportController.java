package com.sls.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sls.report.dto.DailyJuteStockReportDTO;
import com.sls.report.services.serviceImpl.DailyJuteStockReportServiceImpl;

@RestController
@RequestMapping("report")
public class DailyJuteStockReportController {
	
	@Autowired
	DailyJuteStockReportServiceImpl dailyjutestockreportService;
	
	@GetMapping("dailyjutestockreport")
	public ResponseEntity<InputStreamResource> getDailyJuteStockReport(){
		return dailyjutestockreportService.getDailyJuteStockReport();
	}
	
	@GetMapping("dailyjutestockreportJSON")
	public List<DailyJuteStockReportDTO> getDailyJuteStockReportJSON(){
		return dailyjutestockreportService.getDailyJuteStockReportJSON();
	}

}
