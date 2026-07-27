# Airline REST API

This backend replaces the original Swing/JDBC workflow with a Spring Boot REST API backed by the same MySQL database.

## Endpoints
- POST /flights
- GET /flights
- POST /bookings
- GET /bookings

## Run locally
1. Start MySQL and create the `ams` schema using the SQL script in the project root.
2. From the `backend` directory, run:
   `mvn spring-boot:run`
3. Use `http://localhost:8080` to call the API.
