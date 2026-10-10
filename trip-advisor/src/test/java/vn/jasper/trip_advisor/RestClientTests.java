package vn.jasper.trip_advisor;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import vn.jasper.trip_advisor.dto.Accommodation;
import vn.jasper.trip_advisor.dto.FlightReservationRequest;
import vn.jasper.trip_advisor.dto.Weather;

class RestClientTests {

    private static final Logger log = LoggerFactory.getLogger(RestClientTests.class);

    @Test
    void simpleGet() {
        RestClient client = RestClient.create();

        Weather response = client.get()
                .uri("http://localhost:7072/sec02/weather/LAS")
                .retrieve()
                .body(Weather.class);

        log.info("response: {}", response);
    }

    @Test
    void baseUrl() {

        RestClient client = RestClient.builder()
                .baseUrl("http://localhost:7072/sec02/weather/")
                .build();

        Weather response = client.get()
                .uri("{airportCode}", "LAS")
                .retrieve()
                .body(Weather.class);

        log.info("response: {}", response);

    }

    @Test
    void listResponse() {

        RestClient client = RestClient.builder()
                .baseUrl("http://localhost:7072/sec02/accommodations/")
                .build();

        List<Accommodation> response = client.get()
                .uri("{airportCode}", "LAS")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Accommodation>>() {
                });

        log.info("response: {}", response);

    }

    @Test
    void postRequest() {

        RestClient client = RestClient.builder()
                .baseUrl("http://localhost:7072/sec03/flight/reserve/")
                .build();

        FlightReservationRequest request = new FlightReservationRequest("ATL", "LAS", "UA789", LocalDate.now());
        FlightReservationRequest response = client.post()
                .body(request)
                .retrieve()
                .body(FlightReservationRequest.class);

        log.info("response: {}", response);

    }

}
