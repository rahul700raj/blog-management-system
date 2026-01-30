# 🚀 Deployment Guide - Render.com

## Step-by-Step Deployment Instructions

### 1️⃣ Prerequisites
- GitHub account (already done ✅)
- Render.com account (free tier available)
- MySQL database (we'll set this up on Render)

### 2️⃣ Deploy MySQL Database on Render

1. Go to [Render Dashboard](https://dashboard.render.com/)
2. Click **"New +"** → Select **"PostgreSQL"** (or use external MySQL)
3. Configure:
   - **Name**: `blog-db`
   - **Database**: `blogdb`
   - **User**: (auto-generated)
   - **Region**: Choose closest to you
   - **Plan**: Free
4. Click **"Create Database"**
5. **Save these credentials** (you'll need them):
   - Internal Database URL
   - Username
   - Password

### 3️⃣ Deploy Spring Boot Application

1. Go to [Render Dashboard](https://dashboard.render.com/)
2. Click **"New +"** → Select **"Web Service"**
3. Connect your GitHub repository:
   - Click **"Connect GitHub"**
   - Select: `rahul700raj/blog-management-system`
4. Configure the service:
   - **Name**: `blog-management-system`
   - **Region**: Same as database
   - **Branch**: `main`
   - **Runtime**: `Java`
   - **Build Command**: `mvn clean install -DskipTests`
   - **Start Command**: `java -jar target/blog-management-system-1.0.0.jar`
   - **Plan**: Free

5. **Add Environment Variables**:
   Click **"Advanced"** → **"Add Environment Variable"**
   
   ```
   DATABASE_URL = jdbc:mysql://YOUR_DB_HOST:3306/blogdb
   DB_USERNAME = your_db_username
   DB_PASSWORD = your_db_password
   PORT = 8080
   ```

6. Click **"Create Web Service"**

### 4️⃣ Wait for Deployment
- Render will build and deploy your application
- This takes 5-10 minutes
- Watch the logs for any errors

### 5️⃣ Access Your Application

Once deployed, you'll get URLs like:

**🌐 Application URL:**
```
https://blog-management-system-xxxx.onrender.com
```

**📚 Swagger Documentation:**
```
https://blog-management-system-xxxx.onrender.com/swagger-ui.html
```

**📖 API Documentation:**
```
https://blog-management-system-xxxx.onrender.com/api-docs
```

**🔗 API Base URL:**
```
https://blog-management-system-xxxx.onrender.com/api/blogs
```

### 6️⃣ Test Your API

Use Swagger UI or test with curl:

```bash
# Get all blogs
curl https://your-app-url.onrender.com/api/blogs

# Create a blog
curl -X POST https://your-app-url.onrender.com/api/blogs \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My First Blog",
    "content": "This is my first blog post!",
    "author": "Rahul Mishra",
    "category": "Technology",
    "published": true
  }'
```

## 🔧 Troubleshooting

### Issue: Application not starting
- Check environment variables are set correctly
- Verify database connection string
- Check Render logs for errors

### Issue: Database connection failed
- Ensure DATABASE_URL format is correct
- Verify database credentials
- Check if database is running

### Issue: Build failed
- Check Java version (should be 17)
- Verify Maven dependencies
- Check build logs on Render

## 📱 Mobile App Access

Once deployed, you can access your API from:
- Web browsers
- Mobile apps (iOS/Android)
- Postman/Insomnia
- Any HTTP client

**Base URL for mobile apps:**
```
https://your-app-name.onrender.com/api/blogs
```

## 🔄 Auto-Deploy

Render automatically deploys when you push to GitHub:
1. Make changes to your code
2. Commit and push to GitHub
3. Render automatically rebuilds and deploys

## 💡 Tips

1. **Free Tier Limitations:**
   - App sleeps after 15 minutes of inactivity
   - First request after sleep takes 30-60 seconds
   - Upgrade to paid plan for 24/7 uptime

2. **Custom Domain:**
   - Go to Settings → Custom Domain
   - Add your domain
   - Update DNS records

3. **Environment Variables:**
   - Never commit sensitive data to GitHub
   - Always use environment variables
   - Update them in Render dashboard

## 📞 Support

If you face any issues:
- Check Render logs
- Review application.properties
- Contact: rm2778643@gmail.com

---

Happy Deploying! 🚀