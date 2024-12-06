package carsalessystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelection {

    Car c = new Car();
    public static boolean exit = false;
    public static ArrayList<Car> carDetailList = new ArrayList<>(); //create a list to store each instance of the class Car
    private final int maxCars = 10; //maximum amount of cars which can be in stock, not going to change throughout programme
    //private final String[] currentField = {"registration plate", "make", "model", "mileage", "age", "colour", "feature"};
    //private String field;
    public static ArrayList<CanBeSold> carCashPriceList = new ArrayList<>();
    public static ArrayList<CanBeFinanced> carFinanceList = new ArrayList<>();

    //CanBeSold canBeSold = new CanBeSold();

    private boolean anotherCar = true;


    public Scanner scanner = new Scanner(System.in);
    public static String userInput;



    public void mainMenu(){ //method to print the menu
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
        

        switch (userInput){
            case "1": menuSelection1(); break;
            case "2": menuSelection2(); break;
            case "3": menuSelection3(); break;
            case "4": menuSelection4(); break;
            case "5": menuSelection5(); break;
            case "6": menuSelection6(); break;
            case "7": menuSelection7(); break;
            case "8": menuSelection8(); break;
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

    private void menuSelection1(){
        System.out.println("You have chosen option 1: display all current car information. We currently have " + Car.getCarCount() + " cars in stock.");
        for(Car car : carDetailList){

            System.out.println(car.displayDetails(car));

            System.out.println();
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSeleciton1()

    private void menuSelection2(){

        AddField addField = new AddField();

        System.out.println("You have chosen option 2: add a new car to the Vroom Vroom Vault.");

        System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock. We have space for " + (maxCars - Car.getCarCount()) + " more cars.");
        
        if (Car.getCarCount() >= maxCars)
        {
            System.out.println("Sorry, Vroom Vroom Vault is full. A car needs to be sold before another car can be added.");
            anotherCar = false;
        }

        if (anotherCar && Car.getCarCount() < maxCars)
        {
            // carDetailList.add(new Car());
            addField.addCarReg();
            if (addField.duplicateCar == false)
            {
                addField.addCarMake();
                addField.addCarModel();
                addField.addCarMileage();
                addField.addCarAge();
                addField.addCarColour();
                addField.addCarFeatures();

                carDetailList.add(new Car(addField.tempCarDetails[0], addField.tempCarDetails[1], addField.tempCarDetails[2], TryParseInt.tryParseInt(addField.tempCarDetails[3]), TryParseInt.tryParseInt(addField.tempCarDetails[4]), addField.tempCarDetails[5], addField.tempCarDetails[6]));
                

                System.out.println("Press enter to view a summary of " + addField.tempCarDetails[0]);
                scanner.nextLine();

                System.out.println(c.displayDetails(carDetailList.get(carDetailList.size() - 1 )));

                //System.out.println("Registration:\t" + addField.tempCarDetails[0] + "\nMake:\t\t" + addField.tempCarDetails[1] + "\nModel:\t\t" + addField.tempCarDetails[2] + "\nMileage:\t" + addField.tempCarDetails[3] + "\nAge:\t\t" + addField.tempCarDetails[4] + "\nColour:\t\t" + addField.tempCarDetails[5] + "\nFeatures:\t" + addField.tempCarDetails[6]);
                
                do{
                    System.out.println("\nWould you like to add " + addField.tempCarDetails[0] + " to the Vroom Vroom Vault? y/n");
                    userInput = scanner.nextLine();
                    if (userInput.startsWith("y"))
                    {
                        // carDetailList.add(new Car(addField.tempCarDetails[0], addField.tempCarDetails[1], addField.tempCarDetails[2], TryParseInt.tryParseInt(addField.tempCarDetails[3]), TryParseInt.tryParseInt(addField.tempCarDetails[4]), addField.tempCarDetails[5], addField.tempCarDetails[6]));
                        System.out.println(addField.tempCarDetails[0] + " has successfully been added to the Vroom Vroom Vault");
                    }
                    else if (userInput.startsWith("n"))
                    {
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
    }//menuSelection2()

    private void menuSelection3(){ //Delete
        System.out.println("You have chosen option 3: delete a car from the Vroom Vroom Vault.");

        if (!carDetailList.isEmpty())
        {
            System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock:");
            for (Car car : carDetailList){
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
            } catch (IndexOutOfBoundsException ex)
            {
                System.out.println("Sorry, this car does not exist.");
            }
        }
        else
        {
            System.out.println("Vroom Vroom Vault currently has 0 cars in stock. You cannot delete a car at this time.");
        }

        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection3

    private void menuSelection4(){ //Check
        AddField addField = new AddField();
        System.out.println("You have chosen option 4: check all current car fields are complete");

        for (Car car : carDetailList)
        {
            addField.addCarMileage(car);
            addField.addCarAge(car);
        }
        
        System.out.println("All checks complete");
        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection4

    private void menuSelection5(){ //Edit
        System.out.println("You have chosen option 5: edit the details of a car");

        System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock:");
        for (Car car : carDetailList){
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
            if (!userInput.equals(""))
            {
                editCar.setCarReg(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new make of " + editCar.getCarReg() +". If you would not like to edit the make, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals(""))
            {
                editCar.setCarMake(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new model of " + editCar.getCarReg() +". If you would not like to edit the model, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals(""))
            {
                editCar.setCarModel(userInput.toUpperCase().replace(" ", ""));
            }

            System.out.println("Please enter the new mileage of " + editCar.getCarReg() +". If you would not like to edit the mileage, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals(""))
            {
                editCar.setCarMileage(TryParseInt.tryParseInt(userInput));
            }

            System.out.println("Please enter the new age of " + editCar.getCarReg() +". If you would not like to edit the age, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals(""))
            {
                editCar.setCarAge(TryParseInt.tryParseInt(userInput));
            }

            System.out.println("Please enter the new features of " + editCar.getCarReg() +". If you would not like to edit the features, press enter.");
            userInput = scanner.nextLine().trim();
            if (!userInput.equals(""))
            {
                editCar.setCarFeatures(userInput.toUpperCase().replace(" ", ""));
            }
            System.out.println("Edits complete");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Sorry, this car does not exist.");
            
        }

        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//

    private void menuSelection6(){ //Search
        int numberOfMatches = 0;
        System.out.println("You have chosen option 6: search through Vroom Vroom Vault");

        System.out.println("Please enter search term:");
        userInput = scanner.nextLine().toUpperCase();

        for (Car car : carDetailList)
        {
            if(car.contains(car, userInput))
            {
                System.out.println("---------------------------");
                System.out.println(car.displayDetails(car));
                System.out.println("---------------------------");
                numberOfMatches++;
            }
            else{
                System.out.println(car.getCarReg() + " does not contain " + userInput);
            }
        }
        if(numberOfMatches == 1)
            System.out.println(numberOfMatches + " match found for search term: " + userInput);
        else
            System.out.println(numberOfMatches + " matches found for search term: " + userInput);


        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    private void menuSelection7(){ //view finance information

        int indexToView;
        String regToUseAsID;
        Car carToAccessFinanceInfo;

        ArrayList<CanBeSold> cashRecordsWithMatchingReg = new ArrayList<>();
        ArrayList<CanBeFinanced> financeRecordsWithMatchingReg = new ArrayList<>();
        CanBeSold carToBeViewed;

        CanBeSold canBeSold = new CanBeSold();
        CanBeFinanced canBeFinanced = new CanBeFinanced();

        for (Car car : carDetailList){
            System.out.print((carDetailList.indexOf(car) + 1) + ": ");
            System.out.println(car.getCarReg());
            
        }
        System.out.println("Which car would you like to access finance information for? (1 - " + carDetailList.size() + ").");
        userInput = scanner.nextLine();

        try {
            indexToView = TryParseInt.tryParseInt(userInput) - 1;
            carToAccessFinanceInfo = carDetailList.get(indexToView);
            regToUseAsID = carDetailList.get((indexToView)).getCarReg();
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Sorry, this car does not exist.");
            System.out.println("Press enter to continue");
            scanner.nextLine();
            return;
        }


        for (CanBeSold CBS : carCashPriceList)
        {
            if(CBS.getCarReg().equals(regToUseAsID))
            {
                cashRecordsWithMatchingReg.add(CBS);
            }
        }

        if(cashRecordsWithMatchingReg.isEmpty())
        {
            do
            {
                System.out.println(carDetailList.get((indexToView)).getCarReg() + " does not have a cash price uploaded yet, would you like to add one now? y/n");
                userInput = scanner.nextLine().toUpperCase();
                if(userInput.startsWith("Y"))
                {
                    canBeSold.AddCashPrice(carToAccessFinanceInfo);
                    //System.out.println("method to add finance info");
                    canBeFinanced.AddFinanceInfo(carCashPriceList.getLast());
                }
                else if(userInput.startsWith("N"))
                {
                    //System.out.println("does not want to add finance info");
                }
            }while (!(userInput.startsWith("N") || userInput.startsWith("Y")));
        }
        else //if there are existing records for this reg
        {
            carToBeViewed = cashRecordsWithMatchingReg.getLast();
            System.out.println("Press enter to view latest finance options for " + carDetailList.get((indexToView)).getCarReg() + ".");
            scanner.nextLine();
            System.out.println(carToBeViewed.displayDetails(carToBeViewed));

            do{
                System.out.println("Would you like to change the cash price for " + carToBeViewed.getCarReg() + "? y/n");
                userInput = scanner.nextLine().toUpperCase();

                if(userInput.equals("Y"))
                {
                    boolean valid = false;
                    do
                    {
                        try
                        {
                            System.out.println("Enter new cash price:");
                            double newCashPrice = scanner.nextDouble();
                            scanner.nextLine();
                            if (newCashPrice <= 0)
                            {
                                throw new InputMismatchException();
                            }
                            carCashPriceList.add(new CanBeSold(newCashPrice, carToAccessFinanceInfo));
                            valid = true;
                        }
                        catch (InputMismatchException ex)
                        {
                            scanner.nextLine();
                        }
                    }
                    while(!valid);
                }
            }
            while (!(userInput.startsWith("Y") || userInput.startsWith("N")));

            for (CanBeFinanced CBF : carFinanceList)
            {
                if(CBF.getCarReg().equals(regToUseAsID))
                {
                    financeRecordsWithMatchingReg.add(CBF);
                }
            }

            if(financeRecordsWithMatchingReg.isEmpty()){
                System.out.println(carDetailList.get((indexToView)).getCarReg() + " does not have finance info uploaded yet, would you like to add some now? y/n");
                userInput = scanner.nextLine().toUpperCase();
                do
                    {
                    if(userInput.startsWith("Y"))
                    {
                        //canBeSold.AddCashPrice(carToAccessFinanceInfo);
                        canBeFinanced.AddFinanceInfo(cashRecordsWithMatchingReg.getLast());
                        //System.out.println("method to add finance info");
                    }
                    else if(userInput.startsWith("N"))
                    {
                        //System.out.println("does not want to add finance info");
                    }
                }while (!(userInput.startsWith("N") || userInput.startsWith("Y")));
            }
        }

       

        

        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuselection7

    
    public void menuSelection8(){
        if(!carCashPriceList.isEmpty()){
            for (CanBeSold cBS : carCashPriceList)
            {
                System.out.print(cBS.displayDetails(cBS));
                for (int i = 0 ; i < carFinanceList.size() ; i++) //use this to add the display finance info on option 8
                {
                    System.out.print("in for loop");
                    if (cBS.getCarReg().equals(carFinanceList.get(i).getCarReg()) && (cBS.getCashPrice() == carFinanceList.get(i).getCashPrice()))
                    {
                        System.out.print("Finance Duration: " + carFinanceList.get(i).getFinanceDuration());
                    }
                }
                System.out.println();
            }      
        }
        else{
            System.out.println("There is no finance information for any car available.");
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }





    // private void menuSelection8(){ //add or edit finance information

    //     int editFinanceInfo;
    //     CanBeSold canBeSold = new CanBeSold();

    //     for (Car car : carDetailList){
    //         System.out.print((carDetailList.indexOf(car) + 1) + ": ");
    //         System.out.println(car.getCarReg());
    //     }
    //     System.out.println("Which car would you like to add finance information to? (1 - " + carDetailList.size() + "). Press any other key to cancel");
    //     userInput = scanner.nextLine();

    //     try {
    //         editFinanceInfo = TryParseInt.tryParseInt(userInput) - 1;
    //     }
    //     catch (IndexOutOfBoundsException ex)
    //     {
    //         System.out.println("Sorry, this car does not exist.");
    //         System.out.println("Press enter to continue");
    //         scanner.nextLine();
    //         return;
    //     }

    //     //if (canBeSold.getCashPrice() != 0d)
    //         //{
    //             double newCashPrice = 0;
    //             System.out.printf("Cash price (%s): £%.2f%n", carDetailList.get(editFinanceInfo).getCarReg(), canBeSold.getCashPrice());
    //             do
    //             {
    //                 System.out.println("Would you like to change this? y/n");
    //                 userInput = scanner.nextLine().trim().toUpperCase();
                    
    //             }
    //             while(!(userInput.equals("Y") || userInput.equals("N")));
    //             if(userInput.equals("Y"))
    //             {
    //                 boolean valid = false;
    //                 do
    //                 {
    //                     try
    //                     {
    //                         System.out.println("Enter new cash price:");
    //                         newCashPrice = scanner.nextDouble();
    //                         scanner.nextLine();
    //                         valid = true;
    //                     }
    //                     catch (InputMismatchException ex)
    //                     {
    //                         valid = false;
    //                         scanner.nextLine();
                            
    //                     }
    //                 }
    //                 while(!valid);
    //             }
    //             System.out.printf("Cash price for %s has successfully been set to £%.2f", carDetailList.get(editFinanceInfo).getCarReg(), newCashPrice);
                
    //             int newFinanceDuration = 24;
    //             // ? System.out.printf("\nFinance duration (%s): %s months", carDetailList.get(editFinanceInfo).getCarReg(), canBeSold.getFinanceDuration());
    //             do
    //             {
    //                 System.out.println("\nWould you like to change this? y/n");
    //                 userInput = scanner.nextLine().trim().toUpperCase();
                    
    //             }
    //             while(!(userInput.equals("Y") || userInput.equals("N")));
    //             if(userInput.equals("Y"))
    //             {
    //                 boolean valid = false;
    //                 do
    //                 {
    //                     try
    //                     {
    //                         System.out.println("Enter new duration:");
    //                         newFinanceDuration = scanner.nextInt();
    //                         valid = true;
    //                     }
    //                     catch (InputMismatchException ex)
    //                     {
    //                         valid = false;
    //                         scanner.nextLine();
                            
    //                     }
    //                 }
    //                 while(!valid);
    //             }
    //             // canBeSold.setFinanceDuration(newFinanceDuration);
    //             // ? carCashPriceList.add(new CanBeSold(carDetailList.get(editFinanceInfo), newCashPrice, newFinanceDuration));
    //             // canBeSold.setCashPrice(newCashPrice);
                
            //}
            //else
            // {
                // System.out.println("add section here");
            // }

        

        
        // boolean carIsCanBeSold = false;
        // for (CanBeSold caneSold : carCashPriceList)
        // {
        //     for (Car car : carDetailList)
        //     {
        //         if(car.getCarReg().equals(canBeSold.getCarReg()))
        //         {
        //             carIsCanBeSold = true;
        //             return;
        //         }
        //         else
        //         {
        //             System.out.println("no finance info found");
        //         }
        //     }
        // }

        // if(carIsCanBeSold)
        // {
        //     System.out.println("Currently in finance edit mode for " + carDetailList.get((editFinanceInfo)).getCarReg() + ".");
        //     //System.out.printf("Cash price (" + carDetailList.get((editFinanceInfo)).getCarReg() + "): %.2f" + canBeSold.getCashPrice());
        //     if (canBeSold.getCashPrice() != 0d)
        //     {
        //         System.out.printf("Cash price (%s): £%.2f%n", carDetailList.get(editFinanceInfo).getCarReg(), canBeSold.getCashPrice());
        //         do
        //         {
        //             System.out.println("Would you like to change this? y/n");
        //             userInput = scanner.nextLine().trim().toUpperCase();
                    
        //         }
        //         while(!(userInput.equals("Y") || userInput.equals("N")));
        //         if(userInput.equals("Y"))
        //         {
        //             boolean valid = false;
        //             double newCashPrice;
        //             do
        //             {
        //                 try
        //                 {
        //                     System.out.println("Enter new cash price:");
        //                     newCashPrice = scanner.nextDouble();
        //                     canBeSold.setCashPrice(newCashPrice);
        //                     valid = true;
        //                 }
        //                 catch (InputMismatchException ex)
        //                 {
        //                     valid = false;
        //                     scanner.nextLine();
        //                 }
        //             }
        //             while(!valid);
        //         }
        //     }
        //     else
        //     {
        //         System.out.println("add finance info here");
        //     }
        // }

        // System.out.println("COMING SOON");
        // System.out.println("Press enter to continue");
        // scanner.nextLine();
    }//menuselection8
