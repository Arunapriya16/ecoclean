# EcoClean - Environmental Cleanliness & Complaint Tracking Backend

##  Problem Statement
Traditional methods of reporting environmental hazards, illegal dumping, and tracking community waste management rely on manual oversight.
This leads to slow response times, lost data, and a complete lack of accountability between citizens and cleaning authorities.

##  Solutions & Features Provided
This project provides a robust, enterprise-ready REST API built to automate municipal cleanup workflows:
* **User Management System:** Handles user onboarding, roles, and profile secure tracking (`UserController`, `UserService`).
* **Automated Email Notifications:** Features an integrated system to send automated confirmation alerts upon registration or task updates (`EmailService`).
* **Complaint Lifecycle Management:** Allows citizens to log environmental issues, 
 which are systematically assigned, updated, and tracked through to resolution (`ComplaintService`, `ComplaintRepository`).
* **Optimized Data Architecture:** Implements a decoupled architecture using Data Transfer Objects (`UserDTO`) to ensure clean separation of concerns and safe data exposure.

##  Tech Stack Used
* **Backend Framework:** Java Spring Boot
* **Build & Dependency Management:** Maven (`pom.xml`)
* **Database Layer:** Spring Data JPA with an H2 Relational Database Model
* **Testing:** JUnit & Spring Boot Test Suite

##  Core Code Structure Breakdown
The project is built using a strict architectural pattern:
* `controller/` - Exposes the secure REST API endpoints for users and complaints.
* `service/` - Contains the core business logic (Email delivery, business rules verification).
* `repository/` - Connects directly to the relational database using JPA queries.
* `entity/` - Defines the database schema models for Users and Complaints.
* `dto/` - Minimizes payload sizes and secures core system entities.
