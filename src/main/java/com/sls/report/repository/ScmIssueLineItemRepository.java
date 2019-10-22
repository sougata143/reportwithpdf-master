package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.ScmIssueLineItem;

public interface ScmIssueLineItemRepository extends JpaRepository<ScmIssueLineItem, String>{

	List<ScmIssueLineItem> findByItemCode(String itemCode);
//	ScmIssueLineItem findByAdditionalRequirement
	
}
