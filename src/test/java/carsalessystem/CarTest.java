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
    void testSetters() {
        // test setters
        car.setCarReg("XYZ789");
        car.setCarMake("Honda");
        car.setCarModel("Accord");
        car.setCarMileage(60000);
        car.setCarAge(8);
        car.setCarColour("Green");
        car.setCarFeatures("Leather Seats");

        assertEquals("XYZ789", car.getCarReg());  // Should be uppercase, and trimmed/spaces removed
        assertEquals("HONDA", car.getCarMake());  // Should be uppercase
        assertEquals("ACCORD", car.getCarModel());  // Should be uppercase
        assertEquals(60000, car.getCarMileage());
        assertEquals(8, car.getCarAge());
        assertEquals("GREEN", car.getCarColour());  // Should be uppercase
        assertEquals("LEATHER SEATS", car.getCarFeatures());  // Should be uppercase
    }

    @Test
    void testDisplayDetails() {
        // Test the displayDetails method to display formatted info
        String expectedDetails = "Registration:\tAB123CD\nMake:\t\t\tTOYOTA\nModel:\t\t\tCOROLLA\nMileage:\t\t50000\nAge:\t\t\t9\nColour:\t\t\tBLUE\nFeatures:\t\tAIR CONDITIONING";
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
        // Test that setting an invalid year (e.g., 2000) is handled properly
        car.setCarAge(2000);
        assertEquals(24, car.getCarAge());  // 2024 - 2000 = 24 (invalid year should be treated as car age)
    }

    @Test
    void testSetCarAgeWithValidAge() {
        // Test that a valid car age (e.g., 5 years) is accepted
        car.setCarAge(5);
        assertEquals(5, car.getCarAge());
    }
}
