package carsalessystem;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MenuSelectionTest {

    @BeforeEach
    public void setUp() {
        MenuSelection menuSelection = new MenuSelection();
        MenuSelection.carDetailList = new ArrayList<>();
    }

    @Test
    public void testAddNewCar() {
        Car car = new Car("A Bc1 23   ", "Toyota", "Corolla", 10000, 5, "Red", "Air Conditioning");
        MenuSelection.carDetailList.add(car);
        assertEquals(1, MenuSelection.carDetailList.size());
        assertEquals("ABC123", MenuSelection.carDetailList.getFirst().getCarReg());
    }

    @Test
    public void testDeleteExistingCar() {
        Car car = new Car("ABC123", "Toyota", "Corolla", 10000, 5, "Red", "Air Conditioning");
        MenuSelection.carDetailList.add(car);
        assertEquals(1, MenuSelection.carDetailList.size());

        MenuSelection.carDetailList.removeFirst();
        assertEquals(0, MenuSelection.carDetailList.size());
    }

    @Test
    public void testListExistingCars() {
        Car car1 = new Car("ABC123", "Toyota", "Corolla", 10000, 5, "Red", "Air Conditioning");
        Car car2 = new Car("XYZ789", "Honda", "Civic", 20000, 3, "Blue", "Sunroof");
        MenuSelection.carDetailList.add(car1);
        MenuSelection.carDetailList.add(car2);

        assertEquals(2, MenuSelection.carDetailList.size());
        assertEquals("ABC123", MenuSelection.carDetailList.get(0).getCarReg());
        assertEquals("XYZ789", MenuSelection.carDetailList.get(1).getCarReg());
    }
}


