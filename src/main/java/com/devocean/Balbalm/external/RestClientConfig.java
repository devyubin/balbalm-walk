package com.devocean.Balbalm.external;

import com.devocean.Balbalm.external.weather.WeatherAPIRestClient;
import com.devocean.Balbalm.global.config.ExternalApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(ExternalApiProperties.class)
public class RestClientConfig {
    private final RestClient.Builder restClientBuilder;
    private final ExternalApiProperties externalApiProperties;

    @Bean("weatherAPIRestClient")
    public WeatherAPIRestClient weatherAPIRestClient() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestClient restClient = restClientBuilder
                .requestFactory(requestFactory)
                .baseUrl(externalApiProperties.getWeather().getBaseUrl())
                .defaultStatusHandler(
                        HttpStatusCode::is4xxClientError,
                        (request, response) -> {
                            log.error("Server Error Status : {}, Body : {}", response.getStatusCode(), new String(response.getBody().readAllBytes()));
                        }
                )
                .defaultStatusHandler(
                        HttpStatusCode::is5xxServerError,
                        (request, response) -> {
                            log.error("Server Error Status : {}, Body : {}", response.getStatusCode(), new String(response.getBody().readAllBytes()));
                        }
                )
                .build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(WeatherAPIRestClient.class);
    }
}
