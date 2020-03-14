package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private long monitoringInterval;
    private String friendlySiteName;
    private String siteName;
    private MonitoringType monitoringType;
    private int status = 1;
    private String keywordExist;
    private String keywordNotExist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFriendlySiteName() {
        return friendlySiteName;
    }

    public void setFriendlySiteName(String friendlySiteName) {
        this.friendlySiteName = friendlySiteName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public MonitoringType getMonitoringType() {
        return monitoringType;
    }

    public void setMonitoringType(MonitoringType monitoringType) {
        this.monitoringType = monitoringType;
    }

    public long getMonitoringInterval() {
        return monitoringInterval;
    }

    public void setMonitoringInterval(long monitoringInterval) {
        this.monitoringInterval = monitoringInterval;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKeywordExist() {
        return keywordExist;
    }

    public void setKeywordExist(String keywordExist) {
        this.keywordExist = keywordExist;
    }

    public String getKeywordNotExist() {
        return keywordNotExist;
    }

    public void setKeywordNotExist(String keywordNotExist) {
        this.keywordNotExist = keywordNotExist;
    }
}
