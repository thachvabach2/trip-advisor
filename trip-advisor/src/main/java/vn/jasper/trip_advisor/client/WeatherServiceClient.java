package vn.jasper.trip_advisor.client;

import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.Weather;

@RequiredArgsConstructor
public class WeatherServiceClient {

    private final RestClient client;

    public Weather getWeather(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(Weather.class);
    }

}
