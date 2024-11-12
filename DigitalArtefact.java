
import java.util.Scanner;

public class DigitalArtefact{

    public static int maxCars;
    public static int carCount;
    public static String userInput;
    static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            {
                Car myCar = new Car("HL68 CDK", "Renault", "Clio");
                Car myCar2 = new Car("ML12 GZO", "Vauxhall", "Corsa");
    
                System.out.println("Welcome to the Vroom Vroom Vault! Your main options are: ");
                System.out.println("1: List all of our current car information");
                System.out.println("2: Add a new car to the Vroom Vroom Vault");
                System.out.println("3: Check all current car fields are complete");
                System.out.println("4: Edit the details of a car");
                System.out.println("5: Display all cars with a certain make, model, mileage or colour");
                System.out.println("Which option would you like to choose? (type exit to exit Vroom Vroom Vault)");
    
                userInput = scanner.nextLine();

                switch (userInput){
                    case "1":
                        MenuSelection menuSelection1 = new MenuSelection();
                        menuSelection1.menuSelection1();
                        break;
                    case "2":
                        MenuSelection menuSelection2 = new MenuSelection();
                        menuSelection2.menuSelection2();
                        break;
                    case "3":
                        MenuSelection menuSelection3 = new MenuSelection();
                        menuSelection3.menuSelection3();
                        break;
                    case "4":
                        MenuSelection menuSelection4 = new MenuSelection();
                        menuSelection4.menuSelection4();
                        break;
                    case "5":
                        MenuSelection menuSelection5 = new MenuSelection();
                        menuSelection5.menuSelection5();
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                    
                }





            //System.out.println(myCar.toString());
            //System.out.println(myCar2.toString());
        }
    }

    // private static void menuSelection1() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }
}