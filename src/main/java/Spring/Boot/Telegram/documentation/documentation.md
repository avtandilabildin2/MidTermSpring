**Software Requirements Specification (SRS) for Telegram Contacts Management System**

## 1. Introduction
### 1.1 Purpose
The purpose of this document is to define the requirements for a Telegram contacts management system. This application was initially developed using Java with an in-memory `ArrayList` for data storage, but it will now be rewritten using the **Spring Framework** with **PostgreSQL** as the primary database. The system will allow users to manage their Telegram contacts efficiently.

### 1.2 Scope
The application will provide:
- Contact management (adding, updating, deleting, and listing contacts)
- Search functionality for contacts
- Data persistence using PostgreSQL (H2 for development)
- RESTful API for interacting with contacts
- Basic validation and exception handling

### 1.3 Intended Audience and Usage
This document is intended for developers and testers involved in building the Spring-based application.

---
## 2. Functional Requirements

### 2.1 Contact Management
- **Add a new contact** (name, username, phone number, etc.)
- **Update an existing contact**
- **Delete a contact**
- **List all contacts**
- **Search contacts by name or username**

### 2.2 API Endpoints
- Provide RESTful endpoints for managing contacts (CRUD operations)
- Use **DTOs** for data transfer
- Implement **unit tests** for controllers and services

---
## 3. Non-Functional Requirements

- **Performance:** Should handle multiple requests efficiently.
- **Scalability:** Should support a growing number of contacts.
- **Security:** Ensure proper data validation and exception handling.
- **Maintainability:** Code should follow best practices for easy updates.

---
## 4. Data Model
### Entities:
- **Contact** (ID, Name, Username, PhoneNumber, CreatedAt, UpdatedAt)

### Relationships:
- The system manages multiple **Contacts** stored in a PostgreSQL database.

---
## 5. Use Cases

### Use Case 1: Adding a Contact
- **Actor:** User
- **Description:** The user adds a new contact to the database.
- **Precondition:** Valid data (name, username, phone number) must be provided.
- **Postcondition:** Contact is stored in the database.

### Use Case 2: Searching for a Contact
- **Actor:** User
- **Description:** The user searches for a contact by name or username.
- **Precondition:** At least one contact exists in the system.
- **Postcondition:** Relevant contacts are returned.

### Use Case 3: Deleting a Contact
- **Actor:** User
- **Description:** The user deletes a contact from the database.
- **Precondition:** The contact must exist.
- **Postcondition:** Contact is removed from the database.

---
## 6. Assumptions and Constraints
- The system only manages contacts (not messages or chat history).
- PostgreSQL is used in production, H2 for development.
- REST API will be documented using **Swagger/OpenAPI**.

---
## 7. Future Enhancements
- Adding authentication for users.
- Implementing integration with Telegram API.
- Supporting additional contact fields like profile pictures and status.

---
This document serves as the foundation for implementing the Telegram contacts management system using **Spring Framework** and **PostgreSQL**.

