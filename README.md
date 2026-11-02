# Restaurant Management System

A RESTful Restaurant Management API developed using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**. This project manages restaurants and their food items through REST APIs, with support for CRUD operations, bulk insertion, entity relationships, request validation, and exception handling.

## Tech Stack

- **Language:** Java
- **Backend Framework:** Spring Boot 4.1.2
- **Database:** MySQL
- **ORM:** Hibernate
- **Persistence:** Spring Data JPA
- **Validation:** Jakarta Bean Validation
- **API Documentation:** Swagger UI
- **Build Tool:** Maven
- **Testing Tool:** Postman / Swagger UI

## Features

### Restaurant Management
- Create a restaurant.
- Insert multiple restaurants.
- Retrieve all restaurants.
- Retrieve a restaurant by ID.
- Update restaurant details using PUT.
- Partially update restaurant details using PATCH.
- Delete a restaurant.
- Search restaurants by city, active status, rating, and name.

### Food Management
- Add food items to a restaurant.
- Insert multiple food items into a restaurant.
- Retrieve all food items.
- Retrieve a food item by ID.
- Retrieve food items by restaurant ID.
- Update food details using PUT.
- Partially update food details using PATCH.
- Delete a food item.

### Additional Features
- One-to-Many relationship between Restaurant and Food.
- Many-to-One relationship between Food and Restaurant.
- Spring Data JPA repositories.
- Bean validation for request data.
- Global exception handling.
- Appropriate HTTP status codes using ResponseEntity.
- API testing and documentation using Swagger UI.

## Project Structure

```text
RestaurantManagement
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.Shravan.RestaurantManagement
│   │   │       ├── Modal
│   │   │       │   ├── Restaurant.java
│   │   │       │   └── Food.java
│   │   │       │
│   │   │       ├── Repo
│   │   │       │   ├── RestaurantRepository.java
│   │   │       │   └── FoodRepository.java
│   │   │       │
│   │   │       ├── Service
│   │   │       ├── ServiceImpl
│   │   │       ├── controller
│   │   │       │   ├── RestaurantController.java
│   │   │       │   ├── FoodController.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       └── RestaurantManagementApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties.example
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Database Configuration

1. Install MySQL and start the MySQL server.
2. Create the database:

```sql
CREATE DATABASE restaurantmanagement;
```

3. Open `src/main/resources/application.properties.example`.
4. Create a local `application.properties` file in the same directory.
5. Configure your MySQL credentials:

```properties
spring.application.name=RestaurantManagement
server.port=9090

spring.datasource.url=jdbc:mysql://localhost:3306/restaurantmanagement
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Note:** Never commit your actual database credentials to GitHub.

## Run the Application

Clone the repository:

```bash
git clone https://github.com/Shravank9/RestaurantManagement.git
```

Navigate to the project directory:

```bash
cd RestaurantManagement
```

Run using Maven Wrapper on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start at:

```text
http://localhost:9090
```

## API Documentation

Swagger UI:

```text
http://localhost:9090/swagger-ui/index.html
```

Use Swagger UI to explore and test the available REST APIs.

## API Endpoints

### Restaurant APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/restaurants` | Create restaurant |
| POST | `/restaurants/multiple` | Bulk insert restaurants |
| GET | `/restaurants` | Get all restaurants |
| GET | `/restaurants/{id}` | Get restaurant by ID |
| PUT | `/restaurants/{id}` | Update restaurant |
| PATCH | `/restaurants/{id}` | Partially update restaurant |
| DELETE | `/restaurants/{id}` | Delete restaurant |
| GET | `/restaurants/city/{city}` | Search by city |
| GET | `/restaurants/search` | Search by city and active status |
| GET | `/restaurants/rating/{rating}` | Search by rating |
| GET | `/restaurants/minimum-rating/{rating}` | Search by minimum rating |
| GET | `/restaurants/search/{name}` | Search by restaurant name |

### Food APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/foods/{restaurantId}` | Add food to restaurant |
| POST | `/foods/multiple/{restaurantId}` | Bulk insert food items |
| GET | `/foods` | Get all food items |
| GET | `/foods/{id}` | Get food by ID |
| GET | `/foods/restaurant/{restaurantId}` | Get foods by restaurant |
| PUT | `/foods/{id}` | Update food |
| PATCH | `/foods/{id}` | Partially update food |
| DELETE | `/foods/{id}` | Delete food |

## Future Enhancements

- DTO implementation for request and response handling.
- Advanced custom JPQL queries.
- Pagination and sorting.
- Authentication and authorization using Spring Security.
- Order and customer management.
- Frontend integration.

## Author

**Shravan Kumar**

GitHub: [Shravank9](https://github.com/Shravank9)

## License

This project is developed for learning and educational purposes.

## Swagger UI Screenshots

The following screenshots demonstrate the REST API endpoints available in the Restaurant Management System.

### Screenshot 1
![Swagger Screenshot 1](screenshots/Screenshot%202026-11-02%20110621.png)

### Screenshot 2
![Swagger Screenshot 2](screenshots/Screenshot%202026-11-02%20110638.png)

### Screenshot 3
![Swagger Screenshot 3](screenshots/Screenshot%202026-11-02%20110649.png)

### Screenshot 4
![Swagger Screenshot 4](screenshots/Screenshot%202026-11-02%20110659.png)

### Screenshot 5
![Swagger Screenshot 5](screenshots/Screenshot%202026-11-02%20110707.png)
