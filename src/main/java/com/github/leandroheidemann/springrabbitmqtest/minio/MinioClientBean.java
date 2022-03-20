package com.github.leandroheidemann.springrabbitmqtest.minio;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioClientBean {

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("")
                .credentials("", "")
                .build();
    }

}
