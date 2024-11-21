import java.util.ArrayList;
import java.util.Scanner;

public class MenuSelection {

    // Car car = new Car();
    public static boolean exit = false;
    public static ArrayList<Car> carDetailList = new ArrayList<>(); //create a list to store each instance of the class Car
    private final int maxCars = 10; //maximum amount of cars which can be in stock, not going to change throughout programme
    //private final String[] currentField = {"registration plate", "make", "model", "mileage", "age", "colour", "feature"};
    //private String field;

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
        System.out.println("6: Display all cars with a certain make, model, mileage or colour");
        System.out.println("Which option would you like to choose? (type exit to exit Vroom Vroom Vault)");
        
        userInput = scanner.nextLine();
        

        switch (userInput){
            case "1":
                menuSelection1();
                break;
            case "2":
                menuSelection2();
                break;
            case "3":
                menuSelection3();
                break;
            case "4":
                menuSelection4();
                break;
            case "5":
                menuSelection5();
                break;
            case "6":
                menuSelection6();
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
            //if (!(car.toString().equals("")))
            //{
                System.out.println(car.toString());
            //}
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
                System.out.println("hi");
                addField.addCarMake();
                addField.addCarModel();
                addField.addCarMileage();
                addField.addCarAge();
                addField.addCarColour();
                addField.addCarFeatures();

                System.out.println("Press enter to view a summary of " + addField.tempCarDetails[0]);
                scanner.nextLine();

                System.out.println("Registration:\t" + addField.tempCarDetails[0] + "\nMake:\t\t" + addField.tempCarDetails[1] + "\nModel:\t\t" + addField.tempCarDetails[2] + "\nMileage:\t" + addField.tempCarDetails[3] + "\nAge:\t\t" + addField.tempCarDetails[4] + "\nColour:\t\t" + addField.tempCarDetails[5] + "\nFeatures:\t" + addField.tempCarDetails[6]);
                
                do{
                    System.out.println("\nWould you like to add " + addField.tempCarDetails[0] + " to the Vroom Vroom Vault? y/n");
                    userInput = scanner.nextLine();
                    if (userInput.startsWith("y"))
                    {
                        carDetailList.add(new Car(addField.tempCarDetails[0], addField.tempCarDetails[1], addField.tempCarDetails[2], TryParseInt.tryParseInt(addField.tempCarDetails[3]), TryParseInt.tryParseInt(addField.tempCarDetails[4]), addField.tempCarDetails[5], addField.tempCarDetails[6]));
                        System.out.println(addField.tempCarDetails[0] + " has successfully been added to the Vroom Vroom Vault");
                        addField.tempCarDetails = null;
                    }
                    else if (userInput.startsWith("n"))
                    {
                        addField.tempCarDetails = null;
                    }
                }
                while (!(userInput.startsWith("y") || userInput.startsWith("n")));
                
            }
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection2()

    private void menuSelection3(){ //Delete
        System.out.println("You have chosen option 3: delete a car from the Vroom Vroom Vault.");

        if (carDetailList.size() > 0)
        {
            System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock:");
            for (Car c : carDetailList){
                System.out.print((carDetailList.indexOf(c) + 1) + ": ");
                System.out.println(c.getCarReg());
                
            }
            System.out.println("Which car would you like to delete? (1 - " + carDetailList.size() + ")");
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
        else{
            System.out.println("Vroom Vroom Vault currently has 0 cars in stock. You cannot delete a car at this time.");
        }


        //System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection3

    private void menuSelection4(){ //Check
        System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection4

    private void menuSelection5(){ //Edit
        System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//

    private void menuSelection6(){ //Search
        System.out.println("COMING SOON");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}