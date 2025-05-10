School Vaccination Portal
README (GitHub Repository)
A full-stack web application to manage student vaccination drives in a school. Developed as part of FSAD Assignment.
Tech Stack
- Frontend: React Admin (React.js)
- Backend: Spring Boot (Java)
- Database: MySQL
Features
- Admin login with dashboard overview
- Manage students: Add/Edit/Delete + CSV upload
- Schedule and manage vaccination drives
- View vaccination statistics and reports
- Export vaccination data
Folder Structure
/frontend         # React Admin (Vite)
/backend          # Spring Boot app
Setup Instructions
Backend (Spring Boot):
cd backend
./mvnw spring-boot:run
Frontend (React Admin):
cd frontend
npm install
npm run dev
Ensure MySQL is running and schema is created as per `docs`.
Backend URL: http://localhost:8086
Frontend URL: http://localhost:5173
API Endpoints
Method	Endpoint	Description
POST	/login	Coordinator login
GET	/students	List students
POST	/students/upload	Upload CSV
GET	/api/dashboard	Dashboard overview
GET	/drives	List all vaccination drives
POST	/drives	Schedule new drive
PUT	/drives/{id}	Edit an existing drive
DB Schema
Refer to main documentation for full SQL DDL.
Snapshots
UI screenshots and Postman API responses included in documentation folder.
Demo Video
Google Drive Link: [add your link here]
Author
Name: Siddhant Sehgal- 93215TM@2024 
Course: SE ZG503 FSAD II SEM 2024-2025
