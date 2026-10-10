package vn.jasper.trip_advisor.client;

import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.LocalRecommendations;

@RequiredArgsConstructor
public class LocalRecommendationServiceClient {

    private final RestClient client;

    public LocalRecommendations getRecommendations(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(LocalRecommendations.class);
    }

}
