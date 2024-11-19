public class Car{

    //create all fields for the car properties
    private String CarReg; //if naming static, then all cars have the same reg
    private String CarMake;
    private String CarModel;
    private int CarMileage;
    private int CarAge;
    private String CarColour;
    private String CarFeatures;
    private static int carCount;
    
    
    // private enum currentField{
    //     reg,
    //     make,
    //     model,
    //     mileage,
    //     age,
    //     colour,
    //     features
    // }

    //constructor
    public Car(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures){
        CarReg = carReg.toUpperCase();
        CarMake = carMake.toLowerCase();
        CarModel = carModel.toLowerCase();
        CarMileage = carMileage;
        CarAge = carAge;
        CarColour = carColour.toLowerCase();
        CarFeatures = carFeatures.toLowerCase();

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

    public static int getCarCount() { //can be static because is in the class not the instances/objects
        return carCount;
    }

    public String getCarReg(){ //cannot be static because for the instances not the whole class
        return this.CarReg;
    }

    public void setCarReg(String reg){
        this.CarReg = reg;
    }

    public String toString() { //prints all information inline
        return "Registration:\t" + CarReg + "\nMake:\t\t" + CarMake + "\nModel:\t\t" + CarModel + "\nMileage:\t" + CarMileage + "\nAge:\t\t" + CarAge + "\nColour:\t\t" + CarColour + "\nFeatures:\t" + CarFeatures;
    }

}