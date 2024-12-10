package carsalessystem;
public class CarSalesSystem{
        public static void main(String[] args) 
        {
            //Add 2 test instances/objects of the class Car
            MenuSelection.carDetailList.add(new Car("HL68CDK", "Renault", "Clio",42000,5,"Blue","aircon"));
            MenuSelection.carDetailList.add(new Car("ML12GZO", "Vauxhall", "Corsa", 55000, 12, "Red", "radio"));


            System.out.println("_________________________________");
            System.out.println("Welcome to the Vroom Vroom Vault!");
            
            //TryParseInt.tryParseInt("2");

            do
            {
                MenuSelection menuSelection = new MenuSelection();
                menuSelection.mainMenu();
            } 
            while (!MenuSelection.exit);
        }
}