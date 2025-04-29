# sport-store : backend

## Overview

Marcus Shop is an e-commerce for customizable bicycles and other products. Customers can view available bicycles and
personalize them by selecting different parts, such as the frame, wheels, and chain.

The backend of the application follows a **Hexagonal Architecture**, also known as **Ports and Adapters**, where the
core logic (domain layer) is decoupled from external systems (e.g., database, UI, or APIs).

## Architecture: Hexagonal Architecture

![Hexagonal Architecture](assets/hexarch.png)

Hexagonal Architecture helps to decouple the core application logic from the external systems. The main idea is to have
a **central core** (domain) that interacts with the outside world (e.g., database, web services) through **ports** and *
*adapters**.

In this system, the application is structured in layers to separate concerns, and each component has a well-defined
responsibility. Below is an explanation of the architecture and the key pieces involved in the codebase.

### Layers in the Architecture

1. **Domain Layer (Core)**:

- This is the heart of the application. It includes the business logic and entities. It does not depend on any external
  systems like databases or web frameworks. The domain layer includes:
    - **Entities**: The core objects of the system (e.g., `Product`, `Part`).
    - **Repositories**: Interfaces for data access (e.g., `ProductRepository`), allowing the domain to persist and
      retrieve data without being tied to a specific database technology.
    - **Services**: Business logic that operates on the domain entities and coordinates interactions between them.

2. **Application Layer**:

- This layer acts as a bridge between the domain and external systems. It uses **commands** and **services** to handle
  user requests and communicate with the domain. Key components include:
    - **Commands**: Objects that represent an action or intent. For example, a command might represent adding a product
      to the database.
    - **Services**: Orchestrate the application's use cases and business logic. They invoke the domain's functionality
      and make decisions based on external inputs.

3. **Infrastructure Layer**:

- This layer contains the technical details of how the application interacts with external systems, such as databases,
  web frameworks, or APIs. It includes:
    - **Repositories (Adapters)**: Concrete implementations of the repository interfaces that interact with the actual
      data store (e.g., using JPA to persist entities).
    - **API Adapters**: REST controllers or other mechanisms to expose the application to the outside world (e.g., HTTP
      API).
    - **Database**: The actual database (e.g., H2 for development) and its configuration.

---

## Key Components and Their Responsibilities

### 1. **Repository**

- **Responsibility**: Define the contract for data storage and retrieval. The repository is part of the domain layer but
  has an implementation in the infrastructure layer. It abstracts the persistence logic from the core application.
- **Example**: `ProductRepository`, which defines methods to save, find, and delete products. Implemented using JPA in
  the infrastructure layer (e.g., `JpaProductRepositoryAdapter`).

### 2. **Service**

- **Responsibility**: Contain business logic that operates on domain entities. A service can orchestrate multiple
  commands or actions to fulfill a use case.
- **Example**: `ProductService`, which might handle the logic to create a new product, check product availability, or
  apply discounts.

### 3. **Adapter**

- **Responsibility**: Implement the ports defined in the domain layer to communicate with external systems. Adapters are
  responsible for translating data between the internal format and the format expected by external systems (e.g.,
  database or APIs).
- **Example**: `JpaProductRepositoryAdapter`, which is responsible for translating between the `Product` entity in the
  domain and the `ProductEntity` in the database.

### 4. **Controller**

- **Responsibility**: Expose application functionality to the outside world (typically as a REST API). Controllers map
  HTTP requests to application services and return responses.
- **Example**: `ProductController`, which exposes API endpoints like `/api/products` to fetch product data.

---

## Features

- **Product and Part Management**: Administrators can add, manage, and customize products and parts in the system.
- **Customizable Bicycles**: Users can view available bicycles and customize them by selecting different parts (still in
  development).
- **Database Persistence**: The application uses H2 as an in-memory database for development and JPA for persistence.
- **CORS Configuration**: Allows frontend applications (running on `http://localhost:3000`) to interact with the backend
  API.

## Installation

To run the project locally, follow these steps:

1. Clone the repository

   `git clone https://github.com/hemarque/sport-store.git`

2. Build and run the project with Spring Boot.
   
   `cd backend`
   
   `mvn spring-boot:run`

    or

    `mvn clean package`

    `java -jar .\target\backend-1.0.jar`
    
3. Access the H2 database console at `http://localhost:8080/h2-console` (username: `sa`, no password).

4. Visit http://localhost:8080/api/products to access the product API.
    ##### Call the API like:

    **Products:**

    Product list:

    `curl -X GET http://localhost:8080/api/products`

    Product by id:

    `curl -X GET http://localhost:8080/api/products/2`

5. Visit http://localhost:8080/api/parts to access the parts API.
