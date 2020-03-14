package com.entity;

import lombok.Data;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private KeywordType keywordExist;
}
