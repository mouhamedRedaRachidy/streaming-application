package com.streaming_application.upload_service.dto.response;

import lombok.Builder;

@Builder
public record UploadResponse(
        String uploadUrl
) {
}
