package com.streaming_application.upload_service.storage;

import java.time.Duration;

public interface StorageUpload {
    String getPresignedUrl(String objetKey, Duration expiration);
}
