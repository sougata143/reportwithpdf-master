package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmMrLineItem;
import com.sls.report.repository.ScmMrLineItemRepository;

@Component
public class ScmMrLineItemComponent {
	
	@Autowired
	ScmMrLineItemRepository mrLineItemRepository;
	
	@Transactional
	public List<ScmMrLineItem>  getAllScmMrLineItem(){
		return mrLineItemRepository.findAll();
	}
	
	@Transactional
	public List<ScmMrLineItem> getScmMrLineItemById(long id) {
		return mrLineItemRepository.findByJuteReceiveNo(id);
	}

	public ScmMrLineItem getIssueLineItem(long id) {
		return mrLineItemRepository.findOne(id);
	}

}
