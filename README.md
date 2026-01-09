# Vehicle Rental System

A console-based Java application demonstrating Object-Oriented Programming
principles such as inheritance, polymorphism, interfaces, records, and sealed classes.


## Features
- Rent different vehicle types (Car, Van, Electric Car, Bike)
- Booking management using immutable records
- Pricing calculation based on vehicle type and duration
- Console-based menu for testing
- UML-based system design


## OOP Concepts Used
- Inheritance & Polymorphism (Vehicle hierarchy)
- Encapsulation (private fields and access control)
- Abstraction (Rentable interface)
- Sealed classes (restricted inheritance)
- Records (immutable data objects)
- Service-layer architecture


## Project Structure
```
src/
└── com/
    └── acme/
        └── rental/
            ├── billing/
            ├── catalog/
            ├── exceptions/
            ├── model/
            ├── util/
            └── MainAppTester.java
```



 
 ## How to Run

### Requirements
- Java JDK 17 or higher
- Eclipse or IntelliJ


### Steps
1. Clone the repository
2. Open in IDE
3. Run `MainAppTester`

## UML Diagram
The UML class diagram is included as `docs/UML.png` and shows:
- Vehicle inheritance hierarchy
- Interfaces and associations
- Service-layer relationships

## Documentation
- Project report (Word document)
- UML diagram


## Future Improvements
- Add persistence (file or database)
- Add unit tests (JUnit)
- Improve pricing logic
- Add GUI or web interface
