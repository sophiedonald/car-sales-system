package carsalessystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanBeFinancedTest {

    private CanBeSold canBeSold;
    private CanBeFinanced canBeFinanced;

    @BeforeEach
    void setUp() {
        // Set up a CanBeSold object to test with
        canBeSold = new CanBeSold();
        canBeSold.setCashPrice(20000); // Set a cash price for the car
        canBeSold.setCarReg("ABC123");
        canBeSold.setCarMake("Toyota");
        canBeSold.setCarModel("Camry");
        canBeSold.setCarMileage(50000);
        canBeSold.setCarAge(5);
        canBeSold.setCarFeatures("Leather seats, Sunroof");

        // Initialize CanBeFinanced object with a duration
        canBeFinanced = new CanBeFinanced(36, canBeSold); // 36-month finance duration
    }

    @Test
    void testFinanceCalculation() {
        // Test correct finance calculations
        double expectedDeposit = 0.3 * canBeSold.getCashPrice(); // 30% deposit
        double expectedTotalPayment = canBeSold.getCashPrice() + (canBeSold.getCashPrice() * CanBeFinanced.getFinanceInterestPercentage());
        double expectedMonthlyPayment = expectedTotalPayment / canBeFinanced.getFinanceDuration();

        assertEquals(expectedDeposit, canBeFinanced.getFinanceDeposit(), 0.01);
        assertEquals(expectedTotalPayment, canBeFinanced.getFinanceTotalPayment(), 0.01);
        assertEquals(expectedMonthlyPayment, canBeFinanced.getFinanceMonthlyPayment(), 0.01);
    }

    @Test
    void testConstructorWithFinanceDuration() {
        // Test constructor with finance duration
        assertNotNull(canBeFinanced);
        assertEquals(36, canBeFinanced.getFinanceDuration());
    }

    @Test
    void testFinanceInterestPercentage() {
        // Test static interest percentage value
        assertEquals(9.55 / 100, CanBeFinanced.getFinanceInterestPercentage());
    }

    @Test
    void testDisplayDetails() {
        // Test the displayDetails method format
        String expected = "\tFinance Duration: 36 months\n\tInitial Deposit: £6000.00\n\tMonthly Payment: £608.61\n\tTotal Payment: £21910.00 (Interest rate 9.55%)";
        String actual = canBeFinanced.displayDetails(canBeFinanced);

        assertEquals(expected, actual);
    }

}
