package vn.jasper.trip_advisor.client;

import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.dto.FlightReservationRequest;
import vn.jasper.trip_advisor.dto.FlightReservationResponse;

@RequiredArgsConstructor
public class FlightReservationServiceClient {

    private final RestClient client;

    public FlightReservationResponse reserve(FlightReservationRequest request) {
        return this.client.post()
                .body(request)
                .retrieve()
                .body(FlightReservationResponse.class);
    }

}
