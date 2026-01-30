# 📡 API Testing Examples

Complete guide to test all API endpoints with sample requests and responses.

## 🔗 Base URL
```
Local: http://localhost:8080/api/blogs
Production: https://your-app.onrender.com/api/blogs
```

---

## 1️⃣ Create a New Blog Post

**Endpoint:** `POST /api/blogs`

**Request:**
```bash
curl -X POST http://localhost:8080/api/blogs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Getting Started with Spring Boot",
    "content": "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications...",
    "author": "Rahul Mishra",
    "category": "Technology",
    "tags": "spring-boot, java, backend",
    "published": true
  }'
```

**Response (201 Created):**
```json
{
  "id": 1,
  "title": "Getting Started with Spring Boot",
  "content": "Spring Boot makes it easy to create stand-alone...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, backend",
  "published": true,
  "createdAt": "2024-01-30T10:30:00",
  "updatedAt": "2024-01-30T10:30:00"
}
```

---

## 2️⃣ Get All Blogs

**Endpoint:** `GET /api/blogs`

**Request:**
```bash
curl http://localhost:8080/api/blogs
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Getting Started with Spring Boot",
    "author": "Rahul Mishra",
    "category": "Technology",
    "published": true,
    "createdAt": "2024-01-30T10:30:00"
  },
  {
    "id": 2,
    "title": "Understanding REST APIs",
    "author": "John Doe",
    "category": "Web Development",
    "published": true,
    "createdAt": "2024-01-30T11:00:00"
  }
]
```

---

## 3️⃣ Get Blog by ID

**Endpoint:** `GET /api/blogs/{id}`

**Request:**
```bash
curl http://localhost:8080/api/blogs/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "title": "Getting Started with Spring Boot",
  "content": "Spring Boot makes it easy...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, backend",
  "published": true,
  "createdAt": "2024-01-30T10:30:00",
  "updatedAt": "2024-01-30T10:30:00"
}
```

---

## 4️⃣ Get Published Blogs Only

**Endpoint:** `GET /api/blogs/published`

**Request:**
```bash
curl http://localhost:8080/api/blogs/published
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Getting Started with Spring Boot",
    "author": "Rahul Mishra",
    "published": true
  }
]
```

---

## 5️⃣ Search Blogs by Title

**Endpoint:** `GET /api/blogs/search/title?title={keyword}`

**Request:**
```bash
curl "http://localhost:8080/api/blogs/search/title?title=Spring"
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Getting Started with Spring Boot",
    "author": "Rahul Mishra",
    "category": "Technology"
  }
]
```

---

## 6️⃣ Search Blogs by Author

**Endpoint:** `GET /api/blogs/search/author?author={name}`

**Request:**
```bash
curl "http://localhost:8080/api/blogs/search/author?author=Rahul"
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Getting Started with Spring Boot",
    "author": "Rahul Mishra",
    "category": "Technology"
  }
]
```

---

## 7️⃣ Search Blogs by Category

**Endpoint:** `GET /api/blogs/search/category?category={name}`

**Request:**
```bash
curl "http://localhost:8080/api/blogs/search/category?category=Technology"
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "Getting Started with Spring Boot",
    "author": "Rahul Mishra",
    "category": "Technology"
  }
]
```

---

## 8️⃣ Update a Blog Post

**Endpoint:** `PUT /api/blogs/{id}`

**Request:**
```bash
curl -X PUT http://localhost:8080/api/blogs/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Getting Started with Spring Boot - Updated",
    "content": "Updated content here...",
    "author": "Rahul Mishra",
    "category": "Technology",
    "tags": "spring-boot, java, backend, updated",
    "published": true
  }'
```

**Response (200 OK):**
```json
{
  "id": 1,
  "title": "Getting Started with Spring Boot - Updated",
  "content": "Updated content here...",
  "author": "Rahul Mishra",
  "category": "Technology",
  "tags": "spring-boot, java, backend, updated",
  "published": true,
  "createdAt": "2024-01-30T10:30:00",
  "updatedAt": "2024-01-30T12:00:00"
}
```

---

## 9️⃣ Delete a Blog Post

**Endpoint:** `DELETE /api/blogs/{id}`

**Request:**
```bash
curl -X DELETE http://localhost:8080/api/blogs/1
```

**Response (204 No Content)**

---

## 🔟 Delete All Blogs

**Endpoint:** `DELETE /api/blogs`

**Request:**
```bash
curl -X DELETE http://localhost:8080/api/blogs
```

**Response (204 No Content)**

---

## 🧪 Testing with Postman

### Import Collection

1. Open Postman
2. Click **Import**
3. Select **Link** tab
4. Paste: `https://github.com/rahul700raj/blog-management-system`
5. Or manually create requests using examples above

### Environment Variables

Create a Postman environment:
```json
{
  "base_url": "http://localhost:8080",
  "blog_id": "1"
}
```

---

## 📱 Testing with Mobile Apps

### Android (Retrofit/OkHttp)
```kotlin
interface BlogApi {
    @GET("api/blogs")
    suspend fun getAllBlogs(): List<Blog>
    
    @POST("api/blogs")
    suspend fun createBlog(@Body blog: Blog): Blog
}
```

### iOS (URLSession)
```swift
let url = URL(string: "https://your-app.onrender.com/api/blogs")!
let task = URLSession.shared.dataTask(with: url) { data, response, error in
    // Handle response
}
task.resume()
```

---

## ⚠️ Error Responses

### 400 Bad Request
```json
{
  "timestamp": "2024-01-30T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Title is required"
}
```

### 404 Not Found
```json
{
  "timestamp": "2024-01-30T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Blog not found with id: 999"
}
```

---

## 🎯 Quick Test Script

Save as `test-api.sh`:
```bash
#!/bin/bash

BASE_URL="http://localhost:8080/api/blogs"

echo "1. Creating a blog..."
curl -X POST $BASE_URL \
  -H "Content-Type: application/json" \
  -d '{"title":"Test Blog","content":"Test content","author":"Tester","published":true}'

echo "\n\n2. Getting all blogs..."
curl $BASE_URL

echo "\n\n3. Searching by title..."
curl "$BASE_URL/search/title?title=Test"

echo "\n\nTests completed!"
```

Run: `chmod +x test-api.sh && ./test-api.sh`

---

## 📚 Additional Resources

- **Swagger UI**: `/swagger-ui.html`
- **API Docs**: `/api-docs`
- **GitHub**: https://github.com/rahul700raj/blog-management-system

---

Happy Testing! 🚀