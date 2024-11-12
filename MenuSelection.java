import java.util.ArrayList;
import java.util.Scanner;

public class MenuSelection {

    public static boolean exit = false;
    public static ArrayList<Car> carDetailList = new ArrayList<>();
    private final int maxCars = 10;

    public Scanner scanner = new Scanner(System.in);
    private String userInput;


    public void mainMenu(){
        System.out.println("Your main options are: ");
                System.out.println("1: List all of our current car information");
                System.out.println("2: Add a new car to the Vroom Vroom Vault");
                System.out.println("3: Check all current car fields are complete");
                System.out.println("4: Edit the details of a car");
                System.out.println("5: Display all cars with a certain make, model, mileage or colour");
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
                    case "exit":
                        System.out.println("Goodbye");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                    
                }
    }

    private void menuSelection1(){
        //Car c = new Car("","","",Car.getCarCount());
        System.out.println("You have chosen option 1: display all current car information. We currently have " + Car.getCarCount() + " cars in stock.");
        for(Car car : carDetailList){
            if (car.toString().equals(""))
            {
                System.out.println(car.toString());
            }
            System.out.println();
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
    private void menuSelection2(){
        System.out.println("You have chosen option 2: add a new car to the Vroom Vroom Vault.");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
    private void menuSelection3(){

    }
    private void menuSelection4(){

    }
    private void menuSelection5(){

    }
}