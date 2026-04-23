Here is a simpler, more natural README without emojis and without “AI-style” wording:

---

# Supermarket Management System (Java OOP Project)

## Overview

This project is a Supermarket Management System developed using Java and Object-Oriented Programming principles. It simulates basic supermarket operations such as managing products, customers, and processing orders.

The system is designed to demonstrate core OOP concepts including inheritance, abstraction, encapsulation, polymorphism, interfaces, and the factory design pattern.

---

## Features

* Manage different types of products (food, electronics, clothing, etc.)
* Create products dynamically based on category
* Handle customer information
* Process orders and calculate total prices
* Apply discounts and taxes
* Validate user input
* Generate basic receipts

---

## Project Structure

The system is organized into the following components:

* Product (abstract class)
* Sellable (interface)
* InventoryManager (main product logic class)
* FoodProduct
* BeverageProduct
* ElectronicProduct
* ClothingProduct
* CleaningProduct
* PersonalCareProduct
* Customer
* Order
* InputValidator
* ProductFactory
* SupermarketSystem (main class)

---

## OOP Concepts Used

* Encapsulation: All attributes are private with getters and setters
* Abstraction: Product is an abstract class with abstract methods
* Inheritance: Product subclasses extend InventoryManager
* Polymorphism: Method overriding and factory pattern usage
* Interface: Sellable defines selling behavior
* Factory Pattern: Used to create product objects based on category

---

## How the System Works

1. The user enters product details
2. The system validates input
3. A product is created using ProductFactory
4. Customer details are entered
5. An order is created
6. The system processes the sale using Sellable methods
7. Results are displayed including product, customer, and order details

---

## How to Run

1. Open the project in any Java IDE (NetBeans, IntelliJ, Eclipse)
2. Compile all files
3. Run the SupermarketSystem main class
4. Follow the prompts in the console

---

## Author

Umwizerwa Ruth
Software Engineering Student
