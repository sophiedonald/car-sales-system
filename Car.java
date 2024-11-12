public class Car{
    private String carReg;
    private String carMake;
    private String carModel;
    private int carMileage;
    private int carAge;
    private String carColour;
    private String carFeatures;
    private static int carCount;
    

    public Car(String carReg, String carMake, String carModel/*, int carMileage, int carAge, String carColour, String carFeatures*/){
        this.carReg = carReg;
        this.carMake = carMake;
        this.carModel = carModel;
        // this.carMileage = carMileage;
        // this.carAge = carAge;
        // this.carColour = carColour;
        // this.carFeatures = carFeatures;

        carCount++;
    }

    public static int getCarCount() {
        return carCount;
    }

    // public String getToString() {
    //     return toString;
    // }

    // public void setToString(String toString) {
    //     this.toString = toString;
    // }


    public String toString() {
        return "Registration:\t" + carReg + "\nMake:\t\t" + carMake + "\nModel:\t\t" + carModel;
    }

}