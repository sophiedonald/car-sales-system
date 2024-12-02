interface CanBeFinanced{
    public void setFinanceDeposit(double FinanceDeposit);
    public void setFinanceMonthlyPayment(double FinanceMonthylPayment);
    public void setFinanceTotalInterest(double FinanceTotalInterest);
    //public void getFinanceInterestPercetage();
}

public class CanBeSold extends Car implements CanBeFinanced{

    private Car CarCanBeSold;

    private double CashPrice;

    private double FinanceDeposit;
    private double FinanceMonthlyPayment;
    private double FinanceTotalInterest;
    private double FinanceTotalPayment;
    private int FinanceDuration;
    private final double FinanceInterestPercetage = 9.55/100d; //hardcoded interest percentage

    public CanBeSold()
    {
    }

    public CanBeSold(Car carCanBeSold, double cashPrice, int financeDuration){
        //this.CarCanBeSold = car;
        this.setCarReg(carCanBeSold.getCarReg());
        this.setCarMake(carCanBeSold.getCarMake());
        this.setCarModel(carCanBeSold.getCarModel());
        this.setCarMileage(carCanBeSold.getCarMileage());
        this.setCarAge(carCanBeSold.getCarAge());
        this.setCarColour(carCanBeSold.getCarColour());
        this.setCarFeatures(carCanBeSold.getCarFeatures());
        this.CashPrice = cashPrice;
        this.FinanceDuration = financeDuration;
        this.FinanceDeposit = 0.3 * cashPrice;
        this.FinanceTotalPayment = this.CashPrice + this.FinanceTotalInterest;
        this.FinanceMonthlyPayment = this.FinanceTotalPayment / this.FinanceDuration;
        this.FinanceTotalInterest = this.CashPrice * this.FinanceInterestPercetage;
    }

    public CanBeSold(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures, double cashPrice, int financeDuration)
    {
        super(carReg, carMake, carModel, carMileage, carAge, carColour, carFeatures);
        // this.setCarReg(carCanBeSold.getCarReg());
        // this.setCarMake(carCanBeSold.getCarMake());
        // this.setCarModel(carCanBeSold.getCarModel());
        // this.setCarMileage(carCanBeSold.getCarMileage());
        // this.setCarAge(carCanBeSold.getCarAge());
        // this.setCarColour(carCanBeSold.getCarColour());
        // this.setCarFeatures(carCanBeSold.getCarFeatures());

        this.CashPrice = cashPrice;
        this.FinanceDuration = financeDuration;
        this.FinanceDeposit = 0.3 * cashPrice;
        this.FinanceMonthlyPayment = this.FinanceTotalInterest / this.FinanceDuration;
        this.FinanceTotalInterest = this.CashPrice * this.FinanceInterestPercetage;
        this.FinanceTotalPayment = this.CashPrice + this.FinanceTotalInterest;
    }

    public double getCashPrice(){
        return this.CashPrice;
    }
    public void setCashPrice(double price){
        this.CashPrice = price;
    }

    public double getFinanceDeposit(){
        return this.FinanceDeposit;
    }
    public void setFinanceDeposit(double deposit){
        this.FinanceDeposit = deposit;
    }

    public double getFinanceMonthlyPayment(){
        return this.FinanceMonthlyPayment;
    }
    public void setFinanceMonthlyPayment(double monthly){
        this.FinanceMonthlyPayment = monthly;
    }

    public double getFinanceTotalInterest(){
        return this.FinanceTotalInterest;
    }
    public void setFinanceTotalInterest(double interest){
        this.FinanceTotalInterest = interest;
    }

    public double getFinanceInterestPercetage(){
        return FinanceInterestPercetage;
    }

    public int getFinanceDuration(){
        return this.FinanceDuration;
    }
    public void setFinanceDuration(int duration){
        this.FinanceDuration = duration;
    }

    //public String toString(Car basicCar){
    //     return basicCar.getCarReg() + " is £" + this.getCashPrice() + " and can be financed over " + this.getFinanceDuration() + " months for £" + this.getFinanceMonthlyPayment() + " per month with an initial deposit of " + this.getFinanceDeposit();
    // }

    public String toString(){
        return String.format("%s is £%.2f and can be financed over %d months for £%.2f per month with an initial deposit of £%.2f", this.getCarReg(), this.getCashPrice(), this.getFinanceDuration(), this.getFinanceMonthlyPayment(), this.getFinanceDeposit());
    }
}
