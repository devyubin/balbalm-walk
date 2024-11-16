package com.devocean.Balbalm.external.weather;


import com.devocean.Balbalm.external.weather.response.WeatherResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange()
public interface WeatherAPIRestClient {

    @GetExchange
    WeatherResponse analysisMailContent(@RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("appid") String appId);

}

