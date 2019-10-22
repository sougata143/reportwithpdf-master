package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.sls.report.dto.ReceiptRegisterDTO;

public interface ReceiptRegisterService {
	
	ResponseEntity<InputStreamResource> getAllReceiptRegister(Date date);
	List<ReceiptRegisterDTO> getAllReceiptRegisterJSON(Date date);

}
