# 📝 Blog Management System

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.1-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Build](https://img.shields.io/badge/Build-Passing-success)

**A complete RESTful API for managing blog posts built with Spring Boot, MySQL, and Swagger documentation.**

[Features](#-features) • [Quick Start](#-quick-start) • [API Docs](#-api-endpoints) • [Deployment](#-deployment) • [Contributing](#-contributing)

</div>

---

## 🚀 Features

<table>
<tr>
<td>

### Core Features
- ✅ Complete CRUD operations
- ✅ Advanced search (title, author, category)
- ✅ Published/Draft status
- ✅ Auto timestamps
- ✅ Input validation
- ✅ Error handling

</td>
<td>

### Technical Features
- ✅ RESTful API design
- ✅ Swagger UI documentation
- ✅ MySQL integration
- ✅ Docker support
- ✅ CI/CD pipeline
- ✅ CORS enabled

</td>
</tr>
</table>

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Spring Boot** | 3.2.1 | Backend Framework |
| **Java** | 17 | Programming Language |
| **MySQL** | 8.0 | Database |
| **Maven** | 3.9+ | Build Tool |
| **Swagger** | 3.0 | API Documentation |
| **Docker** | 20.10+ | Containerization |

---

## ⚡ Quick Start

### Option 1: Docker (Recommended)
```bash
# Clone repository
git clone https://github.com/rahul700raj/blog-management-system.git
cd blog-management-system

# Start with Docker Compose
docker-compose up -d

# Access application
open http://localhost:8080/swagger-ui.html
```

### Option 2: Local Development
```bash
# Prerequisites: Java 17+, Maven 3.6+

# Clone and build
git clone https://github.com/rahul700raj/blog-management-system.git
cd blog-management-system
mvn clean install

# Run application
mvn spring-boot:run

# Access at http://localhost:8080
```

### Option 3: Deploy to Render
[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com)

See [DEPLOYMENT.md](DEPLOYMENT.md) for detailed instructions.

---

## 📡 API Endpoints

### Blog Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| 🟢 GET | `/api/blogs` | Get all blogs |
| 🟢 GET | `/api/blogs/{id}` | Get blog by ID |
| 🟢 GET | `/api/blogs/published` | Get published blogs |
| 🟢 GET | `/api/blogs/search/title?title={keyword}` | Search by title |
| 🟢 GET | `/api/blogs/search/author?author={name}` | Search by author |
| 🟢 GET | `/api/blogs/search/category?category={name}` | Search by category |
| 🔵 POST | `/api/blogs` | Create new blog |
| 🟡 PUT | `/api/blogs/{id}` | Update blog |
| 🔴 DELETE | `/api/blogs/{id}` | Delete blog |
| 🔴 DELETE | `/api/blogs` | Delete all blogs |

### Documentation Endpoints

| Endpoint | Description |
|----------|-------------|
| `/swagger-ui.html` | Interactive API documentation |
| `/api-docs` | OpenAPI JSON specification |

---

## 📚 Documentation

| Document | Description |
|----------|-------------|
| [QUICKSTART.md](QUICKSTART.md) | 5-minute setup guide |
| [DEPLOYMENT.md](DEPLOYMENT.md) | Render deployment guide |
| [API_EXAMPLES.md](API_EXAMPLES.md) | Complete API testing examples |
| [DOCKER.md](DOCKER.md) | Docker deployment guide |
| [CONTRIBUTING.md](CONTRIBUTING.md) | Contribution guidelines |
| [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md) | Complete project overview |

---

## 🧪 Testing

### Using Swagger UI (Easiest)
1. Open `http://localhost:8080/swagger-ui.html`
2. Click on any endpoint
3. Click "Try it out"
4. Execute!

### Using cURL
```bash
# Create a blog
curl -X POST http://localhost:8080/api/blogs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My First Blog",
    "content": "This is my first blog post!",
    "author": "Rahul Mishra",
    "category": "Technology",
    "published": true
  }'

# Get all blogs
curl http://localhost:8080/api/blogs
```

### Using Postman
Import `postman_collection.json` from the repository.

---

## 🌐 Deployment

### Render.com (Free Tier)
1. Fork this repository
2. Sign up at [Render.com](https://render.com)
3. Create new Web Service
4. Connect your GitHub repository
5. Deploy!

**Your URLs:**
```
🌐 App: https://your-app.onrender.com
📚 Swagger: https://your-app.onrender.com/swagger-ui.html
🔗 API: https://your-app.onrender.com/api/blogs
```

See [DEPLOYMENT.md](DEPLOYMENT.md) for detailed instructions.

### Docker Hub
```bash
docker pull rahul700raj/blog-management-system:latest
docker run -p 8080:8080 rahul700raj/blog-management-system:latest
```

---

## 📦 Sample Blog Object

```json
{
  "title": "Getting Started with Spring Boot",
  "content": "Spring Boot makes it easy to create stand-alone applications...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, rest-api",
  "published": true
}
```

**Response:**
```json
{
  "id": 1,
  "title": "Getting Started with Spring Boot",
  "content": "Spring Boot makes it easy...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, rest-api",
  "published": true,
  "createdAt": "2024-01-30T10:30:00",
  "updatedAt": "2024-01-30T10:30:00"
}
```

---

## 🔧 Configuration

### Database Configuration
Edit `src/main/resources/application.properties`:

```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=your_username
spring.datasource.password=your_password

# H2 In-Memory Database (for testing)
# spring.datasource.url=jdbc:h2:mem:testdb
```

### Environment Variables (Production)
```bash
DATABASE_URL=jdbc:mysql://host:3306/blogdb
DB_USERNAME=your_username
DB_PASSWORD=your_password
PORT=8080
```

---

## 🏗️ Project Structure

```
blog-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/blog/
│   │   │   ├── BlogManagementSystemApplication.java
│   │   │   ├── controller/
│   │   │   │   └── BlogController.java
│   │   │   ├── model/
│   │   │   │   └── Blog.java
│   │   │   ├── repository/
│   │   │   │   └── BlogRepository.java
│   │   │   └── service/
│   │   │       └── BlogService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details.

### Quick Contribution Steps
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📱 Mobile App Integration

### Android (Kotlin)
```kotlin
interface BlogApi {
    @GET("api/blogs")
    suspend fun getAllBlogs(): List<Blog>
    
    @POST("api/blogs")
    suspend fun createBlog(@Body blog: Blog): Blog
}
```

### iOS (Swift)
```swift
let url = URL(string: "https://your-app.onrender.com/api/blogs")!
URLSession.shared.dataTask(with: url) { data, response, error in
    // Handle response
}.resume()
```

---

## 🔐 Security

- ✅ Input validation with Bean Validation
- ✅ SQL injection prevention (JPA)
- ✅ CORS configuration
- ✅ Environment variables for sensitive data
- ✅ Prepared statements

---

## 📊 Database Schema

```sql
CREATE TABLE blogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(100) NOT NULL,
    category VARCHAR(100),
    tags VARCHAR(255),
    published BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

---

## 🎯 Roadmap

### Version 2.0 (Planned)
- [ ] User authentication (JWT)
- [ ] Role-based access control
- [ ] Image upload support
- [ ] Comments system
- [ ] Pagination and sorting
- [ ] Full-text search
- [ ] Email notifications

---

## 📞 Support

- 📧 **Email**: rm2778643@gmail.com
- 🐛 **Issues**: [GitHub Issues](https://github.com/rahul700raj/blog-management-system/issues)
- 💬 **Discussions**: [GitHub Discussions](https://github.com/rahul700raj/blog-management-system/discussions)

---

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License - Copyright (c) 2024 Rahul Mishra
```

---

## 🏆 Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Swagger/OpenAPI](https://swagger.io/)
- [Docker](https://www.docker.com/)
- [Render](https://render.com/)

---

## ⭐ Show Your Support

If you find this project helpful, please give it a ⭐ on GitHub!

---

<div align="center">

**Made with ❤️ by [Rahul Mishra](https://github.com/rahul700raj)**

[![GitHub](https://img.shields.io/badge/GitHub-rahul700raj-black?style=flat&logo=github)](https://github.com/rahul700raj)
[![Email](https://img.shields.io/badge/Email-rm2778643@gmail.com-red?style=flat&logo=gmail)](mailto:rm2778643@gmail.com)

</div>