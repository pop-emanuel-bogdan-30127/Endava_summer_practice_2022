import BasicObjects.Card;
import BasicObjects.Ingredient;
import BasicObjects.Order;
import BasicObjects.Product;
import Repository.IngredientsRepository;
import Repository.OrdersRepository;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CoffeeVendingMachine {

    private Bank banca;
    private Card card;

    public CoffeeVendingMachine(Bank banca){
        this.banca=banca;
    }

    public void executeTransaction(double amount){
        Transaction transaction = new PlataPOS(amount, banca.getAccountByCardId(card.getCardId()));
        System.out.println(banca.executeTransaction(transaction));
    }

    public void addOrder(String filePath, int orderIndex, String orderName, double orderFee, String location) throws IOException {
        OrdersRepository ordersRepository = new OrdersRepository(filePath, orderIndex, orderName, orderFee, location);
        ordersRepository.update(filePath, orderIndex, orderName, orderFee, location);
    }

    public void showProductOptions(Menu menu){
        OrderService orderService = new OrderService();
        orderService.enumProductOptions(menu);
    }

    public void chooseIngredient(Order order, Menu menu){
        OrderService orderService = new OrderService();
        orderService.getIngredientList(order, menu);
    }

    public String chooseLocation(Order order){
        OrderService orderService = new OrderService();
        return orderService.Location(order);
    }

    public void checkPin(Card card, Bank bank){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter pin:");
        String pin1 = s.next();
        insertCard(card, pin1);

        while (isCard()) {
            System.out.println("Enter the CardId: ");
            String idCard = s.next();
            Card card123 = bank.getAccountByCardId(idCard).getCard();
            System.out.println("Enter pin:");
            pin1 = s.next();
            insertCard(card123, pin1);
        }
    }

    public boolean completeStandardTransaction(Order order,Bank bank,int orderIndex) throws IOException {
        if (!isCard()) {
            executeTransaction(order.getProduct().getPrice());
            bank.updateAccount("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                    "Chapter2 User Story#3\\Repository\\Accounts.txt");
            addOrder("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\Chapter2 User Story#3\\Repository\\Record.txt",
                    orderIndex, order.getProduct().getName(), order.getProduct().getPrice(), order.getLocation());
            return true;
        }
        return false;
    }

    public boolean completeCustomTransaction(Order order,Bank bank,int orderIndex) throws IOException {
        if (!isCard()) {
            executeTransaction(order.getCustomPrice());
            bank.updateAccount("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                    "Chapter2 User Story#3\\Repository\\Accounts.txt");
            addOrder("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\Chapter2 User Story#3\\Repository\\Record.txt",
                    orderIndex, order.getCustomerName(), order.getCustomPrice(), order.getLocation());
            return true;
        }
        return false;
    }
    public String updateStockStandard(Product product, Menu menu) throws IOException {
        double stock;
        for (String ingredient : product.recipeList) {
            stock = menu.getIngredientByName(ingredient).getQuantity();
            if (menu.getIngredientByName(ingredient).getQuantityPerCup() < stock) {
                menu.getIngredientByName(ingredient).setQuantity(stock - menu.getIngredientByName(ingredient).getQuantityPerCup());
            }
            else{
                return "STOCK ERROR";
            }
        }
        menu.updateStock("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                "Chapter2 User Story#3\\Repository\\Ingredients.txt");
        return "Coffee brewed unsuccessful";
    }


    public String updateStockCustom(Menu menu, Order order) throws IOException {
        double stock;
        for (Ingredient ingredient : order.getIngredientList()) {
            String name = ingredient.getIngredientName();
            stock = menu.getIngredientByName(name).getQuantity();
            if (menu.getIngredientByName(name).getQuantityPerCup() < stock) {
                menu.getIngredientByName(name).setQuantity(stock - menu.getIngredientByName(name).getQuantityPerCup());
            }
            else{
                return "STOCK ERROR";
            }
        }
        menu.updateStock("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                "Chapter2 User Story#3\\Repository\\Ingredients.txt");
        return "Coffee brewed unsuccessful";
    }

    public void checkStock(Menu menu){
        for (Ingredient ingredient : menu.ingredientList) {
            if (ingredient.getQuantity() < 3 * ingredient.getQuantityPerCup())
                System.out.println("Not enough quantity of " + ingredient.getIngredientName() + " in stock");
            else
                System.out.println("Ingredient: " + ingredient.getIngredientName() + " is in quantity of:\n " + ingredient.getQuantity()/1000 + " kilograms.");
        }
    }

    public boolean insertCard(Card card, String pin) {
        if (pin.equals(card.getPin()))
        {
            this.card=card;
            System.out.println("Pin approved.\n Payment successful.");;
            return true;
        }
        else
            System.out.println("Wrong pin . . .\n");
        return false;
    }

    public boolean isCard(){
        if(this.card == null)
            return true;
        else
            return false;
    }

}
