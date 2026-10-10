package vn.jasper.trip_advisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.jasper.trip_advisor.dto.Accommodation;

@RequiredArgsConstructor
public class AccommodationServiceClient {

    private final RestClient client;

    public List<Accommodation> geAccommodations(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Accommodation>>() {
                });
    }

}
