package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
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
    private KeywordType keywordExist;
}
