package com.github.leandroheidemann.springrabbitmqtest.minio;

import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class MinioService {

    private final MinioClient minio;

    @Autowired
    public MinioService(MinioClient minioClient) {
        this.minio = minioClient;
    }

    public Optional<ObjectWriteResponse> put(String fileName, byte[] bytes) {
        try {
            final PutObjectArgs args = PutObjectArgs.builder()
                    .bucket("<BUCKET-NAME>")
                    .object("<OBJECT-NAME>")
                    .build();

            return Optional.of(minio.putObject(args));
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            return Optional.empty();
        }
    }

    public Optional<GetObjectResponse> get() {
        try {
            final GetObjectArgs args = GetObjectArgs.builder()
                    .bucket("<BUCKET-NAME>")
                    .object("<OBJECT-NAME>")
                    .build();

            return Optional.of(minio.getObject(args));
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException | InternalException e) {
            return Optional.empty();
        }
    }
}
