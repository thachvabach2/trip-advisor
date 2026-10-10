package vn.jasper.trip_advisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.Flight;

@RequiredArgsConstructor
public class FlightSearchServiceClient {

    private final RestClient client;

    public List<Flight> getFlights(String departure, String arrival) {
        return this.client.get()
                .uri("/{departure}/{arrival}", departure, arrival)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Flight>>() {
                });
    }

}
