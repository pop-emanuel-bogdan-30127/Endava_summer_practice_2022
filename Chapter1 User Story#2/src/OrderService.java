import java.util.List;
import java.util.Scanner;

public class OrderService {

public Menu menu;

   // public OrderService(Menu menu){ this.menu = menu;}

    public void enumProductOptions(Menu menu){
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

    public void enumIngredients(Menu menu){
        System.out.println("\n " + "Please choose the ingredients for your custom beverage from our menu: \n");
        Scanner s = new Scanner(System.in);
        int n;
        int ingrId = 1;
        for (Ingredient ingr : menu.ingredientList) {
            System.out.println("Press " + ingrId + " for " + ingr.getIngredientName()
                    + " at " + ingr.getIngredientPrice() + "$");
            ingrId++;
        }
        System.out.println("Press 0 to confirm the order.");
    }


    public void getIngredientList(Order customOrder, Menu menu){
        int ingredientIndex = 1;
        int max =0;
        double totalPrice = 0;
        Scanner s = new Scanner(System.in);
        enumIngredients(menu);
        System.out.println(5-max + " options remaining.");
        ingredientIndex = s.nextInt();
        while(ingredientIndex !=0 & max < 5){
            if(ingredientIndex <= menu.ingredientList.size()){
                customOrder.getIngredientList().add(menu.ingredientList.get(ingredientIndex -1));
                totalPrice = totalPrice + menu.ingredientList.get(ingredientIndex -1).getIngredientPrice();
                max++;
            }
            else{
                System.out.println("\nWrong ingredient command");
            }
            enumIngredients(menu);
            System.out.println(5-max + " options remaining.");
            ingredientIndex = s.nextInt();
        }
        customOrder.setCustomPrice(totalPrice);

    }

    public String Location(Order order){
        String location = null;
        System.out.println("Would you like your " + order.getCustomerName() + " here or to go?");
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

