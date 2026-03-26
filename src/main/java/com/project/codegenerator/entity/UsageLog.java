package com.project.codegenerator.entity;


import java.time.Instant;

public class UsageLog {
    Long id;
    User user;
    Project project;
    String action;
    Integer tokenUsed;
    Integer durationMs;
    String metaData;
    Instant createdAt;

}
