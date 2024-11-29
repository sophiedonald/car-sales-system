import java.util.Scanner;
interface addAllFields{
    public void addCarReg();
    public void addCarMake();
    public void addCarModel();
    public void addCarMileage();
    public void addCarAge();
    public void addCarColour();
    public void addCarFeatures();
}

public class AddField implements addAllFields{

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
            System.out.println("What is the registatration plate of the car you would like to add? *"); //required
            MenuSelection.userInput = scanner.nextLine().toUpperCase().replace(" ","");

            if(MenuSelection.userInput.trim().length() > 7)
            {
                System.out.println("A registration plate cannot be longer than 6 characters. Please make sure you enter the correct registration number.");
                validInput = false;
            }
            else if (!((MenuSelection.userInput == null) || MenuSelection.userInput.equalsIgnoreCase("")))
            {
                //for (Car c : MenuSelection.carDetailList)
                for (int i = 0 ; i < MenuSelection.carDetailList.size() ; i++) //using a for each gets a concurrentmodificationexception
                {
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
                    validInput = !MenuSelection.userInput.toUpperCase().startsWith("Y"); //validInput is true if userInput does not start with Y
                }
            }
            else
            {
                validInput = false;
            }
        } while (validInput == false);
    }

    public void addCarMake()
    {
        //Car car = new Car();
        do
        {
            System.out.println("What is the make of " + tempCarDetails[0] + "? *"); //required
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
            if (!((MenuSelection.userInput == null) || MenuSelection.userInput.equalsIgnoreCase("")))
            {
                tempCarDetails[1] = MenuSelection.userInput.trim();
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
            System.out.println("What is the model of " + tempCarDetails[0] + "? *"); //required
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
            if (!((MenuSelection.userInput == null) || MenuSelection.userInput.equalsIgnoreCase("")))
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
            System.out.println("What is the mileage of " + tempCarDetails[0] + "?"); //not required
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
            if (MenuSelection.userInput != null)
            {
                if(MenuSelection.userInput.equals(""))
                {
                    System.out.println("no entry recognised");
                    
                    
                }
                else if(TryParseInt.tryParseInt(MenuSelection.userInput) < 0 ) //includes -1 which is returned upon parse failure
                {
                    System.out.println("Invalid entry. Please make use of the (4: Check all fields are complete) or (5: Edit fields) options to amend this later on.");
                }
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

    public void addCarMileage(Car c) //overloaded method
    {
        while ( c.getCarMileage() < 0)
        {
            System.out.println("You have not yet entered a valid mileage for " + c.getCarReg() + ". Please do this now:");
            MenuSelection.userInput = scanner.nextLine();
            c.setCarMileage(TryParseInt.tryParseInt(MenuSelection.userInput));
        }
    }

    public void addCarAge()
    {
        do
        {
            System.out.println("What is the age of " + tempCarDetails[0] + "?"); //not required
            MenuSelection.userInput = scanner.nextLine();
            if (MenuSelection.userInput != null)
            {
                if(TryParseInt.tryParseInt(MenuSelection.userInput) < 0) //includes -1 which is returned upon parse failure
                {
                    System.out.println("Invalid entry. Please make use of the (4: Check all fields are complete) or (5: Edit fields) options to amend this later on.");
                }
                else if (TryParseInt.tryParseInt(MenuSelection.userInput) > 1900)
                {
                    System.out.println("It looks like you've entered the year of registration rather than the age of the car. Don't worry, we've taken the age of the car to be " + (2024 - TryParseInt.tryParseInt(MenuSelection.userInput)));
                    tempCarDetails[4] = "" + (2024 - TryParseInt.tryParseInt(MenuSelection.userInput));
                }
                else
                {
                    tempCarDetails[4] = MenuSelection.userInput;
                }
                validInput = true;
            }
            else
            {
                validInput = false;
            }
        }
        while (validInput == false);
    }

    public void addCarAge(Car c) //overloaded method
    {
        while (c.getCarAge() < 0)
        {
            System.out.println("You have not yet entered a valid age for " + c.getCarReg() + ". Please do this now:"); //not required
            MenuSelection.userInput = scanner.nextLine();
            c.setCarAge(TryParseInt.tryParseInt(MenuSelection.userInput));
        }
    }

    
    public void addCarColour()
    {
        do
        {
            System.out.println("What is the colour of " + tempCarDetails[0] + "?"); //not required
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
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
            System.out.println("What are the features of " + tempCarDetails[0] + "?"); //not required
            MenuSelection.userInput = scanner.nextLine().toUpperCase();
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
