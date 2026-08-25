# Monthly Challenge

A Spring Boot REST API project for managing monthly coding challenges.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle
- REST API
- Swagger / OpenAPI
- Jakarta Validation
- IntelliJ IDEA
- Postman
- Git
- GitHub

## Features

- Create a new challenge
- View all challenges
- View a challenge by ID
- Update a challenge
- Delete a challenge
- Store challenge data in MySQL
- RESTful API architecture
- Input validation using `@Valid` and `@NotBlank`
- Global exception handling
- 400 Bad Request handling for validation errors
- 404 Not Found handling for non-existing challenges
- API documentation and testing using Swagger
- Proper HTTP status codes

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/challenges` | Get all challenges |
| GET | `/challenges/{id}` | Get challenge by ID |
| POST | `/challenges` | Create a new challenge |
| PUT | `/challenges/{id}` | Update a challenge |
| DELETE | `/challenges/{id}` | Delete a challenge |

## HTTP Status Codes

| Status Code | Meaning |
|-------------|---------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |

## API Documentation

Swagger UI is used to document and test the REST APIs.

Start the Spring Boot application and open:

```text
http://localhost:8081/swagger-ui/index.html