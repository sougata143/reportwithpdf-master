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

import com.sls.report.dto.IssueRegisterDTO;
import com.sls.report.services.serviceImpl.IssueRegisterServiceImpl;

@RestController
@RequestMapping("report")
public class IssueRegisterReportController {
	
	@Autowired
	IssueRegisterServiceImpl issueregisterService;
	
	@GetMapping("/issueregisterreport/{date}")
	public ResponseEntity<InputStreamResource> getIssueRegisterReport(@PathVariable("date") Date date){
		return issueregisterService.createReport(date);
	}
	
	@GetMapping("/issueregisterreportJSON/{date}")
	public List<IssueRegisterDTO> getIssueRegisterReportJSON(@PathVariable("date") Date date){
		return issueregisterService.createReportJSON(date);
	}

}
