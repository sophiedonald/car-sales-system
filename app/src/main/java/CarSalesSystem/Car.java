package carsalessystem;

interface IDisplayDetails{
    public String displayDetails(Car car);
}

public class Car implements IDisplayDetails{

    //create all fields for the car properties
    private String CarReg; //if naming static, then all cars have the same reg etc
    private String CarMake;
    private String CarModel;
    private int CarMileage;
    private int CarAge;
    private String CarColour;
    private String CarFeatures;
    private static int carCount;

    //constructor used to assign each property of the object
    public Car(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures){
        this.CarReg = carReg.toUpperCase();
        this.CarMake = carMake.toUpperCase();
        this.CarModel = carModel.toUpperCase();
        this.CarMileage = carMileage;
        if(carAge > 1900)
        {
            this.CarAge = (2024 - carAge);
        }
        else
        {
            this.CarAge = carAge;
        }
        this.CarColour = carColour.toUpperCase();
        this.CarFeatures = carFeatures.toUpperCase();

        carCount++;
    }
    //default constructor, used when no parameters are passed in
    public Car()
    {
        CarReg = null;
        CarMake = null;
        CarModel = null;
        CarMileage = -1;
        CarAge = -1;
        CarColour = null;
        CarFeatures = null;
    }

    //getters and setters to securely access the values stored in Car objects
    public static int getCarCount() { //can be static because is in the class not the instances/objects
        return carCount;
    }
    public static void setCarCount(int incrementAmount)
    {
        carCount += incrementAmount;
    }

    //registration plate
    public String getCarReg(){ //cannot be static because for the instances not the whole class
        return this.CarReg;
    }
    public void setCarReg(String reg){
        this.CarReg = reg;
    }

    //car make
    public String getCarMake(){
        return this.CarMake;
    }
    public void setCarMake(String make){
        this.CarMake = make;
    }

    //car model
    public String getCarModel(){
        return this.CarModel;
    }
    public void setCarModel(String model){
        this.CarModel = model;
    }

    //car mileage
    public int getCarMileage(){
        return this.CarMileage;
    }
    public void setCarMileage(int mileage){
        this.CarMileage = mileage;
    }

    //car age
    public int getCarAge(){
        return this.CarAge;
    }
    public void setCarAge(int age){
        if (age > 1900)
        {
            System.out.println("It looks like you've entered the year of registration rather than the age of the car. Don't worry, we've taken the age of the car to be " + (2024 - TryParseInt.tryParseInt(MenuSelection.userInput)));

            age = 2024 - age;
        }
        this.CarAge = age;
    }

    //car colour
    public String getCarColour(){
        return this.CarColour;
    }
    public void setCarColour(String colour){
        this.CarColour = colour;
    }

    //car features
    public String getCarFeatures(){
        return this.CarFeatures;
    }
    public void setCarFeatures(String features){
        this.CarFeatures = features;
    }

    //override method to print all information formatted
    public String displayDetails(Car car) { //prints all information inline
        String carSummary;

        if (car.CarMileage == -1 && car.CarAge == -1)
        {
            carSummary =  "Registration:\t" + car.CarReg + "\nMake:\t\t" + car.CarMake + "\nModel:\t\t" + car.CarModel + "\nMileage:\nAge:\nColour:\t\t" + car.CarColour + "\nFeatures:\t" + car.CarFeatures;
        }
        else if (car.CarMileage == -1 && car.CarAge != -1)
        {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t" + car.CarMake + "\nModel:\t\t" + car.CarModel + "\nMileage:\nAge:\t\t" + car.CarAge + "\nColour:\t\t" + car.CarColour + "\nFeatures:\t" + car.CarFeatures;
        }
        else if(car.CarMileage != -1 && car.CarAge == -1)
        {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t" + car.CarMake + "\nModel:\t\t" + car.CarModel + "\nMileage:\t" + car.CarMileage + "\nAge:\nColour:\t\t" + car.CarColour + "\nFeatures:\t" + car.CarFeatures;
        }
        else
        {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t" + car.CarMake + "\nModel:\t\t" + car.CarModel + "\nMileage:\t" + car.CarMileage + "\nAge:\t\t" + car.CarAge + "\nColour:\t\t" + car.CarColour + "\nFeatures:\t" + car.CarFeatures;
        }
        return carSummary;
    }

    public boolean contains(Car car, String searchTerm){
        boolean bool = false;
        // for (Object property : carProperties.values()) {
        //     if (property.toString().contains(searchTerm))
        //     {
        //         bool = true;
        //         break;
        //     }
        //     else
        //     {
        //         bool = false;
        //     }
        // }
        
        if (getCarReg().contains(searchTerm)
            || getCarMake().contains(searchTerm)
            || getCarModel().contains(searchTerm)
            || (getCarAge() + "").contains(searchTerm)
            || (getCarMileage() + "").contains(searchTerm)
            || getCarColour().contains(searchTerm)
            || getCarFeatures().contains(searchTerm))
        {
            bool = true;
        }
        return bool;
    }

    // public void amend(Car carToBeAmended, CanBeSold canBeSold){

    // }
}