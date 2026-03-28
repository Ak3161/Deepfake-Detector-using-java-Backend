AI Deepfake Detector

⚡ Detect AI-generated media using Spring Boot + AI APIs + Docker + AWS

<p align="center"> <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" /> <img src="https://img.shields.io/badge/SpringBoot-3.x-brightgreen?style=for-the-badge&logo=springboot" /> <img src="https://img.shields.io/badge/React-Frontend-blue?style=for-the-badge&logo=react" /> <img src="https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker" /> <img src="https://img.shields.io/badge/AWS-EC2-yellow?style=for-the-badge&logo=amazonaws" /> </p>
✨ Project Highlights
🔍 Detects AI-generated & deepfake media
🤖 Integrates Sightengine + Gemini AI
⚙️ Built with clean Spring Boot architecture
🐳 Fully Dockerized
☁️ Deployable on AWS EC2
📊 Stores results in MySQL
🖥️ Demo (Add your link here)
🔗 Live Demo: https://your-demo-link.com  
📽️ Demo Video: https://your-video-link.com
🏗️ Architecture Overview
⚙️ Tech Stack
Category	Tech
Backend	Spring Boot
Language	Java 21
Frontend	React
Database	MySQL
AI APIs	Sightengine + Gemini
DevOps	Docker
Cloud	AWS EC2
📂 Project Structure
src/main/java/com/project
│
├── controller      # REST APIs
├── service         # Business logic
├── repository      # DB operations
├── model           # Entities
├── dto             # Data transfer
└── config          # App configs
🔄 Request Flow
User uploads file
      ↓
Controller receives request
      ↓
Service calls AI APIs
      ↓
Verdict calculated
      ↓
Saved in MySQL
      ↓
Response sent to frontend
🧩 Core Feature — Verdict Logic
if (aiScore > 0.7 || deepfakeScore > 0.7) {
    verdict = "LIKELY_FAKE";
} else if (aiScore > 0.4) {
    verdict = "POSSIBLY_FAKE";
} else {
    verdict = "LIKELY_REAL";
}
🌐 API Endpoints
Method	Endpoint	Description
POST	/api/analysis/upload	Upload media
GET	/api/history	Get all results
GET	/api/history/{id}	Get by ID
DELETE	/api/history/{id}	Delete record
🔐 Environment Variables
SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=

SIGHTENGINE_API_USER=
SIGHTENGINE_API_SECRET=

GEMINI_API_KEY=
🐳 Docker Setup
# Build JAR
mvn package -DskipTests

# Run containers
docker-compose up --build

# Run in background
docker-compose up -d
☁️ AWS Deployment
# SSH into EC2
ssh ec2-user@your-ip

# Run app
docker-compose up -d
📸 Screenshots (ADD THESE 🔥)

👉 Add images like:

Upload UI
Result screen
API response
![UI](./screenshots/ui.png)
![Result](./screenshots/result.png)
🧠 What I Learned
Clean Architecture (Controller → Service → Repository)
DTO vs Entity separation
External API integration
Docker & deployment
Real-world backend system design
💼 Why This Project Stands Out
Real-world AI + Backend integration
Production-ready deployment
Demonstrates system design thinking
Covers full backend lifecycle
