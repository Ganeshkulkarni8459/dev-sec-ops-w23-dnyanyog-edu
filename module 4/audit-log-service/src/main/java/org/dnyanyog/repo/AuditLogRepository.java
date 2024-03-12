package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.AuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogEntity, Long> {

	List<AuditLogEntity> findByRequestId(String requestId);
	
}

