# OUTFIND Bank

## Overview

OUTFIND Bank is a backend application built with Java and Spring Boot.

The project was created as a learning and portfolio project inspired by real banking systems, focusing on backend development, software architecture, REST APIs, version control, containers, and database integration.

## Tech Stack

* Java 21
* Spring Boot
* Maven
* Git
* GitHub
* PostgreSQL (planned)
* Docker (planned)

## Project Structure

* controller: REST endpoints
* service: business logic
* repository: data access layer
* entity: domain models
* dto: data transfer objects
* config: application configuration

## Running Locally

### Prerequisites

* Java 21
* Maven
* Git

### Run the Application

mvn spring-boot:run

The application will start on:

http://localhost:8080

## Available Endpoints

### Health Check

GET /health

### Customers

GET /customers

## Current Features

* Health endpoint
* Customer module
* Layered architecture
* JSON responses

## Future Improvements

* PostgreSQL integration
* Docker support
* Automated tests
* Authentication and authorization
* Banking operations
