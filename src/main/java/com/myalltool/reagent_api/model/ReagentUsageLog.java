package com.myalltool.reagent_api.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReagentUsageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageLogId;

    private Long reagentId;

    private String reagentCategory;

    private String reagentName;

    private String lotNo;

    private Integer usedQuantity;

    private Integer remainingQuantity;

    private String unit;

    private String storageLocation;

    @CreationTimestamp
    private LocalDateTime usedAt;

    public Long getUsageLogId() {
        return usageLogId;
    }

    public void setUsageLogId(Long usageLogId) {
        this.usageLogId = usageLogId;
    }

    public Long getReagentId() {
        return reagentId;
    }

    public void setReagentId(Long reagentId) {
        this.reagentId = reagentId;
    }

    public String getReagentCategory() {
        return reagentCategory;
    }

    public void setReagentCategory(String reagentCategory) {
        this.reagentCategory = reagentCategory;
    }

    public String getReagentName() {
        return reagentName;
    }

    public void setReagentName(String reagentName) {
        this.reagentName = reagentName;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public Integer getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(Integer usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }
}