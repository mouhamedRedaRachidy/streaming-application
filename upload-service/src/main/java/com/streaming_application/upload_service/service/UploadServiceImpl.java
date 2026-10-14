package com.streaming_application.upload_service.service;

import com.streaming_application.upload_service.dto.request.UploadRequest;
import com.streaming_application.upload_service.entity.Upload;
import com.streaming_application.upload_service.mapper.UploadMapper;
import com.streaming_application.upload_service.repository.UploadRepository;
import com.streaming_application.upload_service.storage.StorageUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl {

    private final StorageUpload storageUpload;
    private final UploadRepository uploadRepository;

    public String upload(UploadRequest uploadRequest){
        //create record sur la base de donneee
        Upload uploadRecord=UploadMapper.toEntity(uploadRequest);
        String objetKey="uploads/videos/"+uploadRequest.fileName()+uploadRecord.getUploadId();
        uploadRecord.setObjetKey(objetKey);
        this.uploadRepository.save(uploadRecord);

        //generation presigned url
        return this.storageUpload.getPresignedUrl(uploadRecord.getObjetKey(),Duration.ofMinutes(10));

    }
}
