public class CarSalesSystem{
        public static void main(String[] args) 
        {
            //Add 2 test instances of the class Car
            MenuSelection.carDetailList.add(new Car("HL68 CDK", "Renault", "Clio",42000,5,"Blue","aircon"));
            MenuSelection.carDetailList.add(new Car("ML12 GZO", "Vauxhall", "Corsa", 55000, 12, "Red", "radio"));
            //MenuSelection.carDetailList.add(new Car("","","",0,0,"",""));

            System.out.println("Welcome to the Vroom Vroom Vault!");
            
            TryParseInt.tryParseInt("2");

            do
            {
                MenuSelection menuSelection = new MenuSelection();
                menuSelection.mainMenu();
            } 
            while (MenuSelection.exit == false);
    }
}