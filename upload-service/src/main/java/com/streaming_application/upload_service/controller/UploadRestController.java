package com.streaming_application.upload_service.controller;

import com.streaming_application.upload_service.dto.request.UploadRequest;
import com.streaming_application.upload_service.dto.response.UploadResponse;
import com.streaming_application.upload_service.mapper.UploadMapper;
import com.streaming_application.upload_service.service.UploadServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class UploadRestController {

    private final UploadServiceImpl uploadService;

    @PostMapping
    public ResponseEntity<UploadResponse> getPresignedUrl(
            @Valid @RequestBody  UploadRequest uploadRequest
            ){

        String uploadUrl= this.uploadService.upload(uploadRequest);

        UploadResponse uploadResponse= UploadMapper.toResponse(uploadUrl);

        return ResponseEntity.ok(uploadResponse);
    }

}
