package carsalessystem;

import java.util.InputMismatchException;

public class CanBeFinanced extends CanBeSold {

    private static final double FinanceInterestPercentage = 9.55 / 100d; //hardcoded interest percentage
    private double FinanceDeposit;
    private double FinanceMonthlyPayment;
    private double FinanceTotalPayment;
    private int FinanceDuration;

    public CanBeFinanced() {
    }

    public CanBeFinanced(int financeDuration, CanBeSold canBeSold) {
        this.FinanceDuration = financeDuration;
        this.FinanceDeposit = 0.3 * canBeSold.getCashPrice();
        this.FinanceTotalPayment = canBeSold.getCashPrice() + (canBeSold.getCashPrice() * getFinanceInterestPercentage());
        this.FinanceMonthlyPayment = (canBeSold.getCashPrice() + (canBeSold.getCashPrice() * getFinanceInterestPercentage())) / financeDuration;

        this.setCashPrice(canBeSold.getCashPrice());
        this.setCarReg(canBeSold.getCarReg());
        this.setCarMake(canBeSold.getCarMake());
        this.setCarModel(canBeSold.getCarModel());
        this.setCarMileage(canBeSold.getCarMileage());
        this.setCarAge(canBeSold.getCarAge());
        this.setCarColour(canBeSold.getCarColour());
        this.setCarFeatures(canBeSold.getCarFeatures());
    }

    public static double getFinanceInterestPercentage() {
        return FinanceInterestPercentage;
    }

    public int getFinanceDuration() {
        return this.FinanceDuration;
    }

    public double getFinanceTotalPayment() {
        return this.FinanceTotalPayment;
    }

    public double getFinanceMonthlyPayment() {
        return this.FinanceMonthlyPayment;
    }

    public double getFinanceDeposit() {
        return this.FinanceDeposit;
    }

    public double getFinanceDurationMonthlyPayment() {
        return this.FinanceMonthlyPayment;
    }

    public void AddFinanceInfo(CanBeSold canBeSold) {
        int newFinanceDuration = 0;
        do {
            try {
                System.out.println("Please enter the duration of the finance agreement (months):");
                newFinanceDuration = scanner.nextInt();
                if (newFinanceDuration >= 60) {
                    System.out.println("Maximum length of finance duration is 59 months.");
                    newFinanceDuration = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid entry. Please enter a new finance duration (months)");
                scanner.nextLine(); // Clear the invalid input
            }
        } while (newFinanceDuration == 0);

        // Create a new CanBeFinanced object with the updated cash price
        CanBeFinanced newFinance = new CanBeFinanced(newFinanceDuration, canBeSold);
        MenuSelection.carFinanceList.add(newFinance);
        System.out.println(newFinance.displayDetails(newFinance));
    }

    public String displayDetails(CanBeFinanced canBeFinanced) {
        return String.format("\tFinance Duration: %d months\n\tInitial Deposit: £%.2f\n\tMonthly Payment: £%.2f\n\tTotal Payment: £%.2f (Interest rate %.2f%%)", canBeFinanced.FinanceDuration, canBeFinanced.FinanceDeposit, canBeFinanced.FinanceMonthlyPayment, canBeFinanced.FinanceTotalPayment, FinanceInterestPercentage * 100);
    }
}
