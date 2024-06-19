# Blog Application

This project implements a blog application using Java with Spring Boot and PostgreSQL database. Below are the key features and components implemented:

## Features Implemented:

1. **Data Model and JPA Entities**:
   - Designed and implemented entities such as `User`, `Article`, and `Comment` using Java Persistence API (JPA).
   - Established relationships between entities (e.g., one-to-many, many-to-one).

2. **Spring Data JPA Repository**:
   - Implemented repository interfaces with custom query methods to fetch data from the database, including:
      - Finding all articles published before a certain date.

3. **REST API for Articles**:
   - Developed RESTful endpoints to perform CRUD operations on articles:
      - **GET `/api/articles`**: Retrieve a list of all articles.
      - **GET `/api/articles/{id}`**: Retrieve an article by its ID.
      - **POST `/api/articles`**: Create a new article.
      - **PUT `/api/articles/{id}`**: Update an existing article.
      - **DELETE `/api/articles/{id}`**: Delete an article.

4. **Exception Handling**:
   - Implemented global exception handling in Spring Boot to return custom error messages for REST API endpoints.
   - Handled common exceptions such as resource not found (`ResourceNotFoundException`) and validation errors (`MethodArgumentNotValidException`).

5. **Validation**:
   - Validated input parameters and request bodies using `javax.validation` annotations.
   - Ensured data integrity and handled validation errors gracefully.

6. **Swagger Documentation**:
   - Integrated Swagger for API documentation.
   - Documented API endpoints with detailed descriptions, request/response models, and possible error responses.

7. **Flyway Migration**:
   - Used Flyway to manage database schema evolution.
   - Applied initial SQL migrations to set up the PostgreSQL database schema (`init.sql`).
