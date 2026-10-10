package vn.jasper.trip_advisor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.jasper.trip_advisor.client.FlightReservationServiceClient;
import vn.jasper.trip_advisor.client.FlightSearchServiceClient;
import vn.jasper.trip_advisor.dto.Flight;
import vn.jasper.trip_advisor.dto.FlightReservationRequest;
import vn.jasper.trip_advisor.dto.FlightReservationResponse;
import vn.jasper.trip_advisor.dto.TripReservationRequest;

@Service
@RequiredArgsConstructor
public class TripReservationService {

    private final FlightSearchServiceClient searchServiceClient;
    private final FlightReservationServiceClient reservationServiceClient;

    public FlightReservationResponse reserve(TripReservationRequest request) {
        List<Flight> flights = this.searchServiceClient.getFlights(request.departure(), request.arrival());

        Optional<Flight> bestDeal = flights.stream().min((a, b) -> a.price() - b.price());
        Flight flight = bestDeal.orElseThrow(() -> new IllegalStateException("no flight found"));

        var reservationRequest = new FlightReservationRequest(request.departure(), request.arrival(),
                flight.flightNumber(), request.date());
        return this.reservationServiceClient.reserve(reservationRequest);

    }

}
