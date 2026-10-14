package com.streaming_application.upload_service.dto.request;

import jakarta.validation.constraints.*;

public record UploadRequest(

        @NotBlank(message = "File name is required")
        @Size(max = 255, message = "File name is too long")
        String fileName,

        @NotBlank(message = "Content type is required")
        @Pattern(
                regexp = "video/(mp4|webm)",
                message = "Only MP4 and WebM are allowed"
        )
        String contentType
) {}
