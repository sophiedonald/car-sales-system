package carsalessystem;

import java.util.InputMismatchException;

public class CanBeFinanced extends CanBeSold{
    
    private double FinanceDeposit;
    private double FinanceMonthlyPayment;
    private double FinanceTotalInterest;
    private double FinanceTotalPayment;
    private int FinanceDuration;
    private static double FinanceInterestPercentage = 9.55/100d; //hardcoded interest percentage

    public CanBeFinanced(){

    }

    public CanBeFinanced(int financeDuration, CanBeSold canBeSold){
        this.FinanceDuration = financeDuration;
        this.FinanceDeposit = 0.3 * canBeSold.getCashPrice();
        this.FinanceTotalInterest = canBeSold.getCashPrice() * getFinanceInterestPercentage();
        this.FinanceTotalPayment = canBeSold.getCashPrice() + (canBeSold.getCashPrice() * getFinanceInterestPercentage());
        this.FinanceMonthlyPayment = (canBeSold.getCashPrice() + (canBeSold.getCashPrice() * getFinanceInterestPercentage())) / financeDuration;
    
        this.setCashPrice(canBeSold.getCashPrice());
        this.setCarReg(canBeSold.getCarReg());
        this.setCarMake(canBeSold.getCarMake());
        this.setCarModel(canBeSold.getCarModel());
        this.setCarMileage(canBeSold.getCarMileage());
        this.setCarAge(canBeSold.getCarAge());
        this.setCarFeatures(canBeSold.getCarFeatures());
    }

    public int getFinanceDuration(){
        return this.FinanceDuration;
    }

    public static double getFinanceInterestPercentage(){
        return FinanceInterestPercentage;
    }

    // public CanBeFinanced(int financeDuration, double cashPrice, String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures){
    //     super(cashPrice, carReg, carMake, carModel, carMileage, carAge, carColour, carFeatures);
    //     this.FinanceDuration = financeDuration;
    //     this.FinanceDeposit = 0.3 * cashPrice;
    //     this.FinanceTotalPayment = this.getCashPrice() + this.FinanceTotalInterest;
    //     this.FinanceMonthlyPayment = this.FinanceTotalPayment / this.FinanceDuration;
    //     this.FinanceTotalInterest = this.getCashPrice() * this.FinanceInterestPercetage;
    // }

    public void AddFinanceInfo(CanBeSold canBeSold){
        // do{
        //     System.out.println("Would you like to add financing options for " + canBeSold.getCarReg() + "? y/n");
        //     MenuSelection.userInput = scanner.nextLine().toUpperCase();
        //     if(MenuSelection.userInput.startsWith("N")) return;
        // }
        // while(!(MenuSelection.userInput.startsWith("Y") || MenuSelection.userInput.startsWith("N")));

            System.out.printf("Cash price: £%.2f", canBeSold.getCashPrice());
            int newFinanceDuration = 0;
            do{
                try{
                    System.out.println("\nPlease enter the duration of the finance agreement (months):");
                    newFinanceDuration = scanner.nextInt();
                    if(newFinanceDuration >= 60){
                        System.out.println("Maximum length of finance duration is 59 months.");
                        newFinanceDuration = 0;
                    }
                }
                catch (InputMismatchException ex)
                {
                    System.out.println("Invalid entry. PLease neter a new finance duration (months)");
                }
            }
            while(newFinanceDuration == 0);

            MenuSelection.carFinanceList.add(new CanBeFinanced(newFinanceDuration, canBeSold));
            System.out.println(MenuSelection.carFinanceList.getLast().displayDetails(MenuSelection.carFinanceList.getLast()));
    }

    public String displayDetails(CanBeFinanced canBeFinanced)
    {
        return String.format("Finance Duration: %d\n\tInitial Deposit: %.2f\n\tMonthly Payment: %.2f\n\tTotal Payment: %.2f (Interest rate %.3f)", canBeFinanced.FinanceDuration, canBeFinanced.FinanceDeposit, canBeFinanced.FinanceMonthlyPayment, canBeFinanced.FinanceTotalPayment, canBeFinanced.FinanceInterestPercentage);
    }
}
