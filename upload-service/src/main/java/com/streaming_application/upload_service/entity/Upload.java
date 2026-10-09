package com.streaming_application.upload_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Upload {
    @Id
    @GeneratedValue
    private UUID id;
    private String fileName;
    private Long totalSize;
    private UploadStatus status;
}
