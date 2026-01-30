# 🐳 Docker Deployment Guide

Run the Blog Management System using Docker and Docker Compose.

## 📋 Prerequisites

- Docker 20.10+
- Docker Compose 2.0+

## 🚀 Quick Start with Docker Compose

### 1. Clone Repository
```bash
git clone https://github.com/rahul700raj/blog-management-system.git
cd blog-management-system
```

### 2. Start Everything
```bash
docker-compose up -d
```

This will:
- ✅ Pull MySQL 8.0 image
- ✅ Build Spring Boot application
- ✅ Create network and volumes
- ✅ Start both containers

### 3. Access Application
```
🌐 Application: http://localhost:8080
📚 Swagger UI: http://localhost:8080/swagger-ui.html
🔗 API: http://localhost:8080/api/blogs
```

### 4. View Logs
```bash
# All services
docker-compose logs -f

# Only app
docker-compose logs -f app

# Only database
docker-compose logs -f mysql
```

### 5. Stop Everything
```bash
docker-compose down

# Remove volumes too
docker-compose down -v
```

---

## 🔧 Manual Docker Build

### Build Image
```bash
docker build -t blog-management-system:latest .
```

### Run with H2 (In-Memory Database)
```bash
docker run -d \
  --name blog-app \
  -p 8080:8080 \
  blog-management-system:latest
```

### Run with External MySQL
```bash
docker run -d \
  --name blog-app \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/blogdb \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=password \
  blog-management-system:latest
```

---

## 🎯 Docker Compose Configuration

### Default Configuration
```yaml
services:
  mysql:
    - Port: 3306
    - Database: blogdb
    - User: bloguser
    - Password: blogpassword
  
  app:
    - Port: 8080
    - Auto-restart: yes
    - Health checks: enabled
```

### Custom Configuration

Create `.env` file:
```env
MYSQL_ROOT_PASSWORD=your_root_password
MYSQL_DATABASE=blogdb
MYSQL_USER=your_user
MYSQL_PASSWORD=your_password
SERVER_PORT=8080
```

Update `docker-compose.yml`:
```yaml
environment:
  MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
  MYSQL_DATABASE: ${MYSQL_DATABASE}
```

---

## 📊 Container Management

### Check Status
```bash
docker-compose ps
```

### Restart Services
```bash
# Restart all
docker-compose restart

# Restart app only
docker-compose restart app
```

### Update Application
```bash
# Rebuild and restart
docker-compose up -d --build app
```

### Access Container Shell
```bash
# App container
docker exec -it blog-app sh

# MySQL container
docker exec -it blog-mysql mysql -u bloguser -p
```

---

## 🔍 Troubleshooting

### Port Already in Use
```bash
# Change port in docker-compose.yml
ports:
  - "9090:8080"  # Use 9090 instead
```

### Database Connection Failed
```bash
# Check MySQL is ready
docker-compose logs mysql

# Wait for health check
docker-compose ps
```

### Application Won't Start
```bash
# Check logs
docker-compose logs app

# Rebuild image
docker-compose build --no-cache app
docker-compose up -d
```

### Clean Everything
```bash
# Stop and remove everything
docker-compose down -v --rmi all

# Remove unused Docker resources
docker system prune -a
```

---

## 🚀 Production Deployment

### Build Optimized Image
```bash
docker build \
  --build-arg MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1" \
  -t blog-management-system:prod .
```

### Run in Production Mode
```yaml
# docker-compose.prod.yml
services:
  app:
    environment:
      SPRING_PROFILES_ACTIVE: prod
      JAVA_OPTS: "-Xms512m -Xmx1024m"
    restart: always
```

```bash
docker-compose -f docker-compose.prod.yml up -d
```

---

## 📦 Push to Docker Hub

### Tag Image
```bash
docker tag blog-management-system:latest yourusername/blog-management-system:latest
```

### Push to Registry
```bash
docker login
docker push yourusername/blog-management-system:latest
```

### Pull and Run
```bash
docker pull yourusername/blog-management-system:latest
docker run -d -p 8080:8080 yourusername/blog-management-system:latest
```

---

## 🎓 Advanced Usage

### Scale Application
```bash
docker-compose up -d --scale app=3
```

### Use External Database
```yaml
services:
  app:
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://external-db.example.com:3306/blogdb
```

### Add Redis Cache
```yaml
services:
  redis:
    image: redis:alpine
    ports:
      - "6379:6379"
```

---

## 📊 Monitoring

### Resource Usage
```bash
docker stats blog-app blog-mysql
```

### Health Check
```bash
curl http://localhost:8080/actuator/health
```

### Database Backup
```bash
docker exec blog-mysql mysqldump -u bloguser -pblogpassword blogdb > backup.sql
```

### Database Restore
```bash
docker exec -i blog-mysql mysql -u bloguser -pblogpassword blogdb < backup.sql
```

---

## 🔐 Security Best Practices

1. **Use secrets for passwords**
```yaml
secrets:
  db_password:
    file: ./secrets/db_password.txt
```

2. **Run as non-root user**
```dockerfile
USER 1000:1000
```

3. **Scan for vulnerabilities**
```bash
docker scan blog-management-system:latest
```

---

## 📚 Additional Resources

- [Docker Documentation](https://docs.docker.com/)
- [Docker Compose Documentation](https://docs.docker.com/compose/)
- [Spring Boot Docker Guide](https://spring.io/guides/gs/spring-boot-docker/)

---

**Happy Dockerizing! 🐳**