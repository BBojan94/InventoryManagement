# 📦 Inventory Management System

A web-based Inventory Management System built with **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, and **H2 Database**. It allows users to manage categories and items within an inventory — including creating, updating, and deleting records.

---

## 🚀 Features

- ✅ Add, edit, view, and delete **items**
- ✅ Form validation using `javax.validation`
- ✅ Responsive web UI using **Thymeleaf**
- ✅ Uses **H2 in-memory database** for quick testing
- ✅ Clean MVC architecture
- ✅ DTO and Mapper layer to separate entity and UI logic

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web (MVC)
- Spring Data JPA
- H2 Database
- Thymeleaf
- Lombok

---

## 🧱 Project Structure

```bash
src/
├── main/
│   ├── java/com/example/inventory
│   │   ├── controller
│   │   ├── dto
│   │   ├── model
│   │   ├── repository
│   │   ├── service
│   │   └── InventoryApplication.java
│   └── resources/
│       ├── templates/
│       │   └── category/
│       │   └── item/
│       ├── static/
│       └── application.properties
└── test/

