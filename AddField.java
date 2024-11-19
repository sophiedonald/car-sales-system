import java.util.Scanner;

public class AddField {

    Scanner scanner = new Scanner(System.in);
    private boolean validInput = false;
    public boolean duplicateCar = false;

    

    public void addCarReg()
    {
        Car car = new Car();
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
                    Car c = MenuSelection.carDetailList.get(i);
                    String currentReg = c.getCarReg();
                    if (MenuSelection.userInput.toUpperCase().replace(" ", "").equals(currentReg))
                    {
                        System.out.println("Sorry, this car has already been added.");
                        duplicateCar = true;
                        validInput = true;
                        
                    }
                    else
                    {
                        MenuSelection.carDetailList.add(new Car());
                        car.setCarReg(MenuSelection.userInput);
                    }
                }
            }

        } while (validInput == false);
    }

    public void addCarMake()
    {

    }

    public void addCarModel()
    {

    }

    public void addCarMileage()
    {

    }
    public void addCarAge()
    {

    }
    
    public void addCarColour()
    {

    }

    public void addCarFeatures()
    {

    }
}
