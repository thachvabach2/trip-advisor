package vn.jasper.trip_advisor.dto;

import java.util.List;

public record TripPlan(String airportCode,
        List<Accommodation> accommodations,
        Weather weather,
        List<Event> events,
        LocalRecommendations localRecommendation,
        Transportation transportation) {

}