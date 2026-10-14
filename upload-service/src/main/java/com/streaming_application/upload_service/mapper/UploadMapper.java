package com.streaming_application.upload_service.mapper;

import com.streaming_application.upload_service.dto.request.UploadRequest;
import com.streaming_application.upload_service.dto.response.UploadResponse;
import com.streaming_application.upload_service.entity.Upload;
import com.streaming_application.upload_service.entity.UploadStatus;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class UploadMapper {
    public static UploadResponse toResponse(String uploadUrl){
        return UploadResponse.builder()
                .uploadUrl(uploadUrl)
                .build();
    }

    public static Upload toEntity(UploadRequest uploadRequest){
        Instant now = Instant.now();
        return Upload.builder()
                .fileName(uploadRequest.fileName())
                .uploadId(UUID.randomUUID())
                .status(UploadStatus.PENDING)
                .createdAt(now)
                .expiredAt(now.plus(Duration.ofDays(1)))
                .build();
    }
}
