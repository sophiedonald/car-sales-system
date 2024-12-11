package carsalessystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelection {

    public static boolean exit = false;
    public static ArrayList<Car> carDetailList = new ArrayList<>(); //create a list to store each instance of the class Car
    public static ArrayList<CanBeSold> carCashPriceList = new ArrayList<>();
    public static ArrayList<CanBeFinanced> carFinanceList = new ArrayList<>();
    public static String userInput;
    private final int maxCars = 10; //maximum amount of cars which can be in stock, not going to change throughout programme
    public Scanner scanner = new Scanner(System.in);
    Car c = new Car();
    private boolean anotherCar = true;

    public void mainMenu() { //method to print the menu
        System.out.println("Your main options are: ");
        System.out.println("1: List all of our current car information");
        System.out.println("2: Add a new car to the Vroom Vroom Vault");
        System.out.println("3: Delete a car from the Vroom Vroom Vault");
        System.out.println("4: Check all current car fields are complete");
        System.out.println("5: Edit the details of a car");
        System.out.println("6: Search through all cars");
        System.out.println("7: View latest, add or edit a single car's finance information");
        System.out.println("8: View a record of all finance information changes");
        System.out.println("Which option would you like to choose? (type exit to exit Vroom Vroom Vault)");

        userInput = scanner.nextLine();


        switch (userInput) {
            case "1":
                listExistingCars();
                break;
            case "2":
                addNewCar();
                break;
            case "3":
                deleteExistingCar();
                break;
            case "4":
                checkExistingFields();
                break;
            case "5":
                editExistingFields();
                break;
            case "6":
                searchExistingFields();
                break;
            case "7":
                viewFinance();
                break;
            case "8":
                viewFinanceRecord();
                break;
            case "exit":
                System.out.println("Goodbye");
                exit = true;
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
        }
    }//mainMenu()

    private void listExistingCars() {
        System.out.println("You have chosen option 1: display all current car information. We currently have " + Car.getCarCount() + " cars in stock.");
        for (Car car : carDetailList) {

            System.out.println(car.displayDetails(car));

            System.out.println();
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSeleciton1()

    private void addNewCar() {

        AddField addField = new AddField();

        System.out.println("You have chosen option 2: add a new car to the Vroom Vroom Vault.");

        System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock. We have space for " + (maxCars - Car.getCarCount()) + " more cars.");

        if (Car.getCarCount() >= maxCars) {
            System.out.println("Sorry, Vroom Vroom Vault is full. A car needs to be sold before another car can be added.");
            anotherCar = false;
        }

        if (anotherCar && Car.getCarCount() < maxCars) {
            addField.addCarReg();
            if (addField.duplicateCar == false) {
                addField.addCarMake();
                addField.addCarModel();
                addField.addCarMileage();
                addField.addCarAge();
                addField.addCarColour();
                addField.addCarFeatures();

                carDetailList.add(new Car(addField.tempCarDetails[0], addField.tempCarDetails[1], addField.tempCarDetails[2], TryParseInt.tryParseInt(addField.tempCarDetails[3]), TryParseInt.tryParseInt(addField.tempCarDetails[4]), addField.tempCarDetails[5], addField.tempCarDetails[6]));


                System.out.println("Press enter to view a summary of " + addField.tempCarDetails[0]);
                scanner.nextLine();

                System.out.println(c.displayDetails(carDetailList.get(carDetailList.size() - 1)));

                do {
                    System.out.println("\nWould you like to add " + addField.tempCarDetails[0] + " to the Vroom Vroom Vault? y/n");
                    userInput = scanner.nextLine();
                    if (userInput.startsWith("y")) {
                        System.out.println(addField.tempCarDetails[0] + " has successfully been added to the Vroom Vroom Vault");
                    } else if (userInput.startsWith("n")) {
                        System.out.println(addField.tempCarDetails[0] + "will not be added and has been removed from the system.");
                        carDetailList.remove(carDetailList.size() - 1);
                    }
                }
                while (!(userInput.startsWith("y") || userInput.startsWith("n")));
                addField.tempCarDetails = null;

            }
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//addNewCar()

    private void deleteExistingCar() { //Delete
        System.out.println("You have chosen option 3: delete a car from the Vroom Vroom Vault.");

        if (!carDetailList.isEmpty()) {
            System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock:");
            for (Car car : carDetailList) {
                System.out.print((carDetailList.indexOf(car) + 1) + ": ");
                System.out.println(car.getCarReg());

            }
            System.out.println("Which car would you like to delete? (1 - " + carDetailList.size() + "). Press any other key to cancel");
            userInput = scanner.nextLine();

            try {
                int removeIndex = TryParseInt.tryParseInt(userInput);
                carDetailList.remove(removeIndex - 1);
                Car.setCarCount(-1);
                System.out.println("Successfully removed");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Sorry, this car does not exist.");
            }
        } else {
            System.out.println("Vroom Vroom Vault currently has 0 cars in stock. You cannot delete a car at this time.");
        }

        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//deleteExistingCar

    private void checkExistingFields() { //Check
        AddField addField = new AddField();
        System.out.println("You have chosen option 4: check all current car fields are complete");

        for (Car car : carDetailList) {
            addField.addCarMileage(car);
            addField.addCarAge(car);
        }

        System.out.println("All checks complete");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//checkExistingFields

    private void editExistingFields() { //Edit
        System.out.println("You have chosen option 5: edit the details of a car");

        System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock:");
        for (Car car : carDetailList) {
            System.out.print((carDetailList.indexOf(car) + 1) + ": ");
            System.out.println(car.getCarReg());
        }
        System.out.println("Which car would you like to edit? (1 - " + carDetailList.size() + ")");
        userInput = scanner.nextLine();

        try {
            Car editCar = carDetailList.get(TryParseInt.tryParseInt(userInput) - 1);

            System.out.println("Edit mode: " + editCar.getCarReg());

            System.out.println("Please enter the new registration plate. If you would not like to edit the registration plate, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarReg(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new make of " + editCar.getCarReg() + ". If you would not like to edit the make, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarMake(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new model of " + editCar.getCarReg() + ". If you would not like to edit the model, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarModel(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new mileage of " + editCar.getCarReg() + ". If you would not like to edit the mileage, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarMileage(TryParseInt.tryParseInt(userInput));
            }

            System.out.println("Please enter the new age of " + editCar.getCarReg() + ". If you would not like to edit the age, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarAge(TryParseInt.tryParseInt(userInput));
            }

            System.out.println("Please enter the new features of " + editCar.getCarReg() + ". If you would not like to edit the features, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals("")) {
                editCar.setCarFeatures(userInput.toUpperCase().replace(" ", ""));
            }
            System.out.println("Edits complete");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Sorry, this car does not exist.");

        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//

    private void searchExistingFields() { //Search
        int numberOfMatches = 0;
        System.out.println("You have chosen option 6: search through Vroom Vroom Vault");

        System.out.println("Please enter search term:");
        userInput = scanner.nextLine().toUpperCase();

        for (Car car : carDetailList) {
            if (car.contains(car, userInput)) {
                System.out.println("---------------------------");
                System.out.println(car.displayDetails(car));
                System.out.println("---------------------------");
                numberOfMatches++;
            } else {
                System.out.println(car.getCarReg() + " does not contain " + userInput);
            }
        }
        if (numberOfMatches == 1)
            System.out.println(numberOfMatches + " match found for search term: " + userInput);
        else
            System.out.println(numberOfMatches + " matches found for search term: " + userInput);

        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    private void viewFinance() { //view finance information

        int indexToView;
        String regToUseAsID;
        Car carToAccessFinanceInfo;

        ArrayList<CanBeSold> cashRecordsWithMatchingReg = new ArrayList<>();
        ArrayList<CanBeFinanced> financeRecordsWithMatchingReg = new ArrayList<>();
        CanBeSold carToBeViewed;

        CanBeSold canBeSold = new CanBeSold();
        CanBeFinanced canBeFinanced = new CanBeFinanced();

        for (Car car : carDetailList) {
            System.out.print((carDetailList.indexOf(car) + 1) + ": ");
            System.out.println(car.getCarReg());

        }
        System.out.println("Which car would you like to access finance information for? (1 - " + carDetailList.size() + ").");
        userInput = scanner.nextLine();

        try {
            indexToView = TryParseInt.tryParseInt(userInput) - 1;
            carToAccessFinanceInfo = carDetailList.get(indexToView);
            regToUseAsID = carDetailList.get((indexToView)).getCarReg();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Sorry, this car does not exist.");
            System.out.println("Press enter to continue");
            scanner.nextLine();
            return;
        }

        for (CanBeSold CBS : carCashPriceList) {
            if (CBS.getCarReg().equals(regToUseAsID)) {
                cashRecordsWithMatchingReg.add(CBS);
            }
        }

        if (cashRecordsWithMatchingReg.isEmpty()) //if the selected car does NOT have a cash price - therefore doesn't have finance options
        {
            do {
                System.out.println(carDetailList.get((indexToView)).getCarReg() + " does not have a cash price uploaded yet, would you like to add one now? y/n");
                userInput = scanner.nextLine().toUpperCase();
                if (userInput.startsWith("Y")) {
                    canBeSold.AddCashPrice(carToAccessFinanceInfo);
                    userInput = "";
                    do {
                        System.out.println("Would you like to add financing options for " + carDetailList.get((indexToView)).getCarReg() + "? y/n");
                        userInput = scanner.nextLine().toUpperCase();
                        if (userInput.startsWith("Y")) {
                            canBeFinanced.AddFinanceInfo(carCashPriceList.getLast());
                        }
                    } while (!(userInput.startsWith("N") || userInput.startsWith("Y")));
                }
            } while (!(userInput.startsWith("N") || userInput.startsWith("Y")));
            userInput = "";

        } else //if there are existing CASH PRICE records for this reg - may or may not have finance info
        {
            carToBeViewed = cashRecordsWithMatchingReg.getLast();
            System.out.println("Press enter to view latest finance options for " + carDetailList.get((indexToView)).getCarReg() + ".");
            scanner.nextLine();
            System.out.print(carToBeViewed.displayDetails(carToBeViewed));
            for (CanBeFinanced beFinanced : carFinanceList) {
                if (carToBeViewed.getCarReg().equals(beFinanced.getCarReg()) && (carToBeViewed.getCashPrice() == beFinanced.getCashPrice())) {
                    System.out.print("\tFinance Duration: " + beFinanced.getFinanceDuration() + " months");
                }
            }
            System.out.println();

            do {
                System.out.println("Would you like to change the cash price for " + carToBeViewed.getCarReg() + "? y/n");
                userInput = scanner.nextLine().toUpperCase();

                if (userInput.startsWith("Y")) {
                    boolean valid = false;
                    do {
                        try {
                            System.out.println("Enter new cash price:");
                            double newCashPrice = scanner.nextDouble();
                            scanner.nextLine();
                            if (newCashPrice <= 0 || newCashPrice == carToBeViewed.getCashPrice()) {
                                throw new InputMismatchException();
                            }
                            carCashPriceList.add(new CanBeSold(newCashPrice, carToAccessFinanceInfo));
                            //carToBeViewed.setCashPrice(newCashPrice);
                            valid = true;
                        } catch (InputMismatchException ex) {
                            scanner.nextLine();
                        }
                    } while (!valid);
                } else if (userInput.startsWith("N")) {
                }
            }
            while (!(userInput.startsWith("Y") || userInput.startsWith("N")));
            userInput = "";

            for (CanBeFinanced CBF : carFinanceList) {
                if (CBF.getCarReg().equals(regToUseAsID)) {
                    financeRecordsWithMatchingReg.add(CBF);
                }
            }
            for (CanBeSold CBS : carCashPriceList) { //update list to potentially include the new cash price we've just added
                if (CBS.getCarReg().equals(regToUseAsID)) {
                    cashRecordsWithMatchingReg.add(CBS);
                }
            }

            if (financeRecordsWithMatchingReg.isEmpty()) { //if there are no finance options
                do {
                    System.out.println(carDetailList.get((indexToView)).getCarReg() + " does not have finance info uploaded yet, would you like to add some now? y/n");
                    userInput = scanner.nextLine().toUpperCase();
                    if (userInput.startsWith("Y")) {
                        canBeFinanced.AddFinanceInfo(cashRecordsWithMatchingReg.getLast());
                    }
                } while (!(userInput.startsWith("N") || userInput.startsWith("Y")));
                userInput = "";
            } else //if there are existing FINANCE options
            {
                if (financeRecordsWithMatchingReg.getLast().getCashPrice() != carCashPriceList.getLast().getCashPrice()) //if cash price has changed
                {
                    System.out.println("You have changed the cash price for " + carDetailList.get((indexToView)).getCarReg() + ". Finance information must be updated.");
                    canBeFinanced.AddFinanceInfo(cashRecordsWithMatchingReg.getLast());
                }
                else //if cash price has not changed
                {
                    System.out.println("Latest finance info: " + financeRecordsWithMatchingReg.getLast().displayDetails(financeRecordsWithMatchingReg.getLast()));
                    do {
                        System.out.println("Would you like to change the finance duration? y/n");
                        userInput = scanner.nextLine().toUpperCase();
                        if (userInput.startsWith("Y")) {
                            canBeFinanced.AddFinanceInfo(cashRecordsWithMatchingReg.getLast());
                        }
                    }
                    while (!(userInput.startsWith("Y") || userInput.startsWith("N")));
                }
            }
        }

        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//viewFinance

    public void viewFinanceRecord() {
        if(!carCashPriceList.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("Cash price changes:");
            for (CanBeSold cashPriceRecord : carCashPriceList) {
                System.out.print(cashPriceRecord.getCarReg());
                System.out.println("\tCash Price: £" + cashPriceRecord.getCashPrice());
            }
            System.out.println("---------------------------");
        }
        else{
            System.out.println("There is no cash price records are available");
        }


        if (!carFinanceList.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("Finance record changes:");
            for (CanBeFinanced financeRecord : carFinanceList) {
                System.out.print(financeRecord.getCarReg() + " Cash Price: £" + financeRecord.getCashPrice());
                System.out.print("\t\tFinance duration: " + financeRecord.getFinanceDuration() + " months");
                System.out.printf("\t\tMonthly payment: £%.2f", financeRecord.getFinanceDurationMonthlyPayment());
                System.out.print("\t\tInterest rate: " + (CanBeFinanced.getFinanceInterestPercentage() * 100) + "%");
                System.out.println();
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("There is no finance information for any car available.");
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}
