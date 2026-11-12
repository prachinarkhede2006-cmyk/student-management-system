# Student Management System

Full-stack beginner project: **HTML/CSS/JavaScript frontend + Java 17/Spring Boot REST backend + MySQL database**.

## Features
- Add, list, edit and delete student records
- REST API CRUD endpoints
- Email validation and duplicate-email protection
- Responsive browser interface
- Postman collection included

## Project structure
```text
student-management-system/
├── pom.xml
├── README.md
├── postman/Student-Management.postman_collection.json
└── src/main/
    ├── java/com/example/studentmanagement/
    │   ├── StudentManagementApplication.java
    │   ├── controller/StudentController.java
    │   ├── model/Student.java
    │   ├── repository/StudentRepository.java
    │   └── service/StudentService.java
    └── resources/
        ├── application.properties
        └── static/
            ├── index.html
            ├── style.css
            └── app.js
```

## Requirements
- JDK 17+
- Maven 3.6+
- MySQL Server
- Postman (optional)

## Database setup
Start MySQL and execute:
```sql
CREATE DATABASE student_db;
```
Default connection is `localhost:3306`, database `student_db`, username `root`, blank password. Set environment variables `DB_USERNAME` and `DB_PASSWORD` if your credentials differ. You may also override `DB_URL`. Never commit real credentials to GitHub.

## Run
From the project root:
```bash
mvn spring-boot:run
```
Open http://localhost:8080. Spring Boot serves the frontend and API from the same server.

To build a runnable JAR:
```bash
mvn clean package
java -jar target/student-management-system-1.0.0.jar
```

## REST API
Base URL: `http://localhost:8080/api/students`

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/students` | List all students |
| GET | `/api/students/{id}` | Get one student |
| POST | `/api/students` | Add a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

POST/PUT JSON example:
```json
{
  "name": "Aditi Sharma",
  "email": "aditi@example.com",
  "course": "Computer Engineering"
}
```

## Postman testing
1. Run the Spring Boot application.
2. In Postman, choose Import.
3. Select `postman/Student-Management.postman_collection.json`.
4. Send the requests. For POST/PUT, the collection includes sample JSON.
5. Expected responses: GET 200, POST 201, PUT 200, DELETE 204. Missing ID returns 404, duplicate email 409, invalid data 400.

## Upload to GitHub
1. Create a new empty repository on GitHub named `student-management-system`.
2. Extract this ZIP and open a terminal in the extracted folder.
3. Replace `YOUR-USERNAME` below with your GitHub username and run:
```bash
git init
git add .
git commit -m "Initial commit: Student Management System"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/student-management-system.git
git push -u origin main
```
4. Refresh the GitHub repository page.

## Important
This is an educational starter project. It does not yet include login/authentication, role permissions, deployment or production-grade security. Keep passwords and secrets out of source control.
