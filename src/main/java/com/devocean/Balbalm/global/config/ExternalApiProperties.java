package com.devocean.Balbalm.global.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "external-api")
public class ExternalApiProperties {
    private final Weather weather;
    @Getter
    public static class Weather {
        private String baseUrl;
        private String apiKey;
    }
}
