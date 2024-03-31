package org.dnyanyog.controller;

import java.util.List;
import org.dnyanyog.dto.AuditLog;
import org.dnyanyog.entity.AuditLogEntity;
import org.dnyanyog.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {

  @Autowired private AuditLogService auditLogService;

  @PostMapping(path = "/api/v1/audit/log")
  public ResponseEntity<AuditLogEntity> createAuditLog(@RequestBody AuditLog auditLogRequest) {

    return auditLogService.saveAuditLog(auditLogRequest);
  }

  @GetMapping(path = "/api/v1/audit")
  public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
    return auditLogService.getAllAuditLogs();
  }

  @GetMapping(path = "/api/v1/audit/{requestId}")
  public ResponseEntity<List<AuditLog>> getAuditLogsByRequestedId(@PathVariable String requestId) {
    return auditLogService.findByRequestId(requestId);
  }
}
