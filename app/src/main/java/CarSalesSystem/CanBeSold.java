package CarSalesSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
public class CanBeSold extends Car{
    
    private double CashPrice;
    Scanner scanner = new Scanner(System.in);

    public CanBeSold(){
    }

    public CanBeSold(double cashPrice, Car car){
        this.CashPrice = cashPrice;
        this.setCarReg(car.getCarReg());
        this.setCarMake(car.getCarMake());
        this.setCarModel(car.getCarModel());
        this.setCarMileage(car.getCarMileage());
        this.setCarAge(car.getCarAge());
        this.setCarFeatures(car.getCarFeatures());
    }

    public CanBeSold(double cashPrice, String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures){
        
        super(carReg, carMake, carModel, carMileage, carAge, carColour, carFeatures);
        this.CashPrice = cashPrice;
    }

    public double getCashPrice(){
        return this.CashPrice;
    }
    public void setCashPrice(double cashPrice){
        this.CashPrice = cashPrice;
    }

    public String displayDetails(CanBeSold car){
        //return String.format("%s is £%.2f and can be financed over %d months for £%.2f per month with an initial deposit of £%.2f", this.getCarReg(), this.getCashPrice(), this.getFinanceDuration(), this.getFinanceMonthlyPayment(), this.getFinanceDeposit());
        return String.format("%s Cash Price: £%.2f", car.getCarReg(), car.CashPrice);
    }

    public void AddCashPrice(Car car){

        System.out.println("Adding car information to " + car.getCarReg());
        System.out.println("What is the cash price of " + car.getCarReg() + "? (GBP)");

        double newCashPrice = 0;
        do{
            try
            {
                newCashPrice = scanner.nextDouble();
                if (newCashPrice <= 0)
                {
                    throw new Exception();
                }
            }
            catch (Exception ex)
            {
                System.out.println("Invalid entry. Please enter a new cash price");
            }
        }
        while (newCashPrice == 0);

        MenuSelection.carCashPriceList.add(new CanBeSold(newCashPrice, car));
        
    }
}





// // interface ICanBeFinanced{
// //     public void setFinanceDeposit(double FinanceDeposit);
// //     public void setFinanceMonthlyPayment(double FinanceMonthylPayment);
// //     public void setFinanceTotalInterest(double FinanceTotalInterest);
// //     //public void getFinanceInterestPercetage();
// // }

// public class CanBeSold extends Car{

//     private Car CarCanBeSold;

//     private double CashPrice;

    
//     public CanBeSold()
//     {
//     }

//     public CanBeSold(Car carCanBeSold, double cashPrice, int financeDuration){
//         //this.CarCanBeSold = car;
//         this.setCarReg(carCanBeSold.getCarReg());
//         this.setCarMake(carCanBeSold.getCarMake());
//         this.setCarModel(carCanBeSold.getCarModel());
//         this.setCarMileage(carCanBeSold.getCarMileage());
//         this.setCarAge(carCanBeSold.getCarAge());
//         this.setCarColour(carCanBeSold.getCarColour());
//         this.setCarFeatures(carCanBeSold.getCarFeatures());
//         this.CashPrice = cashPrice;
        
//     }

//     public CanBeSold(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures, double cashPrice)
//     {
//         super(carReg, carMake, carModel, carMileage, carAge, carColour, carFeatures);
//         // this.setCarReg(carCanBeSold.getCarReg());
//         // this.setCarMake(carCanBeSold.getCarMake());
//         // this.setCarModel(carCanBeSold.getCarModel());
//         // this.setCarMileage(carCanBeSold.getCarMileage());
//         // this.setCarAge(carCanBeSold.getCarAge());
//         // this.setCarColour(carCanBeSold.getCarColour());
//         // this.setCarFeatures(carCanBeSold.getCarFeatures());

//         this.CashPrice = cashPrice;
//         this.FinanceDuration = financeDuration;
//         this.FinanceDeposit = 0.3 * cashPrice;
//         this.FinanceMonthlyPayment = this.FinanceTotalInterest / this.FinanceDuration;
//         this.FinanceTotalInterest = this.CashPrice * this.FinanceInterestPercetage;
//         this.FinanceTotalPayment = this.CashPrice + this.FinanceTotalInterest;
//     }

//     public double getCashPrice(){
//         return this.CashPrice;
//     }
//     public void setCashPrice(double price){
//         this.CashPrice = price;
//     }

//     public double getFinanceDeposit(){
//         return this.FinanceDeposit;
//     }
//     public void setFinanceDeposit(double deposit){
//         this.FinanceDeposit = deposit;
//     }

//     public double getFinanceMonthlyPayment(){
//         return this.FinanceMonthlyPayment;
//     }
//     public void setFinanceMonthlyPayment(double monthly){
//         this.FinanceMonthlyPayment = monthly;
//     }

//     public double getFinanceTotalInterest(){
//         return this.FinanceTotalInterest;
//     }
//     public void setFinanceTotalInterest(double interest){
//         this.FinanceTotalInterest = interest;
//     }

//     public double getFinanceInterestPercetage(){
//         return FinanceInterestPercetage;
//     }

//     public int getFinanceDuration(){
//         return this.FinanceDuration;
//     }
//     public void setFinanceDuration(int duration){
//         this.FinanceDuration = duration;
//     }

//     //public String toString(Car basicCar){
//     //     return basicCar.getCarReg() + " is £" + this.getCashPrice() + " and can be financed over " + this.getFinanceDuration() + " months for £" + this.getFinanceMonthlyPayment() + " per month with an initial deposit of " + this.getFinanceDeposit();
//     // }

//     public String toString(){
//         return String.format("%s is £%.2f and can be financed over %d months for £%.2f per month with an initial deposit of £%.2f", this.getCarReg(), this.getCashPrice(), this.getFinanceDuration(), this.getFinanceMonthlyPayment(), this.getFinanceDeposit());
//     }
// }
