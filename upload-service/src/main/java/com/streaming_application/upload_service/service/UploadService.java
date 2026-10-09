package com.streaming_application.upload_service.service;

public interface UploadService {
    String generatePresignedUrl();
    String getPresignedUrl();
    String PutPresignedUrl();
}
