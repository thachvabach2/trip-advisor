# Travel Planning & Reservation System (TripAdvisor Clone)

This project is the backend system for a comprehensive travel planning and reservation platform, inspired by TripAdvisor. It acts as an aggregator, seamlessly orchestrating requests to various upstream services to provide users with a complete travel experience, from finding local attractions to booking flights.

## 🚀 Tech Stack

This project is built using cutting-edge technologies to ensure high performance and scalability:
* **Language:** Java 25
* **Framework:** Spring Boot 4.1.1
* **Web:** Spring Web (RESTful APIs)
* **Concurrency:** Virtual Threads (Project Loom) - Utilized to handle thousands of concurrent blocking I/O operations (like calling multiple upstream services) without exhausting system resources.
* **Build Tool:** Maven

## 🏗️ Upstream Services Architecture

Based on the system design, this backend orchestrates calls to two main groups of upstream services:

### 1. Trip Planning
Services dedicated to providing destination experiences and local information:
* **Accommodation Service:** Manages lodging and hotel information.
* **Event Service:** Provides data on local events and happenings.
* **Local Recommendation Service:** Suggests local spots, including:
  * *Restaurants*
  * *Sightseeing*
* **Transportation Service:** Handles local transit information and routing.
* **Weather Service:** Provides weather forecasts for destinations.

### 2. Trip/Flight Reservation
Services handling flight-related operations:
* **Flight Search Service:** Handles flight queries, schedules, and pricing.
* **Flight Reservation Service:** Manages the booking process, seat reservations, and ticketing.

## ⚙️ Prerequisites

To build and run this project, you will need:
* **Java:** JDK 25 or higher
* **Maven:** 3.9+ (or use the included Maven Wrapper)