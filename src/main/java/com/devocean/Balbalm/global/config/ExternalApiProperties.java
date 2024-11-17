package com.devocean.Balbalm.global.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "balbalm.external-api")
public class ExternalApiProperties {
    private Weather weather;

    @Data
    public static class Weather {
        private String baseUrl;
        private String apiKey;
    }
}
