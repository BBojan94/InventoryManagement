# 📦 Inventory Management System

A web-based Inventory Management System built with **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, and **PostgreSQL**. It allows users to manage products within an inventory — including creating, updating, and deleting records.

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

---

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

-- ===============================
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

-- ===============================
-- Category Values for Testing
-- ===============================
INSERT INTO category (name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Furniture', 'Home and office furniture'),
('Clothing', 'Apparel including shirts, pants, jackets, and accessories'),
('Sports Equipment', 'Gear for sports activities like balls, bats, and protective equipment'),
('Home Appliances', 'Household appliances like refrigerators, washing machines, and air conditioners'),
('Books', 'Printed or digital books across various genres like fiction, non-fiction, and educational'),
('Toys', 'Children’s toys, including educational and interactive play items'),
('Groceries', 'Daily essential food items like fruits, vegetables, and packaged goods'),
('Beauty Products', 'Cosmetics and skincare products for personal care and grooming'),
('Stationery', 'Office and school supplies like pens, notebooks, and paper'),
('Jewelry', 'Luxury and fashion jewelry including rings, necklaces, and bracelets'),
('Automotive', 'Car parts, accessories, and tools for vehicle maintenance and repairs'),
('Kitchenware', 'Utensils, cookware, and kitchen gadgets for preparing food'),
('Gardening', 'Tools, seeds, and accessories for gardening and outdoor plant care'),
('Tools', 'Power tools, hand tools, and accessories for construction and DIY projects'),
('Pet Supplies', 'Food, toys, grooming products, and accessories for pets'),
('Office Supplies', 'Products for offices like printers, paper, and organizational tools'),
('Health & Wellness', 'Supplements, fitness equipment, and products for maintaining health'),
('Baby Products', 'Products designed for infants and toddlers, including clothes, toys, and feeding supplies'),
('Shoes', 'Footwear for men, women, and children, including casual, formal, and athletic shoes');

-- ===============================
-- Supplier Values for Testing
-- ===============================
INSERT INTO supplier (name, contact_name, contact_email, contact_phone) VALUES
('Tech Warehouse', 'Alice Smith', 'alice@tech.com', '123-456-7890'),
('FurniCo', 'Bob Johnson', 'bob@furnico.com', '098-765-4321'),
('Fashionista Suppliers', 'Alice Johnson', 'alice@fashionistasuppliers.com', '+1-800-345-6789'),
('Fitness Gear Co.', 'Bob Brown', 'bob@fitnessgear.com', '+1-800-456-7890'),
('Kitchen Essentials LLC', 'Carol White', 'carol@kitchenessentials.com', '+1-800-567-8901'),
('Book World', 'David Black', 'david@bookworld.com', '+1-800-678-9012'),
('Toy Kingdom', 'Eva Green', 'eva@toykingdom.com', '+1-800-789-0123'),
('Green Grocer', 'Frank Adams', 'frank@greengrocer.com', '+1-800-890-1234'),
('Stationery & Paper Goods', 'Harry Scott', 'harry@stationeryandpaper.com', '+1-800-012-3456'),
('Auto Parts Hub', 'Jack Harris', 'jack@autopartshub.com', '+1-800-234-5678'),
('Gourmet Kitchenware', 'Kathy Evans', 'kathy@gourmetkitchenware.com', '+1-800-345-6789'),
('Garden Supply Co.', 'Louis Taylor', 'louis@gardensupply.com', '+1-800-456-7890'),
('Handy Tools Inc.', 'Megan Miller', 'megan@handytools.com', '+1-800-567-8901'),
('Pet Care World', 'Nathan Moore', 'nathan@petcareworld.com', '+1-800-678-9012'),
('Beauty Pro Distributors', 'Grace Lee', 'grace@beautypro.com', '+1-800-901-2345'),
('Office Equipment Supplies', 'Olivia Davis', 'olivia@officesupplies.com', '+1-800-789-0123'),
('Luxury Jewelry Suppliers', 'Isabel King', 'isabel@luxuryjewelry.com', '+1-800-123-4567'),
('Health Products Plus', 'Paul Wilson', 'paul@healthproducts.com', '+1-800-890-1234'),
('Baby Care Essentials', 'Quincy Clark', 'quincy@babycareessentials.com', '+1-800-901-2345'),
('Shoe Emporium', 'Rachel Harris', 'rachel@shoeemporium.com', '+1-800-012-3456');

-- ===============================
-- Product Values for Testing
-- ===============================
INSERT INTO product (name, description, price, quantity, category_id, supplier_id) VALUES
('Laptop', 'High-end gaming laptop', 1500.00, 10, 1, 1),
('Office Chair', 'Ergonomic mesh chair', 200.00, 25, 2, 2),
('Leather Jacket', 'Stylish black leather jacket for men', 129.99, 30, 3, 3),
('Yoga Mat', 'Non-slip yoga mat for fitness exercises', 19.99, 100, 4, 4),
('Blender', 'High-speed blender for smoothies and shakes', 89.99, 75, 5, 5),
('Novel: The Silent Sea', 'Thrilling adventure novel set in a dystopian future', 14.99, 50, 6, 6),
('Stuffed Teddy Bear', 'Soft, cuddly teddy bear perfect for children', 24.99, 150, 7, 7),
('Organic Apple', 'Fresh, organic apples grown without pesticides', 1.99, 500, 8, 8),
('Face Cream', 'Hydrating face cream for all skin types', 25.99, 60, 9, 9),
('Notebook', 'Hardcover notebook for writing and sketching', 5.99, 200, 10, 10),
('Diamond Necklace', 'Luxurious diamond necklace with 18k gold chain', 2999.99, 10, 11, 11),
('Car Engine Oil', 'Premium quality engine oil for vehicles', 29.99, 120, 12, 12),
('Cast Iron Pan', 'Durable cast iron frying pan for cooking', 39.99, 40, 13, 13),
('Garden Shovel', 'Heavy-duty garden shovel for digging and planting', 15.99, 80, 14, 14),
('Cordless Drill', 'Portable cordless drill for home improvement projects', 79.99, 45, 15, 15),
('Pet Shampoo', 'Gentle and effective shampoo for pets with sensitive skin', 12.99, 100, 16, 16),
('Ballpoint Pens', 'Pack of 10 smooth-writing ballpoint pens', 2.99, 300, 17, 17),
('Vitamins', 'Daily multivitamins for enhanced health and energy', 19.99, 250, 18, 18),
('Baby Stroller', 'Lightweight, foldable baby stroller with adjustable seating', 199.99, 30, 19, 19),
('Running Shoes', 'Comfortable running shoes with breathable mesh', 59.99, 100, 20, 20);
```

Then update your application.properties file:
```java
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.check-template-location=true
```

---

## 🙋‍♂️ Author

GitHub: [BBojan94](https://github.com/BBojan94)

Email: bbojan1994@gmail.com

---
