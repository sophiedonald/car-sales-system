# Car Sales System Application

A car sales system application build using **Java**, **Gradle** and **Kotlin**. This project is deisgned to be used by dealerships to manage an inventory of cars.

## Features
- **Car Inventory Management**: Add, remove and edit cars in the inventory (Easter egg: when prompted for car age, try entering the year of registration eg 2019 instead of the age!)
- **Check all fields**: Loop through all cars and make sure all fields are complete
- **Search**: Search through all existing cars and view all matches
- **Finance info**: Add a cash price alone or add a finance duration alongside the cash price, which auto-calculates relevant payment information such as monthly payments
- **Finance records**: View a record of all cash price changes and finance changes

## Technologies used
- **Java**: Core logic and functionality
- **Gradle/Kotlin**: Build tool

## Project structure
```
CarSalesSystem/
|-build.gradle.kts
|-settings.gradle.kts
|-gradle/
    |-wrapper/
        |-gradle-wrapper.jar
        |-gradle-wrapper.properties
|-src/
    |-main/
        |-java/carsalessystem
    |-test/
        |-java/carsalessystem
|-build/
|-README.md
```
## Setup and installation
### 1. Clone the repository
```bash
git clone https://github.com/sophiedonald/car-sales-system.git
cd car-sales-system
```
### 2. Build the project
If you have gradle installed locally, use `gradle build`. Alternatively, use `gradlew build jar` for Windows or `./gradlew build jar` for MacOS/Linux
### 3. Run the application
To run the application, use `java -jar build/libs/CarSalesSystem-1.0-SNAPSHOT.jar`
The main class can be found in `src/main/java/carsalessystem`
### 4. Run the tests
To run the unit tests, use `gradlew test` for Windows and `./gradlew test` for MacOS/Linux
The unit tests can be found in `src/test/java/carsalessystem`
## Usage
After running the project, navigate through the main menu to explore all features of the application.
