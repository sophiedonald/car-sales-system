

public class Car{
    private String carReg; //if naming static, then all cars have the same reg
    private String carMake;
    private String carModel;
    private int carMileage;
    private int carAge;
    private String carColour;
    private String carFeatures;
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

    public Car(String carReg, String carMake, String carModel, int carMileage, int carAge, String carColour, String carFeatures){
        this.carReg = carReg.toUpperCase();
        this.carMake = carMake.toLowerCase();
        this.carModel = carModel.toLowerCase();
        this.carMileage = carMileage;
        this.carAge = carAge;
        this.carColour = carColour.toLowerCase();
        this.carFeatures = carFeatures.toLowerCase();

        carCount++;
    }

    public static int getCarCount() {
        return carCount;
    }

    // public void setCarReg(String reg){
    //     this.carReg = reg;
    // }
    // public void setCarMake(){
    //     this.carMake = MenuSelection.userInput;
    // }
    // public void setCarModel(){
    //     this.carModel = MenuSelection.userInput;
    // }
    // public void setCarMileage(){
        
        
    // }
    // public void setCarAge(){
    //     this.carReg = MenuSelection.userInput;
    // }
    // public void setCarColour(){
    //     this.carColour = MenuSelection.userInput;
    // }
    // public void setCarFeatures(){
    //     this.carFeatures = MenuSelection.userInput;
    // }







    // public String getToString() {
    //     return toString;
    // }

    // public void setToString(String toString) {
    //     this.toString = toString;
    // }


    public String toString() {
        return "Registration:\t" + carReg + "\nMake:\t\t" + carMake + "\nModel:\t\t" + carModel + "\nMileage:\t" + carMileage + "\nAge:\t\t" + carAge + "\nColour:\t\t" + carColour + "\nFeatures:\t" + carFeatures;
    }

}