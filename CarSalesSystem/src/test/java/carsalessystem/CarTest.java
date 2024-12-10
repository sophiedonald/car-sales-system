package carsalessystem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        // Initialize the Car object before each test
        car = new Car("AB123CD", "Toyota", "Corolla", 50000, 2015, "Blue", "Air Conditioning");
    }

    @Test
    void testConstructorAndGetters() {
        // Test the constructor and getters
        assertEquals("AB123CD", car.getCarReg());
        assertEquals("TOYOTA", car.getCarMake());  // Should be uppercase
        assertEquals("COROLLA", car.getCarModel());  // Should be uppercase
        assertEquals(50000, car.getCarMileage());
        assertEquals(9, car.getCarAge());  // Age = 2024 - 2015
        assertEquals("BLUE", car.getCarColour());  // Should be uppercase
        assertEquals("AIR CONDITIONING", car.getCarFeatures());  // Should be uppercase
    }

    @Test
    void testDefaultConstructor() {
        // Test the default constructor
        Car defaultCar = new Car();
        assertNull(defaultCar.getCarReg());
        assertNull(defaultCar.getCarMake());
        assertNull(defaultCar.getCarModel());
        assertEquals(-1, defaultCar.getCarMileage());
        assertEquals(-1, defaultCar.getCarAge());
        assertNull(defaultCar.getCarColour());
        assertNull(defaultCar.getCarFeatures());
    }

    @Test
    void testStaticCarCount() {
        // Test the static carCount variable
        assertEquals(1, Car.getCarCount());  // Initially should be 1 due to creating a new car at the top of this file
        new Car("XY987AB", "Honda", "Civic", 30000, 2020, "Red", "Sunroof");
        assertEquals(2, Car.getCarCount());  // After creating a car, car count should be 1
        Car.setCarCount(1);
        assertEquals(3, Car.getCarCount());  // Should now be 2
    }

    @Test
    void testSetters() {
        // Test setters and make sure they correctly set the values
        car.setCarReg("XYZ789");
        car.setCarMake("Honda");
        car.setCarModel("Accord");
        car.setCarMileage(60000);
        car.setCarAge(8);
        car.setCarColour("Green");
        car.setCarFeatures("Leather Seats");

        assertEquals("XYZ789", car.getCarReg());
        assertEquals("HONDA", car.getCarMake());  // Should be uppercase
        assertEquals("ACCORD", car.getCarModel());  // Should be uppercase
        assertEquals(60000, car.getCarMileage());
        assertEquals(8, car.getCarAge());
        assertEquals("GREEN", car.getCarColour());  // Should be uppercase
        assertEquals("LEATHER SEATS", car.getCarFeatures());  // Should be uppercase
    }

    @Test
    void testDisplayDetails() {
        // Test the displayDetails method
        String expectedDetails = "Registration:\tAB123CD\nMake:\t\tTOYOTA\nModel:\t\tCOROLLA\nMileage:\t50000\nAge:\t\t9\nColour:\t\tBLUE\nFeatures:\tAIR CONDITIONING";
        assertEquals(expectedDetails, car.displayDetails(car));
    }

    @Test
    void testContainsWithMatchingSearchTerm() {
        // Test the contains method with a matching search term
        assertTrue(car.contains(car, "TOYOTA"));
        assertTrue(car.contains(car, "COROLLA"));
        assertTrue(car.contains(car, "50000"));
        assertTrue(car.contains(car, "BLUE"));
    }

    @Test
    void testContainsWithNonMatchingSearchTerm() {
        // Test the contains method with a non-matching search term
        assertFalse(car.contains(car, "BMW"));
        assertFalse(car.contains(car, "Civic"));
        assertFalse(car.contains(car, "100000"));
        assertFalse(car.contains(car, "Red"));
    }

    @Test
    void testSetCarAgeWithInvalidYear() {
        // Test that setting an invalid year (e.g., 1900) is handled properly
        car.setCarAge(2000);
        assertEquals(24, car.getCarAge());  // 2024 - 1900 = 124 (invalid year should be treated as car age)
    }

    @Test
    void testSetCarAgeWithValidAge() {
        // Test that a valid car age (e.g., 5 years) is accepted
        car.setCarAge(5);
        assertEquals(5, car.getCarAge());
    }
}
