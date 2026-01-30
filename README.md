# 📝 Blog Management System

A complete RESTful API for managing blog posts built with Spring Boot, MySQL, and Swagger documentation.

## 🚀 Features

- ✅ Complete CRUD operations for blog posts
- ✅ Search functionality (by title, author, category)
- ✅ Published/Draft status management
- ✅ Swagger UI documentation
- ✅ MySQL database integration
- ✅ Input validation
- ✅ RESTful API design
- ✅ Timestamps (created_at, updated_at)

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.2.1
- **Database**: MySQL 8.0
- **Documentation**: Swagger/OpenAPI 3.0
- **Build Tool**: Maven
- **Java Version**: 17

## 📋 API Endpoints

### Blog Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/blogs` | Get all blogs |
| GET | `/api/blogs/{id}` | Get blog by ID |
| GET | `/api/blogs/published` | Get published blogs |
| GET | `/api/blogs/search/title?title={keyword}` | Search by title |
| GET | `/api/blogs/search/author?author={name}` | Search by author |
| GET | `/api/blogs/search/category?category={name}` | Search by category |
| POST | `/api/blogs` | Create new blog |
| PUT | `/api/blogs/{id}` | Update blog |
| DELETE | `/api/blogs/{id}` | Delete blog |
| DELETE | `/api/blogs` | Delete all blogs |

## 🔧 Local Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

### Installation Steps

1. **Clone the repository**
```bash
git clone https://github.com/rahul700raj/blog-management-system.git
cd blog-management-system
```

2. **Configure MySQL Database**
```sql
CREATE DATABASE blogdb;
```

3. **Update application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. **Build and Run**
```bash
mvn clean install
mvn spring-boot:run
```

5. **Access the application**
- API Base URL: `http://localhost:8080/api/blogs`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- API Docs: `http://localhost:8080/api-docs`

## 📚 Swagger Documentation

Access interactive API documentation at:
```
http://localhost:8080/swagger-ui.html
```

## 🌐 Deployment

### Render Deployment

This application is configured for easy deployment on Render.com:

1. Connect your GitHub repository to Render
2. Set environment variables:
   - `DATABASE_URL`: Your MySQL connection string
   - `DB_USERNAME`: Database username
   - `DB_PASSWORD`: Database password
3. Deploy!

## 📦 Sample Blog Object

```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my blog post...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, rest-api",
  "published": true
}
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📧 Contact

**Rahul Mishra**
- Email: rm2778643@gmail.com
- GitHub: [@rahul700raj](https://github.com/rahul700raj)

## 📄 License

This project is open source and available under the MIT License.

---

Made with ❤️ by Rahul Mishra