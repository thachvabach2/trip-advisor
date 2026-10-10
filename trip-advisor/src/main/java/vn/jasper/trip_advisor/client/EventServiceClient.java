package vn.jasper.trip_advisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.Event;

@RequiredArgsConstructor
public class EventServiceClient {

    private final RestClient client;

    public List<Event> getEvents(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Event>>() {
                });
    }

}
