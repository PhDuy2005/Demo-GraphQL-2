# 📚 Demo GraphQL Library Management (Spring Boot 3.5.6)

## 🚀 Overview
This is a **GraphQL API demo** for a simple Library Management System built using:
- **Spring Boot 3.5.6**
- **Java 17**
- **Gradle**
- **MySQL**
- **Spring GraphQL Starter**

It provides a minimal example for using **GraphQL** with **Spring Boot** to manage entities such as `Book`, `Author`, and `Library`.

---

## ⚙️ Configuration

### 1️⃣ Database Setup
Create a database in MySQL (e.g., `librarydb`), then update your credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
```

### 2️⃣ GraphQL Endpoint
The GraphQL endpoint is available at:
```
http://localhost:8081/graphql
```

---

## 🧩 Example Schema

Example `schema.graphqls` in `src/main/resources/graphql/`:

```graphql
type Book {
  id: ID!
  title: String!
  author: Author
}

type Author {
  id: ID!
  name: String!
  books: [Book]
}

type Query {
  books: [Book]
  bookById(id: ID!): Book
  authors: [Author]
}

type Mutation {
  addBook(title: String!, authorId: ID!): Book
  addAuthor(name: String!): Author
}
```

---

## 🧠 Example Queries

### Query all books
```graphql
query {
  books {
    id
    title
    author {
      name
    }
  }
}
```

### Add new book
```graphql
mutation {
  addBook(title: "Clean Code", authorId: 1) {
    id
    title
  }
}
```

---

## 🧪 Testing with Postman

1. Open **Postman**
2. Set method to **POST**
3. URL: `http://localhost:8081/graphql`
4. In the body tab → choose **GraphQL**
5. Paste your query or mutation

Example:

```graphql
query {
  books {
    id
    title
  }
}
```

---

## 🧪 Test với GraphiQL

Spring Boot GraphQL Starter tích hợp sẵn **GraphiQL UI**, một giao diện web trực quan để test các truy vấn GraphQL.

### 🔹 Bật GraphiQL trong `application.yml`
```yaml
spring:
  graphql:
    graphiql:
      enabled: true
```

### 🔹 Mở trình duyệt tại
[http://localhost:8080/graphiql](http://localhost:8080/graphiql)

## 🏗️ Build and Run

### Run with Gradle
```bash
./gradlew bootRun
```

### Build JAR
```bash
./gradlew build
java -jar build/libs/Demo-GraphQL-2-0.0.1-SNAPSHOT.jar
```

---

## ✨ Notes
- Default port: **8081**
- App name: **Demo-GraphQL-2**
- Endpoint: **/graphql**
- Example Database: **librarydb**

---

Made with ❤️ using **Spring Boot + GraphQL**
