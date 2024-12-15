package carsalessystem;

interface IDisplayDetails {
    String displayDetails(Car car);
}

public class Car implements IDisplayDetails {

    //create all fields for the car properties
    private String CarReg; //if naming static, then all cars have the same reg etc so must be non-static
    private String CarMake;
    private String CarModel;
    private int CarMileage;
    private int CarAge;
    private String CarColour;
    private String CarFeatures;
    private static int carCount;

    //constructor used to assign each property of the object
    public Car(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures) {
        this.CarReg = carReg.toUpperCase().replace(" ", "");
        this.CarMake = carMake.toUpperCase();
        this.CarModel = carModel.toUpperCase();
        this.CarMileage = carMileage;
        if (carAge > 1900) {
            this.CarAge = (2024 - carAge);
        } else {
            this.CarAge = carAge;
        }
        this.CarColour = (carColour == null ? "" : carColour.toUpperCase());
        this.CarFeatures = carFeatures == null ? "" : carFeatures.toUpperCase();

        carCount++;
    }

    //default constructor, used when no parameters are passed in
    public Car() {
        CarReg = null;
        CarMake = null;
        CarModel = null;
        CarMileage = -1;
        CarAge = -1;
        CarColour = null;
        CarFeatures = null;
    }

    public static int getCarCount() { //can be static because is in the class not the instances/objects
        return carCount;
    }

    public static void setCarCount(int incrementAmount) {
        carCount += incrementAmount;
    }

    //registration plate
    public String getCarReg() { //cannot be static because for the instances not the whole class
        return this.CarReg;
    }

    public void setCarReg(String reg) {
        this.CarReg = reg.toUpperCase().replace(" ", "");
    }

    //car make
    public String getCarMake() {
        return this.CarMake;
    }

    public void setCarMake(String make) {
        this.CarMake = make.toUpperCase();
    }

    //car model
    public String getCarModel() {
        return this.CarModel;
    }

    public void setCarModel(String model) {
        this.CarModel = model.toUpperCase();
    }

    //car mileage
    public int getCarMileage() {
        return this.CarMileage;
    }

    public void setCarMileage(int mileage) {
        this.CarMileage = mileage;
    }

    //car age
    public int getCarAge() {
        return this.CarAge;
    }

    public void setCarAge(int age) {
        if (age > 1900) {
            System.out.println("It looks like you've entered the year of registration rather than the age of the car. Don't worry, we've taken the age of the car to be " + (2024 - TryParseInt.tryParseInt(MenuSelection.userInput)));

            age = 2024 - age;
        }
        this.CarAge = age;
    }

    //car colour
    public String getCarColour() {
        return this.CarColour;
    }

    public void setCarColour(String colour) {
        if (!colour.isEmpty())
            this.CarColour = colour.toUpperCase();
    }

    //car features
    public String getCarFeatures() {
        return this.CarFeatures;
    }

    public void setCarFeatures(String features) {
        if (!features.isEmpty())
            this.CarFeatures = features.toUpperCase();
    }

    //override method to print all information formatted
    public String displayDetails(Car car) { //prints all information inline
        String carSummary;

        if (car.CarMileage == -1 && car.CarAge == -1) {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t\t" + car.CarMake + "\nModel:\t\t\t" + car.CarModel + "\nMileage:\nAge:\nColour:\t\t\t" + car.CarColour + "\nFeatures:\t\t" + car.CarFeatures;
        } else if (car.CarMileage == -1 && car.CarAge != -1) //implicit declarations to increase readability
        {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t\t" + car.CarMake + "\nModel:\t\t\t" + car.CarModel + "\nMileage:\nAge:\t\t\t" + car.CarAge + "\nColour:\t\t\t" + car.CarColour + "\nFeatures:\t\t" + car.CarFeatures;
        } else if (car.CarMileage != -1 && car.CarAge == -1) {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t\t" + car.CarMake + "\nModel:\t\t\t" + car.CarModel + "\nMileage:\t\t" + car.CarMileage + "\nAge:\nColour:\t\t\t" + car.CarColour + "\nFeatures:\t\t" + car.CarFeatures;
        } else {
            carSummary = "Registration:\t" + car.CarReg + "\nMake:\t\t\t" + car.CarMake + "\nModel:\t\t\t" + car.CarModel + "\nMileage:\t\t" + car.CarMileage + "\nAge:\t\t\t" + car.CarAge + "\nColour:\t\t\t" + car.CarColour + "\nFeatures:\t\t" + car.CarFeatures;
        }
        return carSummary; //single return statement
    }

    public boolean contains(Car car, String searchTerm) {
        boolean bool = getCarReg().contains(searchTerm)
                || getCarMake().contains(searchTerm)
                || getCarModel().contains(searchTerm)
                || (getCarAge() + "").contains(searchTerm)
                || (getCarMileage() + "").contains(searchTerm)
                || getCarColour().contains(searchTerm)
                || getCarFeatures().contains(searchTerm);

        //search through all the car fields for the searchterm which is passed in from the userinput
        return bool;
    }
}