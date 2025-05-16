# Railway Management System

A Spring Boot-based Railway Management System that provides REST APIs for managing trains, passengers, and bookings.

## Features

- Train Management (CRUD operations)
- Passenger Management (CRUD operations)
- Booking Management (CRUD operations)
- Booking Status Tracking
- H2 Database for development

## Technologies Used

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- H2 Database
- Maven
- RESTful APIs

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/Praharshini0409/railway-management-system.git
```

2. Navigate to the project directory:
```bash
cd railway-management-system
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on port 8084.

## API Endpoints

### Train Management
- GET `/api/trains` - Get all trains
- GET `/api/trains/{id}` - Get train by ID
- POST `/api/trains` - Create new train
- PUT `/api/trains/{id}` - Update train
- DELETE `/api/trains/{id}` - Delete train

### Passenger Management
- GET `/api/passengers` - Get all passengers
- GET `/api/passengers/{id}` - Get passenger by ID
- POST `/api/passengers` - Create new passenger
- PUT `/api/passengers/{id}` - Update passenger
- DELETE `/api/passengers/{id}` - Delete passenger

### Booking Management
- GET `/api/bookings` - Get all bookings
- GET `/api/bookings/{id}` - Get booking by ID
- POST `/api/bookings` - Create new booking
- PUT `/api/bookings/{id}` - Update booking
- DELETE `/api/bookings/{id}` - Delete booking
- GET `/api/bookings/status/{status}` - Get bookings by status
- GET `/api/bookings/passenger/{passengerId}` - Get bookings by passenger

## Database

The application uses H2 database in development. You can access the H2 console at:
- URL: `http://localhost:8084/h2-console`
- JDBC URL: `jdbc:h2:mem:railwaydb`
- Username: `sa`
- Password: (leave empty)

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
