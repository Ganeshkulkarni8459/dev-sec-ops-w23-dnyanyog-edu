package org.dnyanyog.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.dnyanyog.entity.AuditLogEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditLog {
	
	private String id;
    private LocalDateTime timestamp;
    private String requestId;// ClientId
    private String clientIp;
    private String userAgent;
    private String httpMethod;
    private String requestUrl;
    private Map<String, String> requestHeaders;
    private String requestBody;
    private int statusCode;
    private Map<String, String> responseHeaders;
    private String responseBody;
    private String microservice;
    private String endpoint;
    private String errorMessage;
    private String stackTrace;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}
	public void setRequestHeaders(Map<String, String> string) {
		this.requestHeaders = string;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Map<String, String> getResponseHeaders() {
		return responseHeaders;
	}
	public void setResponseHeaders(Map<String, String> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	public String getMicroservice() {
		return microservice;
	}
	public void setMicroservice(String microservice) {
		this.microservice = microservice;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
    
	public AuditLogEntity getAuditLogEntity() {
	    AuditLogEntity auditLog = new AuditLogEntity();
	    auditLog.setId(this.getId());
	    auditLog.setTimestamp(this.getTimestamp());
	    auditLog.setRequestId(this.getRequestId());
	    auditLog.setClientIp(this.getClientIp());
	    auditLog.setUserAgent(this.getUserAgent());
	    auditLog.setHttpMethod(this.getHttpMethod());
	    auditLog.setRequestUrl(this.getRequestUrl());
	    auditLog.setRequestHeaders(this.getRequestHeaders());
	    auditLog.setRequestBody(this.getRequestBody());
	    auditLog.setStatusCode(this.getStatusCode());
	    auditLog.setResponseHeaders(this.getResponseHeaders());
	    auditLog.setResponseBody(this.getResponseBody());
	    auditLog.setMicroservice(this.getMicroservice());
	    auditLog.setEndpoint(this.getEndpoint());
	    auditLog.setErrorMessage(this.getErrorMessage());
	    auditLog.setStackTrace(this.getStackTrace());
	    return auditLog;
	}
	
	public static List<AuditLog> fromEntityList(List<AuditLogEntity> entityList) {
        return entityList.stream()
                .map(AuditLog::fromEntity)
                .collect(Collectors.toList());
    }

    public static AuditLog fromEntity(AuditLogEntity entity) {
        AuditLog auditLog = new AuditLog();
        auditLog.setId(entity.getId());
        auditLog.setTimestamp(entity.getTimestamp());
        auditLog.setRequestId(entity.getRequestId());
        auditLog.setClientIp(entity.getClientIp());
        auditLog.setUserAgent(entity.getUserAgent());
        auditLog.setHttpMethod(entity.getHttpMethod());
        auditLog.setRequestUrl(entity.getRequestUrl());
        auditLog.setRequestHeaders(entity.getRequestHeaders());
        auditLog.setRequestBody(entity.getRequestBody());
        auditLog.setStatusCode(entity.getStatusCode());
        auditLog.setResponseHeaders(entity.getResponseHeaders());
        auditLog.setResponseBody(entity.getResponseBody());
        auditLog.setMicroservice(entity.getMicroservice());
        auditLog.setEndpoint(entity.getEndpoint());
        auditLog.setErrorMessage(entity.getErrorMessage());
        auditLog.setStackTrace(entity.getStackTrace());
        return auditLog;
    }


}
