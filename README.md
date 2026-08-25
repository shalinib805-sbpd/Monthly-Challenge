# Monthly Challenge

A Spring Boot REST API project for managing monthly coding challenges.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Gradle
* REST API
* Swagger / OpenAPI
* IntelliJ IDEA
* Postman
* Git
* GitHub

## Features

* Create a new challenge
* View all challenges
* View a challenge by ID
* Update a challenge
* Delete a challenge
* Store challenge data in MySQL
* RESTful API architecture
* Global exception handling
* 404 error handling for non-existing challenges
* API documentation and testing using Swagger

## API Endpoints

| Method | Endpoint           | Description            |
| ------ | ------------------ | ---------------------- |
| GET    | `/challenges`      | Get all challenges     |
| GET    | `/challenges/{id}` | Get challenge by ID    |
| POST   | `/challenges`      | Create a new challenge |
| PUT    | `/challenges/{id}` | Update a challenge     |
| DELETE | `/challenges/{id}` | Delete a challenge     |

## API Documentation

Swagger UI is used to document and test the REST APIs.

Start the Spring Boot application and open:

```text
http://localhost:8081/swagger-ui/index.html
```

OpenAPI documentation is available at:

```text
http://localhost:8081/v3/api-docs
```

## Example Request

### Create Challenge

**POST** `/challenges`

```json
{
  "title": "Spring Boot",
  "description": "Learn Spring Boot REST API",
  "month": "August"
}
```

### Example Response

```json
{
  "id": 11,
  "title": "Spring Boot",
  "description": "Learn Spring Boot REST API",
  "month": "August"
}
```

## Exception Handling

The project includes global exception handling for errors such as:

* Challenge not found
* Invalid challenge ID
* HTTP 404 Not Found responses

Example:

```json
{
  "error": "Challenge not found with id: 999"
}
```

## Project Structure

```text
src
└── main
    └── java
        └── com.student.monthlychallenge
            ├── controller
            │   └── ChallengeController.java
            │
            ├── service
            │   └── ChallengeService.java
            │
            ├── repository
            │   └── ChallengeRepository.java
            │
            ├── entity
            │   └── Challenge.java
            │
            └── exception
                ├── GlobalExceptionHandler.java
                └── ResourceNotFoundException.java
```

## Database

The application uses MySQL to store challenge information.

Database configuration is managed through:

```text
src/main/resources/application.properties
```

## How to Run the Project

### 1. Clone the repository

```bash
git clone <your-github-repository-url>
```

### 2. Open the project

Open the project in IntelliJ IDEA.

### 3. Configure MySQL

Make sure MySQL is running and the database is available.

### 4. Run the application

Run the Spring Boot application.

The application runs on:

```text
http://localhost:8081
```

### 5. Test the APIs

You can test the APIs using:

* Swagger UI
* Postman

## Tools Used

* IntelliJ IDEA
* MySQL
* Postman
* Swagger UI
* Git
* GitHub

## Author

Shalini B
