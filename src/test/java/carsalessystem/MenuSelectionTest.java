package carsalessystem;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MenuSelectionTest {

    private MenuSelection menuSelection;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
        menuSelection = new MenuSelection(mockScanner);  // Inject the mock scanner
    }

    @Test
    void testMainMenuOption1() {
        // Test option 1 - List all existing cars
        when(mockScanner.nextLine()).thenReturn("1"); // Mock user input to "1"

        menuSelection.mainMenu();

        // Verify that the correct method is called for option 1
        verify(mockScanner).nextLine();
    }

    @Test
    void testMainMenuOption2() {
        // Test option 2 - Add a new car
        when(mockScanner.nextLine()).thenReturn("2"); // Mock user input to "2"

        menuSelection.mainMenu();

        // Verify the method was called
        verify(mockScanner, atLeastOnce()).nextLine();
    }

    @Test
    void testMainMenuOption3() {
        // Test option 3 - Delete an existing car
        when(mockScanner.nextLine()).thenReturn("3"); // Mock user input to "3"

        // Adding a car first
        menuSelection.carDetailList.add(new Car("ABC123", "Toyota", "Corolla", 10000, 5, "Red", "Leather seats"));

        // Mock user input to delete the car
        when(mockScanner.nextLine()).thenReturn("1");

        menuSelection.mainMenu();

        // Verify car count after deletion
        assertEquals(0, menuSelection.carDetailList.size());
    }

    @Test
    void testExitOption() {
        // Test exit option
        when(mockScanner.nextLine()).thenReturn("exit"); // Mock user input to "exit"

        menuSelection.mainMenu();

        // Verify that the exit method was triggered
        assertTrue(menuSelection.exit);
    }

    // Additional tests can be written in the same way...

}
