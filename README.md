Recipe Book
This is a simple Recipe Book application built using Spring Boot, JPA, and Lombok. The application allows users to create, update, delete, and view recipes along with related categories and images. The system follows a REST API architecture and supports basic CRUD operations for the Recipe, Category, and Image entities.

Features
Create Recipes: Users can add new recipes with titles, descriptions, categories, and images.
Update Recipes: Modify existing recipes, including their details and associated categories/images.
Delete Recipes: Remove a recipe and its associated data from the system.
List Recipes: View all recipes with their categories and images.
Image Upload: Upload images related to each recipe.
Soft Delete: Soft delete mechanism for recipes.
MapStruct Integration: DTO mapping is handled via MapStruct to reduce boilerplate code.
Technologies Used
Spring Boot: Main framework for building the application.
Spring Data JPA: For ORM (Object Relational Mapping) and database operations.
Lombok: For reducing boilerplate code (getters, setters, constructors, etc.).
MySQL: Database used to store the recipes, categories, and images.
MapStruct: For automatic DTO to entity mapping.
Hibernate: ORM framework for data persistence.
Maven: Build tool to manage dependencies.
ER Diagram
Include the ER Diagram here if you have it.

Getting Started
Prerequisites
Before you begin, make sure you have the following installed:

Java 17 or later: Install Java
Maven 3.6.0+: Install Maven
MySQL: Install MySQL
Setup
Clone the Repository

bash
Kodu kopyala
git clone https://github.com/yourusername/recipe-book.git
cd recipe-book
Configure MySQL Database

Update the application.properties file with your MySQL database configuration:

properties
Kodu kopyala
spring.datasource.url=jdbc:mysql://localhost:3306/recipe_db
spring.datasource.username=your_username
spring.datasource.password=your_password

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
Install Dependencies

Use Maven to install the project dependencies:

bash
Kodu kopyala
mvn clean install
Run the Application

Start the Spring Boot application:

bash
Kodu kopyala
mvn spring-boot:run
Access the Application

The application will be running at:

arduino
Kodu kopyala
http://localhost:8080
API Endpoints
GET /recipes: Retrieve a list of all recipes.
POST /recipes: Create a new recipe.
PUT /recipes/{id}: Update an existing recipe.
DELETE /recipes/{id}: Soft delete a recipe.
GET /categories: Retrieve all categories.
POST /categories: Create a new category.
GET /images: Retrieve images for a specific recipe.
Sample Request
Here’s an example of a JSON request to create a new recipe:

json
Kodu kopyala
{
  "recipeRequest": {
    "name": "Spaghetti Bolognese",
    "description": "Classic Italian pasta dish with meat sauce",
    "readingTime": 15
  },
  "categoryRequest": {
    "name": "Italian"
  },
  "imageRequests": [
    {
      "filePath": "path/to/image1.jpg",
      "description": "Spaghetti served with sauce"
    },
    {
      "filePath": "path/to/image2.jpg",
      "description": "Close-up of the meat sauce"
    }
  ]
}
Sample Response
Here’s a sample response for getting a recipe:

json
Kodu kopyala
{
  "recipeResponse": {
    "id": "UUID",
    "name": "Spaghetti Bolognese",
    "description": "Classic Italian pasta dish with meat sauce",
    "readingTime": 15
  },
  "imageCardResponse": [
    {
      "filePath": "path/to/image1.jpg",
      "description": "Spaghetti served with sauce"
    }
  ],
  "categoryCardResponse": {
    "name": "Italian"
  }
}
Contributing
If you'd like to contribute to this project, follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes and commit them (git commit -m 'Add new feature').
Push to the branch (git push origin feature-branch).
Open a pull request.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Special thanks to the Spring Boot and Hibernate communities for their great documentation and support.
Inspiration and UI design by [source of design inspiration, if applicable].
