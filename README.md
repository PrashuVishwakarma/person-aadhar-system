# Person Aadhar System

A Spring Boot REST API for managing person details and Aadhar records with MySQL.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API

## Prerequisites
- Java 17+
- MySQL
- Maven

## Setup & Installation

### 1. Clone the repository
```bash
git clone https://github.com/your-username/person-aadhar-system.git
cd person-aadhar-system
```

### 2. Create Database
```sql
CREATE DATABASE person_aadhar_db;
```

### 3. Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/person_aadhar_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4. Run the project
```bash
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/persons | Get all persons |
| GET | /api/persons/{id} | Get person by ID |
| POST | /api/persons | Create new person |
| PUT | /api/persons/{id} | Update person |
| DELETE | /api/persons/{id} | Delete person |
| GET | /api/persons/aadhar/{aadharNo} | Search by Aadhar |

## Author
Your Name - [GitHub](https://github.com/prashu-vishwakarma)
