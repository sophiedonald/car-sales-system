package CarSalesSystem;

import java.util.InputMismatchException;

public class CanBeFinanced extends CanBeSold{
    
    private double FinanceDeposit;
    private double FinanceMonthlyPayment;
    private double FinanceTotalInterest;
    private double FinanceTotalPayment;
    private int FinanceDuration;
    private static final double FinanceInterestPercetage = 9.55/100d; //hardcoded interest percentage

    public CanBeFinanced(){

    }

    public CanBeFinanced(int financeDuration, CanBeSold canBeSold){
        this.FinanceDuration = financeDuration;
        this.FinanceDeposit = 0.3 * canBeSold.getCashPrice();
        this.FinanceTotalInterest = this.getCashPrice() * FinanceInterestPercetage;
        this.FinanceTotalPayment = this.getCashPrice() + this.FinanceTotalInterest;
        this.FinanceMonthlyPayment = this.FinanceTotalPayment / financeDuration;
        this.setCashPrice(canBeSold.getCashPrice());
        this.setCarReg(canBeSold.getCarReg());
        this.setCarMake(canBeSold.getCarMake());
        this.setCarModel(canBeSold.getCarModel());
        this.setCarMileage(canBeSold.getCarMileage());
        this.setCarAge(canBeSold.getCarAge());
        this.setCarFeatures(canBeSold.getCarFeatures());
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
        do{
            System.out.println("Would you like to add financing options for " + canBeSold.getCarReg() + "? y/n");
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
        }
        while(!(MenuSelection.userInput.startsWith("Y") || MenuSelection.userInput.startsWith("N")));

        if (MenuSelection.userInput.startsWith("Y")){
            System.out.printf("Cash price: £%.2f", canBeSold.getCashPrice());
            int newFinanceDuration = 0;
            do{
                try{
                    System.out.println("\nPlease enter the duration of the finance agreement (months):");
                    newFinanceDuration = scanner.nextInt();
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
    }

    public String displayDetails(CanBeFinanced canBeFinanced)
    {
        return String.format("Finance Duration: %d\nInitial Deposit: %.2f\nMonthly Payment: %.2f\nTotal Payment: %.2f (Interest rate %.3f)", canBeFinanced.FinanceDuration, canBeFinanced.FinanceDeposit, canBeFinanced.FinanceMonthlyPayment, canBeFinanced.FinanceTotalPayment, canBeFinanced.FinanceInterestPercetage);
    }
}
