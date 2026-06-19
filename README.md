# Outfind Bank

## About the Project

Outfind Bank is a backend banking system developed for learning and portfolio purposes. The project is being built using Java and Spring Boot, following industry-standard practices such as layered architecture, Git workflow, code reviews, and database integration.

## Tech Stack

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Git & GitHub

## Project Structure

```text
br.com.outfind.bank
│
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── OutfindBankApplication
```

## Running Locally

### Prerequisites

* Java 21
* Maven
* PostgreSQL 18

### Database

Create a PostgreSQL database:

```sql
CREATE DATABASE outfind_bank;
```

Update the datasource credentials in:

```text
src/main/resources/application.yml
```

### Start the Application

```bash
mvn spring-boot:run
```

Or run the `OutfindBankApplication` class from IntelliJ IDEA.

## Available Endpoints

### Health Check

```http
GET /health
```

### Customers

```http
GET /customers
```

## Development Workflow

The project follows a Git workflow based on:

* Feature Branches
* Pull Requests
* Code Reviews
* Merge into Main Branch

## Future Roadmap

* Customer persistence with PostgreSQL
* DTO implementation
* Validation
* Unit Tests
* Integration Tests
* Docker support
* Spring Security
* Banking operations APIs
