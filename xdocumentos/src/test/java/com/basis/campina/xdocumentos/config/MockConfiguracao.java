package com.basis.campina.xdocumentos.config;

import com.jlefebure.spring.boot.minio.MinioService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MockConfiguracao {

    @Bean(name = "com.jlefebure.spring.boot.minio.MinioService")
    @Primary
    @Profile("teste")
    public static MinioService getMinioService() {
        return Mockito.mock(MinioService.class);
    }
}
