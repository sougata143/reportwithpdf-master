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

import com.sls.report.dto.ReceiptRegisterDTO;
import com.sls.report.services.serviceImpl.ReceiptRegisterServiceImpl;

@RestController
@RequestMapping("report")
public class ReceiptRegisterController {
	
	@Autowired
	ReceiptRegisterServiceImpl receipetRepostService;
	
	@GetMapping("/getReceiptRegister/{date}")
	public ResponseEntity<InputStreamResource> getReceiptRegister(@PathVariable("date") Date date){
		return receipetRepostService.getAllReceiptRegister(date);
	}
	
	@GetMapping("/getReceiptRegisterJSON/{date}")
	public List<ReceiptRegisterDTO> getReceiptRegisterJSON(@PathVariable("date") Date date){
		return receipetRepostService.getAllReceiptRegisterJSON(date);
	}

}
