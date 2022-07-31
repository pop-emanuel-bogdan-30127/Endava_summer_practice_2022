import java.util.Scanner;

public class OrderService {

public Menu menu;

   // public OrderService(Menu menu){ this.menu = menu;}

    public void enumOptions(Menu menu){
        System.out.println("\n " + "Welcome to Cattpuccino Coffee\n" +
                "Please choose you order from our menu \n");
        Scanner s = new Scanner(System.in);
        int n;
        int prodId = 1;
        for (Product coffee : menu.productList) {
            System.out.println("Press " + prodId + " for " + coffee.getName() + " at " + coffee.getPrice() + "$");
            prodId++;
        }
    }

    public String Location(Order order){
        String location = null;
        System.out.println("Would you like your " + order.getProduct().getName() + " here or to go?");
        System.out.println("Press 1 to choose here or 2 to choose to go.\n ");
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        while (location == null) {
            switch (n) {
                case 1:
                    location = "pick-up";
                    return location;
                case 2:
                    location = "delivery";
                    return location;
                default:
                    System.out.println("Wrong command.");
            }
        }
        return location;
    }


}

