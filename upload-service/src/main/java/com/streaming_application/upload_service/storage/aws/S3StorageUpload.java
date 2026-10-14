package com.streaming_application.upload_service.storage.aws;

import com.streaming_application.upload_service.storage.StorageUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

@Service
public class S3StorageUpload implements StorageUpload{
    private final S3Presigner s3Presigner;
    private final String bucketName;

    public S3StorageUpload(
            S3Presigner s3Presigner,
            @Value("${aws.s3.bucket-name}") String bucketName
    ) {
        this.s3Presigner = s3Presigner;
        this.bucketName = bucketName;
    }
    @Override
    public String getPresignedUrl(String objetKey, Duration expiration) {
        PutObjectRequest putObjectRequest=PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objetKey)
                .build();
        PutObjectPresignRequest putObjectPresignRequest=PutObjectPresignRequest.builder()
                .putObjectRequest(putObjectRequest)
                .signatureDuration(expiration)
                .build();

        PresignedPutObjectRequest presignedPutObjectRequest=s3Presigner.presignPutObject(putObjectPresignRequest);
        return presignedPutObjectRequest.url().toString();
    }
}
