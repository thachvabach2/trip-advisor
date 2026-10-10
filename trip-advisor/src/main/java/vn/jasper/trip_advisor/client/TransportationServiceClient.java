package vn.jasper.trip_advisor.client;

import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.Transportation;

@RequiredArgsConstructor
public class TransportationServiceClient {

    private final RestClient client;

    public Transportation getTransportation(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(Transportation.class);
    }

}
