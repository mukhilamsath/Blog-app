Social Blog App - Spring Boot Blogging Platform
Social Blog App is a full-stack social blogging web application built using Spring Boot 3, MySQL, and Thymeleaf. It provides a modern, Instagram-inspired interface where users can share articles with images, follow other creators, and engage with content through likes and comments.

🚀 Features
User Management: Register and view user profiles with custom bios and avatars.

Social Feed: A personalized feed that displays posts from users you follow, as well as a global "Explore" feed.

Post Creation: Create media-rich posts including a title, subtitle, body content, and image uploads.

Engagement: Interactive "Like" system with real-time count updates using AJAX.

Commenting System: Dedicated comment sections for each article to foster discussion.

Follow System: Follow and unfollow functionality to curate your personal feed.

Image Storage: Local file system storage for uploaded post images with dynamic resource handling.

🛠️ Tech Stack
Backend: Java 17, Spring Boot 3.5.0.

Database: MySQL.

ORM: Spring Data JPA / Hibernate.

Security: Spring Security.

Frontend: Thymeleaf, HTML5, CSS3 (Inter/Instagram Sans fonts), and Bootstrap 5.

Build Tool: Maven.

📋 Prerequisites
Java Development Kit (JDK) 17 or higher.

MySQL Server.

Maven (or use the provided Maven Wrapper ./mvnw).

🔧 Configuration
Database Setup: Create a database named jpa in your MySQL instance.

Application Properties: Update src/main/resources/application.properties with your MySQL credentials:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpa
spring.datasource.username=your_username
spring.datasource.password=your_password
Default Credentials: The application includes a default security user:

Username: mukhil

Password: 0000

🏃 How to Run
Clone the repository.

Navigate to the project root directory.

Run the application using the Maven Wrapper:

Windows: mvnw.cmd spring-boot:run

Linux/macOS: ./mvnw spring-boot:run

Open your browser and navigate to http://localhost:8081.

📂 Project Structure
com.example.demo.Article: Manages post creation, feeds, and likes.

com.example.demo.user: Handles user registration, profiles, and following logic.

com.example.demo.Comment: Handles the commenting system.

com.example.demo.config: Contains file storage and MVC resource configurations.

src/main/resources/templates: Thymeleaf templates for the UI.
