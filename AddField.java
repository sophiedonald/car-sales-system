import java.util.Scanner;

public class AddField {

    Scanner scanner = new Scanner(System.in);
    private boolean validInput = false;
    public boolean duplicateCar = false;

    public String[] tempCarDetails = new String[7];

    //Car car = new Car();

    //private String currentCar;

    public void addCarReg()
    {
        //Car car = new Car();
        do { 
            System.out.println("What is the registatration plate of the car?");
            MenuSelection.userInput = scanner.nextLine().toUpperCase().replace(" ","");

            if(MenuSelection.userInput.trim().length() > 7)
            {
                System.out.println("A registration plate cannot be longer than 6 characters. Please make sure you enter the correct registration number.");
                validInput = false;
            }
            else
            {
                //for (Car c : MenuSelection.carDetailList)
                for (int i = 0 ; i < MenuSelection.carDetailList.size() ; i++) //using a for each gets a concurrentmodificationexception
                {
                    System.out.println(MenuSelection.carDetailList.size());
                    Car c = MenuSelection.carDetailList.get(i);
                    //String currentReg = c.getCarReg();
                    if (MenuSelection.userInput.equals(c.getCarReg()))
                    {
                        System.out.println("Sorry, this car has already been added.");
                        duplicateCar = true;
                        break;
                    }
                    else
                    {
                        duplicateCar = false;
                    }
                }
                if(duplicateCar == false)
                {
                    // MenuSelection.carDetailList.add(new Car());
                    // car.setCarReg(MenuSelection.userInput);
                    tempCarDetails[0] = MenuSelection.userInput;
                    //currentCar = MenuSelection.userInput;
                    validInput = true;
                }
                else
                {
                    System.out.println("Do you want to add another car? y/n");
                    MenuSelection.userInput = scanner.nextLine();
                    if(MenuSelection.userInput.toLowerCase().startsWith("y"))
                    {
                        validInput = false;
                    }
                    else{
                        validInput = true;
                    }
                }
            }
        } while (validInput == false);
    }

    public void addCarMake()
    {
        //Car car = new Car();
        do
        {
            System.out.println("What is the make of " + tempCarDetails[0] + "?");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                tempCarDetails[1] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }

    public void addCarModel()
    {
        do
        {
            System.out.println("What is the model of " + tempCarDetails[0] + "?");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                tempCarDetails[2] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }

    public void addCarMileage()
    {
        do
        {
            System.out.println("What is the mileage of " + tempCarDetails[0] + "? (enter idk if not known)");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                tempCarDetails[3] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }
    public void addCarAge()
    {
        do
        {
            System.out.println("What is the age of " + tempCarDetails[0] + "? (enter idk if not known)");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                if (TryParseInt.tryParseInt(MenuSelection.userInput) > 1900)
                {
                    System.out.println("It looks like you've entered the year of registration rather than the age of the car. Don't worry, we've taken the age of the car to be " + (2024 - TryParseInt.tryParseInt(MenuSelection.userInput)));
                }
                tempCarDetails[4] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }
    
    public void addCarColour()
    {
        do
        {
            System.out.println("What is the colour of " + tempCarDetails[0] + "? (enter idk if not known)");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                tempCarDetails[5] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }

    public void addCarFeatures()
    {
        do
        {
            System.out.println("What are the features of " + tempCarDetails[0] + "? (enter idk if not known)");
            MenuSelection.userInput = scanner.nextLine().toLowerCase();
            if (MenuSelection.userInput != null)
            {
                tempCarDetails[6] = MenuSelection.userInput;
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }
}
