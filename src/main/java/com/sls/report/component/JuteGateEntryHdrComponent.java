package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.JuteEntryHeader;
import com.sls.report.repository.JuteGateEntryHdrRepository;

@Component
public class JuteGateEntryHdrComponent {
	
	@Autowired
	JuteGateEntryHdrRepository jutegatehdrRepository;
	
	@Transactional
	public List<JuteEntryHeader> getAllJuteEntryHeader(){
		return jutegatehdrRepository.findAll();
	}
	
	@Transactional
	public JuteEntryHeader getJuteEntryHeaderById(long id) {
		return jutegatehdrRepository.findById(id);
	}

}
