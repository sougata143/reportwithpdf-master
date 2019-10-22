package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmMrHdr;
import com.sls.report.repository.ScmMrHdrRepository;

@Component
public class ScmMrHdrComponent {
	
	@Autowired
	ScmMrHdrRepository mrhdrRepo;
	
	@Transactional
	public List<ScmMrHdr> getAllMrHdr(){
		return mrhdrRepo.findAll();
	}
	
	@Transactional
	public ScmMrHdr getMrHdrById(long id) {
		return mrhdrRepo.findOne(id);
	}

}
