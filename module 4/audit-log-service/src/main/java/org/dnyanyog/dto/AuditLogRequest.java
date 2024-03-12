package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditLogRequest {
	
	@Autowired
	private AuditLog auditLog;
}
