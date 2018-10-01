package com.zycus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.AuditLog;
import com.zycus.repository.AuditRepository;

@Service
@Transactional
public class AuditService implements Services{

	@Autowired
	AuditRepository repo;
	
	public void updateLog(AuditLog log) {
		repo.save(log);
	}
}
