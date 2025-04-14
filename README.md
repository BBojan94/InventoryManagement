# 📦 Inventory Management System

A web-based Inventory Management System built with **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, and **PostgreSQL**. It allows users to manage categories and items within an inventory — including creating, updating, and deleting records.

---

## 🚀 Features

- ✅ Add, edit, view, and delete **products**
- ✅ Form validation using `javax.validation`
- ✅ Responsive web UI using **Thymeleaf**
- ✅ Uses **PostgreSQL** for persistent database storage
- ✅ Clean MVC architecture
- ✅ DTO and Mapper layer to separate entity and UI logic

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web (MVC)
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Lombok

---

## 🧱 Project Structure

```bash
src/
├── main/
│   ├── java/com/bojan/inventorymanagement/
│   │   ├── controller
│   │   │   └── CategoryController.java
│   │   │   └── ProductController.java
│   │   │   └── ProductFrontEndController.java
│   │   │   └── SupplierController.java
│   │   ├── dto
│   │   │   └── CategoryDTO.java
│   │   │   └── ProductDTO.java
│   │   │   └── SupplierDTO.java
│   │   ├── exception
│   │   │   └── GlobalExceptionHandler.java
│   │   │   └── ResourceNotFoundException.java
│   │   ├── mapper
│   │   │   └── ProductMapper.java
│   │   ├── model
│   │   │   └── Category.java
│   │   │   └── Product.java
│   │   │   └── Supplier.java
│   │   ├── repository
│   │   │   └── CategoryRepository.java
│   │   │   └── ProductRepository.java
│   │   │   └── SupplierRepository.java
│   │   ├── service
│   │   │   ├── impl
│   │   │   │   └── CategoryServiceImpl.java
│   │   │   │   └── ProductServiceImpl.java
│   │   │   │   └── SupplierServiceImpl.java
│   │   │   └── CategoryService.java
│   │   │   └── ProductService.java
│   │   │   └── SupplierService.java
│   │   └── InventoryManagementApplication.java
│   └── resources/
│       ├── templates/
│       │   └── category/
│       │   └── product/
│       │   │   └── create.html
│       │   │   └── edit.html
│       │   │   └── list.html
│       │   └── supplier/
│       ├── static/
│       └── application.properties
└── test/
```

## 🔧 Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL (Installed & Running)

---

## 🐘 PostgreSQL Setup

Before running the app, ensure you have a PostgreSQL database created.

```sql
-- ===============================
-- Create Database
-- ===============================
CREATE DATABASE inventory_db;
-- Create Category Table
-- ===============================
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- ===============================
-- Create Supplier Table
-- ===============================
CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_name VARCHAR(100),
    contact_email VARCHAR(100),
    contact_phone VARCHAR(20)
);

-- ===============================
-- Create Product Table
-- ===============================
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    category_id INT,
    supplier_id INT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES category(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_supplier
        FOREIGN KEY (supplier_id)
        REFERENCES supplier(id)
        ON DELETE SET NULL
);
