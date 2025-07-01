# 🛠️ Complaint Management System (Spring Boot)

A simple Complaint Management System built using **Spring Boot**, where customers can raise complaints and admin can manage them. This project demonstrates REST API design, enum-based status tracking, and proper service-layer logic.

---

## 🚀 Features

- Raise a new complaint
- View all complaints
- Get a complaint by ID
- Update the status of a complaint (`OPEN → IN_PROGRESS → RESOLVED`)
- Auto-track complaint resolution time
- Get count of complaints by status

---

## 🧱 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Maven
- REST APIs

---

## 🗂️ Project Structure
src
├── main
│ ├── java
│ │ └── com.flynaut.assignments.Complaint.Management.System
│ │ ├── controller # REST API controllers
│ │ ├── service # Service layer and interface
│ │ ├── repo # Repository layer (JpaRepository)
│ │ ├── entity # Entity classes (Complaint.java)
│ │ ├── enums # Enum for ComplaintStatus
│ │ └── ComplaintManagementSystemApplication.java
│ └── resources
│ ├── application.yml / application.properties
│ 

## 🔧 API Endpoints
### 📋 Get All Complaints
GET /api/complaints
### 🔍 Get Complaint by ID
GET /api/complaints/{id}
### 🔄 Update Complaint Status
PUT /api/complaints/{id}/status?status=IN_PROGRESS
### 📊 Get Complaint Count by Status
GET /api/complaints/status-count


### ➕ Raise Complaint
POST /api/complaints
RequestBody:
{
"customerName": "John Doe",
"issueDescription": "My internet is down"
}

### 🗃️ Database
Uses H2 in-memory database (no installation needed).

Accessible at:

http://localhost:8080/h2-console
Default settings (configured in application.properties):


spring.datasource.url=jdbc:h2:mem:ComplaintManagementSystem
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
