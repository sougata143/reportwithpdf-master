package com.sls.report.services.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sls.report.component.BatchMasterComponent;
import com.sls.report.component.JuteQualityBatchMasterComponent;
import com.sls.report.component.JuteQualityPriceMasterComponent;
import com.sls.report.dto.JuteRateReportDTO;
import com.sls.report.entity.BatchMaster;
import com.sls.report.entity.JuteQualityBatchMap;
import com.sls.report.entity.JuteQualityPriceMaster;
import com.sls.report.services.JuteRateReportService;
import com.sls.report.services.GeneratedPdfService.JuteRateReportGeneratedPDF;
import com.sls.report.services.GeneratedPdfService.SummaryRecieptRegisterReportGeneratedPDF;

@Service
public class JuteRateReportServiceImpl implements JuteRateReportService {

	@Autowired
	JuteQualityPriceMasterComponent priceDao;
	
	@Autowired
	JuteQualityBatchMasterComponent batchmapDao;
	
	@Autowired
	BatchMasterComponent batchDao;
	
	@Override
	public ResponseEntity<InputStreamResource> getJuteRateReport() {
		List<JuteRateReportDTO> juterate = new ArrayList<>();
		try {
			List<JuteQualityPriceMaster> prices = priceDao.getAllJuteQualityPriceMaster();
			prices.forEach(price->{
				juterate.add(prepareJuteRateDTO(price));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream bis = null;
		bis = JuteRateReportGeneratedPDF.createReport(juterate);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "inline; filename=storereport.pdf");
		
		
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@Override
	public List<JuteRateReportDTO> getJuteRateReportJSON() {
		List<JuteRateReportDTO> juterate = new ArrayList<>();
		try {
			List<JuteQualityPriceMaster> prices = priceDao.getAllJuteQualityPriceMaster();
			prices.forEach(price->{
				juterate.add(prepareJuteRateDTO(price));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return juterate;
	}

	private JuteRateReportDTO prepareJuteRateDTO(JuteQualityPriceMaster price) {
		JuteRateReportDTO jutestock = new JuteRateReportDTO();
		JuteQualityBatchMap batchmap = batchmapDao.getByJuteQuality(price.getId());
		BatchMaster batch = batchDao.getBatchById(batchmap.getBatchId());
		
		jutestock.setBatch(batch.getBatchName());
		jutestock.setDescription(price.getJuteQuality());
		jutestock.setJcode(String.valueOf(price.getId()));
		jutestock.setRate(String.valueOf(price.getRate()));
		
		return jutestock;
	}

}
