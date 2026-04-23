#  Car Rental System (Java Console App)

##  Overview
This is a console-based Car Rental System built using Java, demonstrating core Object-Oriented Programming (OOP) principles.

##  Features
- Add, edit, remove cars
- Rent and return cars
- Search cars (ID, model, availability)
- Persistent storage using CSV file
- Console-based user interface

##  OOP Concepts Used
- Encapsulation
- Inheritance
- Abstraction
- Polymorphism

##  Project Structure
- `model/` → Core entities (Car, Customer, Rental)
- `service/` → Business logic
- `interfaces/` → Contracts
- `data/` → CSV storage

##  How to Run
javac -d bin src/**/*.java
java -cp bin Main

### 1. Compile
```bash
javac -d bin src/**/*.java
