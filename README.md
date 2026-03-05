# PaymentService-Simulator
Payment service simulator made using Spring Boot
# Payment Simulation System

## Overview

This project is a **Payment Simulation System built using Spring Boot**.
It simulates payment processing between services and demonstrates concepts such as:

* REST APIs
* Asynchronous processing
* Idempotency
* Webhooks
* Database transactions
* Payment status management

The goal of this project is to demonstrate **backend architecture used in real-world payment systems**.

---

# Tech Stack

Backend:

* Java
* Spring Boot
* Spring Data JPA
* Spring Web

Database:

* PostgreSQL

Build Tool:

* Maven

Other Concepts:

* REST API
* Idempotency
* Async Processing
* Webhooks

---

# Project Architecture

Client
|
v
Controller Layer
|
Service Layer
|
Repository Layer
|
PostgreSQL Database

---

# Features

* Create Payment
* Fetch Payment Status
* Simulated Payment Processing
* Idempotency Handling
* Webhook Notification System
* Transaction Management

---

# Project Structure

src/main/java/com/example/payment

controller
Handles incoming API requests.

service
Contains business logic.

repository
Handles database operations.

entity
Defines database models.

config
Application configuration.

---

# API Endpoints

Create Payment

POST /payments

Example Request

{
"amount": 1000,
"currency": "INR",
"userId": "123"
}

---

Get Payment Status

GET /payments/{paymentId}

---

# Running the Project

Clone the repository

git clone https://github.com/deveshpassi/PaymentService-Simulator.git

Navigate into project

cd payment-simulation-system

Run application

./mvnw spring-boot:run

or

mvn spring-boot:run

---

# Database Setup

Create PostgreSQL database:

payment_db

Update application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/payment_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

---

# Future Improvements

* Add Authentication with JWT
* Integrate Stripe API
* Add Kafka for event processing
* Convert to Microservices
* Add Docker and Kubernetes deployment

---

# Author

Devesh

Backend Developer focused on:
Java, Spring Boot, System Design, and Distributed Systems
