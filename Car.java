public class Car{

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
        this.CarMake = carMake.toLowerCase();
        this.CarModel = carModel.toLowerCase();
        this.CarMileage = carMileage;
        this.CarAge = carAge;
        this.CarColour = carColour.toLowerCase();
        this.CarFeatures = carFeatures.toLowerCase();

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
    public String toString() { //prints all information inline
        return "Registration:\t" + CarReg + "\nMake:\t\t" + CarMake + "\nModel:\t\t" + CarModel + "\nMileage:\t" + CarMileage + "\nAge:\t\t" + CarAge + "\nColour:\t\t" + CarColour + "\nFeatures:\t" + CarFeatures;
    }

}