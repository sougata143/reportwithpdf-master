package com.sls.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sls.report.entity.JuteEntryHeader;

@Repository
public interface JuteGateEntryHdrRepository extends JpaRepository<JuteEntryHeader, Long> {
	
	JuteEntryHeader findById(long id); 

}
