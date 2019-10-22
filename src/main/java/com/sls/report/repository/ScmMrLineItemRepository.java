package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.ScmMrLineItem;

public interface ScmMrLineItemRepository extends JpaRepository<ScmMrLineItem, Long> {
	
	List<ScmMrLineItem> findByJuteReceiveNo(long rcvno);

}
