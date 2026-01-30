# ⚡ Quick Start Guide

Get your Blog Management System up and running in 5 minutes!

## 🎯 Option 1: Deploy to Render (Recommended)

### Step 1: Fork/Clone Repository
```bash
git clone https://github.com/rahul700raj/blog-management-system.git
```

### Step 2: Deploy to Render
1. Go to [Render.com](https://render.com) and sign up
2. Click **"New +"** → **"Web Service"**
3. Connect GitHub repository: `rahul700raj/blog-management-system`
4. Configure:
   - **Name**: `blog-management-system`
   - **Runtime**: Java
   - **Build Command**: `mvn clean install -DskipTests`
   - **Start Command**: `java -jar target/blog-management-system-1.0.0.jar`

### Step 3: Add Database (Optional - uses H2 by default)
For production MySQL:
1. Create MySQL database on Render
2. Add environment variables:
   ```
   DATABASE_URL=jdbc:mysql://your-host:3306/blogdb
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

### Step 4: Access Your API
```
🌐 App: https://your-app.onrender.com
📚 Swagger: https://your-app.onrender.com/swagger-ui.html
🔗 API: https://your-app.onrender.com/api/blogs
```

---

## 💻 Option 2: Run Locally

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+ (optional, uses H2 by default)

### Quick Setup

```bash
# 1. Clone repository
git clone https://github.com/rahul700raj/blog-management-system.git
cd blog-management-system

# 2. Build project
mvn clean install

# 3. Run application
mvn spring-boot:run
```

### Access Locally
```
🌐 App: http://localhost:8080
📚 Swagger: http://localhost:8080/swagger-ui.html
🔗 API: http://localhost:8080/api/blogs
```

---

## 🧪 Test Your API

### Using Swagger UI (Easiest)
1. Open: `http://localhost:8080/swagger-ui.html`
2. Click on any endpoint
3. Click **"Try it out"**
4. Fill in parameters
5. Click **"Execute"**

### Using cURL

**Create a blog:**
```bash
curl -X POST http://localhost:8080/api/blogs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My First Blog",
    "content": "Hello World!",
    "author": "Your Name",
    "published": true
  }'
```

**Get all blogs:**
```bash
curl http://localhost:8080/api/blogs
```

### Using Postman
1. Import: `postman_collection.json`
2. Set base_url: `http://localhost:8080`
3. Run requests!

---

## 📱 Connect Mobile App

### Android (Retrofit)
```kotlin
val retrofit = Retrofit.Builder()
    .baseUrl("https://your-app.onrender.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface BlogApi {
    @GET("api/blogs")
    suspend fun getBlogs(): List<Blog>
}
```

### iOS (URLSession)
```swift
let url = URL(string: "https://your-app.onrender.com/api/blogs")!
URLSession.shared.dataTask(with: url) { data, response, error in
    // Handle response
}.resume()
```

### React/JavaScript
```javascript
fetch('https://your-app.onrender.com/api/blogs')
  .then(response => response.json())
  .then(data => console.log(data));
```

---

## 🔧 Configuration

### Use MySQL Instead of H2

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=your_password
```

### Change Port
```properties
server.port=9090
```

### Enable CORS for Specific Domain
```properties
# In BlogController.java
@CrossOrigin(origins = "https://your-frontend.com")
```

---

## 📚 API Endpoints Summary

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/blogs` | Get all blogs |
| GET | `/api/blogs/{id}` | Get blog by ID |
| GET | `/api/blogs/published` | Get published blogs |
| GET | `/api/blogs/search/title?title=X` | Search by title |
| POST | `/api/blogs` | Create blog |
| PUT | `/api/blogs/{id}` | Update blog |
| DELETE | `/api/blogs/{id}` | Delete blog |

---

## 🎓 Next Steps

1. ✅ **Customize**: Modify models, add fields
2. ✅ **Secure**: Add Spring Security
3. ✅ **Enhance**: Add pagination, sorting
4. ✅ **Deploy**: Push to production
5. ✅ **Monitor**: Add logging, metrics

---

## 🆘 Troubleshooting

### Port already in use
```bash
# Change port in application.properties
server.port=9090
```

### Database connection failed
```bash
# Check MySQL is running
sudo systemctl status mysql

# Or use H2 (in-memory)
# Comment out MySQL config in application.properties
```

### Build failed
```bash
# Clean and rebuild
mvn clean install -U
```

---

## 📞 Need Help?

- 📖 **Full Documentation**: [README.md](README.md)
- 🚀 **Deployment Guide**: [DEPLOYMENT.md](DEPLOYMENT.md)
- 🧪 **API Examples**: [API_EXAMPLES.md](API_EXAMPLES.md)
- 📧 **Contact**: rm2778643@gmail.com
- 🐛 **Issues**: [GitHub Issues](https://github.com/rahul700raj/blog-management-system/issues)

---

**That's it! You're ready to build amazing blog applications! 🚀**