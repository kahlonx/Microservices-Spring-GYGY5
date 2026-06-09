package com.turkcell.product_service.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="outbox")
public class OutboxEvent {
    @Id
    private UUID id;
    private String aggregateType; // Product
    private String aggregateId; // ProductId , Aggregate -> İlgili nesne
    private String eventType; // TestEvent
    @Column(columnDefinition = "TEXT")
    private String payload; // JSON
    private String errorMessage; // Hata varsa, ne hatası var?
    private int retryCount; // Kaç kere denedim?

    private Instant createdAt; // Şu tarihte sıraya aldım
    private Instant processedAt; // Şu tarihte kafkaya gönderdim?

    @Enumerated(EnumType.STRING)
    private OutboxStatus status; // PENDING, SENT, FAILED

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Instant processedAt) {
        this.processedAt = processedAt;
    }

    public OutboxStatus getStatus() {
        return status;
    }

    public void setStatus(OutboxStatus status) {
        this.status = status;
    }


    
}


// OutboxStatus => 1,2,3
// OutboxStatus => PENDING,SENT,FAILED

// Validator -> 50 tane farklı import