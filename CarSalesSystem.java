public class CarSalesSystem{
        public static void main(String[] args) 
        {
                MenuSelection.carDetailList.add(new Car("HL68 CDK", "Renault", "Clio"));
                MenuSelection.carDetailList.add(new Car("ML12 GZO", "Vauxhall", "Corsa"));
    
                System.out.println("Welcome to the Vroom Vroom Vault!");
                
                do
                {
                    MenuSelection menuSelection = new MenuSelection();
                    menuSelection.mainMenu();
                } while(MenuSelection.exit == false);
    }
}