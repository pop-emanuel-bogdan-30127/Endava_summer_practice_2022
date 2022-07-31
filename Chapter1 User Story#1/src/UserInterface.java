import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private Bank bank;
    private Menu menu;

    public UserInterface(Bank bank, Menu menu){
       this.bank = bank;
       this.menu = menu;
    }

        public void start(Bank BANK, Menu MENU) throws IOException {

        CoffeeVendingMachine vendingMachine = new CoffeeVendingMachine(BANK);
        double profit = 0.0;
        int orderIndex = 1;
        boolean power = true;
        int command;
        Scanner s = new Scanner(System.in);
        while (power) {
            System.out.println("Press 1 to make a new order");
            command = s.nextInt();
            //SHUT DOWN
            if (command == 12345) {
                System.out.println("\n Day " + java.time.LocalDate.now() + " finished.\n Total profit: " + profit + "$.\n" + "\n");
                power = false;
            } else {
                //ORDER
                if (command == 1) {
                    //chooseOptions
                    vendingMachine.showOptions(MENU);
                    int orderChoice = s.nextInt();
                    // handleOrderType
                    if (orderChoice <= MENU.productList.size()) {
                        Order order = new Order(MENU.productList.get(orderChoice-1), null);
                        //chooseLocation
                        order.setLocation(vendingMachine.chooseLocation(order));

                        System.out.println("Your order is:\n " + order.getProduct().getName().toUpperCase() + " at " + order.getProduct().getPrice() + "$\n");
                        System.out.println("Please enter your credit card for payment:\n");
                        String idCard = s.next();
                        Card card = BANK.getAccountByCardId(idCard).getCard();

                        // Check pin
                        vendingMachine.checkPin(card, BANK);

                        //execute transaction + update record and account balance
                        if (vendingMachine.completeTransaction(order, BANK, orderIndex, profit)) {
                            profit += order.getProduct().getPrice();
                            orderIndex++;
                        }
                    }else{
                        System.out.println("Wrong command for choosing order\n");
                    }

                }
            }
        }
    }
}
