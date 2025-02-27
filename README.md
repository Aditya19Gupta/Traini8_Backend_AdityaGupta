# Traini8

## 📌 Project Overview
This project is a Spring Boot application that provides APIs for managing training centers. It includes functionalities to:
- **Create and save** training center details.
- **Retrieve a list** of all stored training centers.

## 🛠️ Prerequisites
Ensure you have the following installed on your system:
- **Java 17+** (Ensure JAVA_HOME is set)
- **Maven 3+** (For dependency management)
- **MySQL 8+** (Database)
- **Postman or cURL** (For API testing, optional)
- **Spring Boot 3+** (Embedded in Maven dependencies)

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```sh
 git clone https://github.com/your-username/training-center.git
 cd training-center
```

### 2️⃣ Configure Database
- Open `src/main/resources/application.properties`.
- Update the database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build and Run the Application
- Use Maven to build and start the project.

```sh
mvn clean install
mvn spring-boot:run
```

OR, if using an IDE like **IntelliJ** or **Eclipse**, run the `TrainingCenterApplication.java` main class.

### 4️⃣ API Endpoints

#### 📝 **Create Training Center**
- **Method:** `POST`
- **URL:** `/save-training-center`
- **Request Body (JSON):**

```json
{
  "centerName": "Tech Academy",
  "centerCode": "TCH20240001",
  "address": {
    "detailedAddress": "123, Tech Street",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "React"],
  "contactEmail": "info@techacademy.com",
  "contactPhone": "1234567890"
}
```
- **Response (Success):**
```json
{
  "success": true,
  "message": "Successfully Saved!!"
}
```

#### 📋 **Get All Training Centers**
- **Method:** `GET`
- **URL:** `/get-all-training-centers`
- **Response (Example):**

```json
[
  {
    "centerName": "Tech Academy",
    "centerCode": "TCH20240001",
    "address": {
      "detailedAddress": "123, Tech Street",
      "city": "New York",
      "state": "NY",
      "pincode": "10001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot", "React"],
    "contactEmail": "info@techacademy.com",
    "contactPhone": "1234567890",
    "createdOn": 1708476000
  }
]
```

## 🛠️ Database Setup (MySQL)
Execute the following SQL queries in MySQL:

```sql
CREATE DATABASE training_center_db;

USE training_center_db;

CREATE TABLE training_center (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    center_name VARCHAR(40) NOT NULL,
    center_code CHAR(12) NOT NULL UNIQUE,
    student_capacity INT,
    contact_email VARCHAR(100),
    contact_phone VARCHAR(15) NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    detailed_address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10)
);

CREATE TABLE training_center_courses (
    center_id BIGINT,
    course VARCHAR(100),
    FOREIGN KEY (center_id) REFERENCES training_center(id) ON DELETE CASCADE
);
```


