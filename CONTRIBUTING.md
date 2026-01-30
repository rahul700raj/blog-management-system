# 🤝 Contributing to Blog Management System

Thank you for considering contributing to this project! We welcome contributions from everyone.

## 📋 Table of Contents
- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Development Setup](#development-setup)
- [Pull Request Process](#pull-request-process)
- [Coding Standards](#coding-standards)

## 📜 Code of Conduct

- Be respectful and inclusive
- Welcome newcomers and help them learn
- Focus on constructive feedback
- Respect differing viewpoints

## 🎯 How Can I Contribute?

### Reporting Bugs
1. Check if the bug is already reported in [Issues](https://github.com/rahul700raj/blog-management-system/issues)
2. If not, create a new issue with:
   - Clear title and description
   - Steps to reproduce
   - Expected vs actual behavior
   - Screenshots if applicable
   - Environment details (OS, Java version, etc.)

### Suggesting Features
1. Check existing feature requests
2. Create a new issue with:
   - Clear use case
   - Expected behavior
   - Why this feature would be useful

### Code Contributions
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 🛠️ Development Setup

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+ (optional)
- Git

### Setup Steps

1. **Fork and Clone**
```bash
git clone https://github.com/YOUR_USERNAME/blog-management-system.git
cd blog-management-system
```

2. **Create Branch**
```bash
git checkout -b feature/your-feature-name
```

3. **Install Dependencies**
```bash
mvn clean install
```

4. **Run Tests**
```bash
mvn test
```

5. **Run Application**
```bash
mvn spring-boot:run
```

## 🔄 Pull Request Process

### Before Submitting

1. **Update Documentation**
   - Update README.md if needed
   - Add/update API documentation
   - Update CHANGELOG.md

2. **Write Tests**
   - Add unit tests for new features
   - Ensure all tests pass
   - Maintain or improve code coverage

3. **Follow Coding Standards**
   - Use consistent formatting
   - Add meaningful comments
   - Follow Java naming conventions

4. **Test Locally**
```bash
# Run all tests
mvn test

# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

### Submitting PR

1. **Commit Changes**
```bash
git add .
git commit -m "feat: add new feature description"
```

2. **Push to Fork**
```bash
git push origin feature/your-feature-name
```

3. **Create Pull Request**
   - Go to original repository
   - Click "New Pull Request"
   - Select your branch
   - Fill in PR template:
     - Description of changes
     - Related issue number
     - Screenshots if applicable
     - Testing done

4. **PR Title Format**
```
feat: add user authentication
fix: resolve database connection issue
docs: update API documentation
refactor: improve service layer code
test: add unit tests for BlogService
```

### After Submitting

- Respond to review comments
- Make requested changes
- Keep PR updated with main branch
- Be patient and respectful

## 📝 Coding Standards

### Java Code Style

```java
// Good: Clear naming, proper formatting
public class BlogService {
    
    private final BlogRepository blogRepository;
    
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
```

### Commit Message Format

```
<type>: <subject>

<body>

<footer>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `refactor`: Code refactoring
- `test`: Adding tests
- `chore`: Maintenance tasks

**Example:**
```
feat: add pagination support for blog listing

- Add Pageable parameter to getAllBlogs method
- Update controller to accept page and size parameters
- Add pagination info to response

Closes #123
```

### Code Quality

1. **Use Lombok** for boilerplate code
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Long id;
    private String title;
}
```

2. **Add Validation**
```java
@NotBlank(message = "Title is required")
@Size(min = 3, max = 200)
private String title;
```

3. **Handle Exceptions**
```java
public Blog getBlogById(Long id) {
    return blogRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
}
```

4. **Write Tests**
```java
@Test
void shouldCreateBlog() {
    Blog blog = new Blog();
    blog.setTitle("Test Blog");
    
    Blog saved = blogService.createBlog(blog);
    
    assertNotNull(saved.getId());
    assertEquals("Test Blog", saved.getTitle());
}
```

## 🧪 Testing Guidelines

### Unit Tests
```java
@SpringBootTest
class BlogServiceTest {
    
    @Autowired
    private BlogService blogService;
    
    @Test
    void testGetAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        assertNotNull(blogs);
    }
}
```

### Integration Tests
```java
@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testGetAllBlogs() throws Exception {
        mockMvc.perform(get("/api/blogs"))
            .andExpect(status().isOk());
    }
}
```

## 📚 Documentation

### API Documentation
- Use Swagger annotations
- Provide clear descriptions
- Include example requests/responses

```java
@Operation(summary = "Get all blogs", 
           description = "Retrieve all blog posts from database")
@ApiResponse(responseCode = "200", description = "Successfully retrieved")
@GetMapping
public ResponseEntity<List<Blog>> getAllBlogs() {
    // implementation
}
```

### Code Comments
```java
/**
 * Creates a new blog post in the database.
 * 
 * @param blog The blog object to create
 * @return The created blog with generated ID
 * @throws ValidationException if blog data is invalid
 */
public Blog createBlog(Blog blog) {
    // implementation
}
```

## 🎓 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Java Best Practices](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [REST API Design](https://restfulapi.net/)
- [Git Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows)

## 🏆 Recognition

Contributors will be:
- Listed in CONTRIBUTORS.md
- Mentioned in release notes
- Credited in documentation

## 📞 Questions?

- Open an issue for questions
- Email: rm2778643@gmail.com
- Check existing documentation

## 📄 License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing! 🎉