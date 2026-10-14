package com.streaming_application.upload_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Upload {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID uploadId;
    private String fileName;
    private Long totalSize;
    private String ObjetKey;
    private UploadStatus status;
    private Instant createdAt;
    private Instant expiredAt;
}
