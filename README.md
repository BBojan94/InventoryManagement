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

