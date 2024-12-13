package carsalessystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

class CanBeSoldTest {

    private CanBeSold carForSale;
    private Car baseCar;

    @BeforeEach
    void setUp() {
        // Initialize the specific car details you provided
        baseCar = new Car("AA18SHH", "Lamborghini", "Huracan", 1000, 1, "Jet Black", "Gintani Exhaust");
        carForSale = new CanBeSold(150000, baseCar);  // Assuming a price of £150,000 for this example
    }

    @Test
    void testConstructorWithCarObject() {
        CanBeSold canBeSold = new CanBeSold(150000, baseCar);
        assertEquals(150000, carForSale.getCashPrice());
        assertEquals("AA18SHH", carForSale.getCarReg());
        assertEquals("LAMBORGHINI", carForSale.getCarMake());
        assertEquals("HURACAN", carForSale.getCarModel());
        assertEquals(1000, carForSale.getCarMileage());
        assertEquals(1, carForSale.getCarAge());
        assertEquals("JET BLACK", carForSale.getCarColour());
        assertEquals("GINTANI EXHAUST", carForSale.getCarFeatures());
    }

    @Test
    void testConstructorWithDetails() {
        CanBeSold car = new CanBeSold(150000, "BB19JNK", "Ferrari", "488 GTB", 2000, 2, "Red", "Sport Package");
        assertEquals(150000, car.getCashPrice());
        assertEquals("BB19JNK", car.getCarReg());
        assertEquals("FERRARI", car.getCarMake());
        assertEquals("488 GTB", car.getCarModel());
        assertEquals(2000, car.getCarMileage());
        assertEquals(2, car.getCarAge());
        assertEquals("RED", car.getCarColour());
        assertEquals("SPORT PACKAGE", car.getCarFeatures());
    }

    @Test
    void testGetAndSetCashPrice() {
        carForSale.setCashPrice(160000);
        assertEquals(160000, carForSale.getCashPrice());
    }

    @Test
    void testDisplayDetails() {
        String expected = "AA18SHH Cash Price: £150000.00";
        assertEquals(expected, carForSale.displayDetails(carForSale));
    }
}