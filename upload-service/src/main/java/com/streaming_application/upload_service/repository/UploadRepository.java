package com.streaming_application.upload_service.repository;

import com.streaming_application.upload_service.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UploadRepository extends JpaRepository<Upload, UUID> {
}
