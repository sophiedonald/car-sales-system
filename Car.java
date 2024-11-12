public class Car{
    private String carReg;
    public String carMake;
    public String carModel;
    public int carMileage;
    public int carAge;
    public String carColour;
    public String carFeatures;


    public Car(String carReg, String carMake, String carModel/*, int carMileage, int carAge, String carColour, String carFeatures*/){
        this.carReg = carReg;
        this.carMake = carMake;
        this.carModel = carModel;
        // this.carMileage = carMileage;
        // this.carAge = carAge;
        // this.carColour = carColour;
        // this.carFeatures = carFeatures;
        DigitalArtefact.carCount++;
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