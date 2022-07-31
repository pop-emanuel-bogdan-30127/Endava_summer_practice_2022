import java.io.IOException;
import java.util.List;
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
                        vendingMachine.showProductOptions(MENU);
                        System.out.println("Press 555 for a custom order.");
                        int orderChoice = s.nextInt();
                        // handleOrderType
                        if (orderChoice <= MENU.productList.size()) {
                            Order standardOrder = new Order(MENU.productList.get(orderChoice - 1));
                            standardOrder.setCustomerName(MENU.productList.get(orderChoice - 1).getName());
                            //chooseLocation
                            standardOrder.setLocation(vendingMachine.chooseLocation(standardOrder));
                            System.out.println("Your order is:\n " + standardOrder.getProduct().getName().toUpperCase()
                                    + " at " + standardOrder.getProduct().getPrice() + "$\n");
                            System.out.println("Please enter your credit card for payment:\n");
                            String idCard = s.next();
                            Card card = BANK.getAccountByCardId(idCard).getCard();

                            // Check pin
                            vendingMachine.checkPin(card, BANK);

                            //execute transaction + update record and account balance
                            if (vendingMachine.completeStandardTransaction(standardOrder, BANK, orderIndex)) {
                                profit += standardOrder.getProduct().getPrice();
                                orderIndex++;
                            }
                        } else if (orderChoice == 555) {
                            System.out.println("Please type your name");
                            String customerName = s.next();
                            Order customOrder = new Order(null);
                            customOrder.setCustomerName(customerName);
                            //chooseIngredients
                            vendingMachine.chooseIngredient(customOrder,MENU);
                            //chooseLocation
                            customOrder.setLocation(vendingMachine.chooseLocation(customOrder));

                            System.out.println("Your " + customerName + " order will be: " + customOrder.getCustomPrice() + "$\n");
                            System.out.println("Please enter your credit card for payment:\n");
                            String idCard = s.next();
                            Card card = BANK.getAccountByCardId(idCard).getCard();
                            // Check pin
                            vendingMachine.checkPin(card, BANK);
                            //execute transaction + update record and account balance
                            if (vendingMachine.completeCustomTransaction(customOrder, BANK, orderIndex)) {
                                profit += customOrder.getCustomPrice();
                                orderIndex++;
                            }

                        } else {
                            System.out.println("Wrong command for choosing order\n");
                        }

                    }
                }
            }
        }
}
