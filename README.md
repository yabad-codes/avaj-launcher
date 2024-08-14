# Avaj Launcher

## Project Overview
Avaj Launcher is a Java-based aircraft simulation program developed as part of the 42 school curriculum. This project introduces fundamental concepts of Java programming, Object-Oriented Programming (OOP), and design patterns.

## Learning Outcomes

### Java Fundamentals
- Basic Java syntax and structure
- Java compilation and execution process
- File I/O operations in Java
- Exception handling

### Object-Oriented Programming
- Class and object creation
- Inheritance and polymorphism
- Abstract classes and interfaces
- Encapsulation and access modifiers

### Design Patterns
1. **Observer Pattern**
   - Implemented for aircraft registration with the weather tower
   - Demonstrates loose coupling between objects

   ![Observer pattern](https://github.com/user-attachments/assets/a30e6619-af89-4ab1-9988-c21f509b4d2c)


2. **Singleton Pattern**
   - Applied to WeatherProvider and AircraftFactory classes
   - Ensures a single instance of these classes throughout the application
  
   ![Singleton pattern](https://github.com/user-attachments/assets/66f3a8fd-ad82-417b-9363-5fee532ca817)

3. **Factory Pattern**
   - Used in AircraftFactory for creating different types of aircraft
   - Illustrates abstraction in object creation

   ![Factory pattern](https://github.com/user-attachments/assets/79d59e8a-09cc-4480-9f6d-447a8fd33a77)


## Project Structure
- `Simulator.java`: Main entry point of the application
- `WeatherTower.java`: Manages weather changes and notifications
- `Aircraft.java`: Base class for all aircraft types
- `Flyable.java`: Interface implemented by aircraft classes
- `WeatherProvider.java`: Singleton class for weather generation
- `AircraftFactory.java`: Factory class for creating aircraft objects

## Key Takeaways
- Practical application of OOP principles in a real-world scenario
- Understanding of design patterns and their benefits in software architecture
- Experience in interpreting and implementing UML class diagrams
- Improved Java coding skills and best practices

## How to Run
1. Compile the Java files:
   ```
   find * -name "*.java" > sources.txt
   javac @sources.txt
   ```
2. Run the simulator:
   ```
   java -cp src ma.leet.avaj.simulation.Simulation scenario.txt
   ```
3. Check the generated `simulation.txt` file for output.

This project provided hands-on experience in Java development and software design, laying a strong foundation for future, more complex Java applications.
