# Sunrise Airline Reservation System

A desktop airline reservation system built in Java with a MySQL backend. Built as an academic project (Lambton College, Semester 2) to practice Java, JDBC, and relational database design.

## Features

- Role-based login for customers, staff, and admins
- Flight schedule management — add, update, and delete flights (number, departure/arrival times, destination, aircraft details)
- Seat selection and ticket booking workflow for customers

## Tech Stack

- **Language:** Java
- **Database:** MySQL (via `mysql-connector-j`)
- **UI:** Java Swing (NetBeans project)
- **Libraries:** `jcalendar` (date picker), `rs2xml` (ResultSet-to-table binding)

## Screenshots

![Screenshot 1](https://github.com/user-attachments/assets/d7fc3249-bfde-4f23-9688-3502fe18cd84)
![Screenshot 2](https://github.com/user-attachments/assets/79c29531-680e-4ab4-ac3b-c55446e471ce)
![Screenshot 3](https://github.com/user-attachments/assets/f913f390-595a-4afa-8a45-e213940ad9f0)
![Screenshot 4](https://github.com/user-attachments/assets/724dc09f-ef5e-49c1-8849-f8855d8cefab)

## Setup

1. Import the project into NetBeans (or another Java IDE that reads `nbproject`).
2. Create a MySQL database and run `airlinemanagementsystem.sql` to set up the schema.
3. Update the database connection details in the source code to match your local MySQL credentials.
4. Build and run via `build.xml` or directly in your IDE.

## Notes

This project was built for coursework and is not actively maintained. It reflects an early-stage Java/JDBC project rather than a production system.
