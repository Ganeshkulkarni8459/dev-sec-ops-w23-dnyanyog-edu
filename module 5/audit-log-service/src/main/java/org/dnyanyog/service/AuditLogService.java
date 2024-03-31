package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.AuditLog;
import org.dnyanyog.entity.AuditLogEntity;
import org.dnyanyog.repo.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditLogService {

  @Autowired private AuditLogRepository auditLogRepository;

  public ResponseEntity<AuditLogEntity> saveAuditLog(AuditLog auditLogRequest) {
    try {
      AuditLogEntity savedAuditLog = auditLogRepository.save(auditLogRequest.getAuditLogEntity());
      return new ResponseEntity<>(savedAuditLog, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
    try {
      List<AuditLogEntity> auditLogs = auditLogRepository.findAll();
      return new ResponseEntity<>(AuditLog.fromEntityList(auditLogs), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<AuditLog>> findByRequestId(String requestId) {
    try {

      return new ResponseEntity<>(
          AuditLog.fromEntityList(auditLogRepository.findByRequestId(requestId)), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
