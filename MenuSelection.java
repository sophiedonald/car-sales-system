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
        System.out.println("3: Check all current car fields are complete");
        System.out.println("4: Edit the details of a car");
        System.out.println("5: Display all cars with a certain make, model, mileage or colour");
        System.out.println("Which option would you like to choose? (type exit to exit Vroom Vroom Vault)");
        
        userInput = scanner.nextLine();
        

        switch (userInput){
            case "1" -> menuSelection1();
            case "2" -> menuSelection2();
            case "3" -> menuSelection3();
            case "4" -> menuSelection4();
            case "5" -> menuSelection5();
            case "exit" -> {
                System.out.println("Goodbye");
                exit = true;
            }
            default -> System.out.println("Invalid Option");
            
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

        System.out.println("Vroom Vroom Vault currently has " + Car.getCarCount() + " cars in stock. We have space for " + (maxCars - Car.getCarCount()) + "more cars.");
        
        if (Car.getCarCount() >= maxCars)
        {
            System.out.println("Sorry, we are unable to add a car at this time.");
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
                System.out.println("\nWould you like to add " + addField.tempCarDetails[0] + " to the Vroom Vroom Vault? y/n");
                userInput = scanner.nextLine();
                if (userInput.startsWith("y"))
                {
                    carDetailList.add(new Car(addField.tempCarDetails[0], addField.tempCarDetails[1], addField.tempCarDetails[2], TryParseInt.tryParseInt(addField.tempCarDetails[3]), TryParseInt.tryParseInt(addField.tempCarDetails[4]), addField.tempCarDetails[5], addField.tempCarDetails[6]));
                }
            }
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }//menuSelection2()

    private void menuSelection3(){

    }//menuSelection3

    private void menuSelection4(){

    }//menuSelection4

    private void menuSelection5(){

    }//
    
    // private void addField(){
    //     switch (field){
    //         case "reg":
    //             System.out.println("What is the registration plate of the car?");
    //             userInput = scanner.nextLine();
    //             Car.setCarReg(userInput);

    //         case "make":

    //         case "model":

    //         case "mileage":

    //         case "age":

    //         case "colour":

    //         case "feature":

    //     }
    // }
}