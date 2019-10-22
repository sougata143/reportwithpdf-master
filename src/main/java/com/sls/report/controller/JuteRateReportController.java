package com.sls.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sls.report.dto.JuteRateReportDTO;
import com.sls.report.dto.SummaryRecieptRegisterReportDTO;
import com.sls.report.services.serviceImpl.JuteRateReportServiceImpl;

@RestController
@RequestMapping("report")
public class JuteRateReportController {
	
	@Autowired
	JuteRateReportServiceImpl juterateService;
	
	@GetMapping("/juteratereportJSON")
	public List<JuteRateReportDTO> getAllJyteRate(){
		return juterateService.getJuteRateReportJSON();
	}
	
	@GetMapping("/juteratereport")
	public ResponseEntity<InputStreamResource> getJuteRateReport(){
		return juterateService.getJuteRateReport();
	}

}
