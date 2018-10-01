package com.zycus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.zycus.entity.AuditLog;
import com.zycus.services.Services;

@Component
public class AuditController {

	@Autowired
	Services ser;
	
	@JmsListener(destination="Logging Queue")
	public void Consume(AuditLog log) {
		log.setDate(new Date());
		log.setId(System.currentTimeMillis()%100000000000L);
		System.out.println("i am in audit ActiveMQ Consuming Application");
		ser.updateLog(log);
		
	}
}
