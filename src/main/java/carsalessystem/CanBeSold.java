package carsalessystem;

import java.util.Scanner;

public class CanBeSold extends Car {

    private double CashPrice;
    Scanner scanner = new Scanner(System.in);

    public CanBeSold() {
    }

    public CanBeSold(double cashPrice, Car car) {
        this.CashPrice = cashPrice;
        this.setCarReg(car.getCarReg());
        this.setCarMake(car.getCarMake());
        this.setCarModel(car.getCarModel());
        this.setCarMileage(car.getCarMileage());
        this.setCarAge(car.getCarAge());
        this.setCarColour(car.getCarColour());
        this.setCarFeatures(car.getCarFeatures());
    }

    public CanBeSold(double cashPrice, String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures) {

        super(carReg, carMake, carModel, carMileage, carAge, carColour, carFeatures);
        this.CashPrice = cashPrice;
    }

    public double getCashPrice() {
        return this.CashPrice;
    }

    public void setCashPrice(double cashPrice) {
        this.CashPrice = cashPrice;
    }

    public String displayDetails(CanBeSold car) {
        return String.format("%s Cash Price: £%.2f", car.getCarReg(), car.CashPrice);
    }

    public void AddCashPrice(Car car) {

        System.out.println("What is the cash price of " + car.getCarReg() + "? (GBP)");

        boolean validInput = false;
        double newCashPrice = 0;

        do {
            try {
                newCashPrice = scanner.nextDouble();
                if (newCashPrice <= 0) {
                    throw new Exception();
                }
                validInput = true;

            } catch (Exception ex) {
                System.out.println("Invalid entry. Please enter a new cash price");
            }
        } while (!validInput);

        MenuSelection.carCashPriceList.add(new CanBeSold(newCashPrice, car));
    }
}
