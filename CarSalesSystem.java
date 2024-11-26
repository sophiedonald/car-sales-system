public class CarSalesSystem{
        public static void main(String[] args) 
        {
            //Add 2 test instances/objects of the class Car
            MenuSelection.carDetailList.add(new Car("HL68CDK", "Renault", "Clio",42000,5,"Blue","aircon"));
            MenuSelection.carDetailList.add(new Car("ML12GZO", "Vauxhall", "Corsa", 55000, 12, "Red", "radio"));


            LoadingAnimation();

            System.out.println("Welcome to the Vroom Vroom Vault!");
            
            //TryParseInt.tryParseInt("2");

            do
            {
                MenuSelection menuSelection = new MenuSelection();
                menuSelection.mainMenu();
            } 
            while (MenuSelection.exit == false);
        }

        public static void LoadingAnimation(){
            System.out.println("  ______");
            System.out.println(" /|_|_| \\`__");
            System.out.println("(   _     _   \\");
            System.out.print("=`-(_)---(_)---'");

            for (int i = 0; i < 35 ; i++)
            {
                try {
                    
                    System.out.print("_");
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }
            }
            System.out.println();
        }
}