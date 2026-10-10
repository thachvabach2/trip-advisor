package vn.jasper.trip_advisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.jasper.trip_advisor.dto.FlightReservationResponse;
import vn.jasper.trip_advisor.dto.TripPlan;
import vn.jasper.trip_advisor.dto.TripReservationRequest;
import vn.jasper.trip_advisor.service.TripPlanService;
import vn.jasper.trip_advisor.service.TripReservationService;

@RestController
@RequestMapping("trip")
@RequiredArgsConstructor
@Slf4j
public class TripController {

    private final TripPlanService planService;
    private final TripReservationService reservationService;

    @GetMapping("{airportCode}")
    public TripPlan planTrip(@PathVariable String airportCode) {
        log.info("airport code: {}, is virtual: {}", airportCode, Thread.currentThread().isVirtual());
        return this.planService.getTripPlan(airportCode);
    }

    @PostMapping("reserve")
    public FlightReservationResponse reserveFlight(@RequestBody TripReservationRequest request) {
        return this.reservationService.reserve(request);
    }

}
