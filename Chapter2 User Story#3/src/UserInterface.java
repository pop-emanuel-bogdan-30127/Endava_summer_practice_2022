import BasicObjects.Account;
import BasicObjects.Card;
import BasicObjects.Order;
import BasicObjects.Product;

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
                System.out.println("Press 1 to make a new standard order");
                System.out.println("Press 2 to make a new custom order");

                System.out.println("Press 3 to check the stock");   // 3 STOCK CHECK
                System.out.println("Press 12345 for Shut Down");    // 12345 SHUT DOWN
                command = s.nextInt();
                //SHUT DOWN
                switch (command){
                    case 12345:
                    {
                        //SHUT DOWN
                        System.out.println("\n Day " + java.time.LocalDate.now() + " finished.\n Total profit: " + profit + "$.\n" + "\n");
                        power = false;
                        break;
                    }
                    case 1:
                    {
                        vendingMachine.showProductOptions(MENU);
                        int orderChoice = s.nextInt();
                        // handleOrderType
                        if (orderChoice <= MENU.productList.size()) {
                            Order standardOrder = new Order(MENU.productList.get(orderChoice - 1));
                            standardOrder.setCustomerName(MENU.productList.get(orderChoice - 1).getName());
                            //chooseLocation
                            standardOrder.setLocation(vendingMachine.chooseLocation(standardOrder));
                            System.out.println("Your order is:\n " + standardOrder.getProduct().getName().toUpperCase()
                                    + " at " + standardOrder.getProduct().getPrice() + "$\n");

                            //Get account by card ID
                            Card card = null;
                            Account account = null;
                            while(account == null) {
                                System.out.println("Please enter your credit card for payment:");
                                String idCard = s.next();
                                account = BANK.getAccountByCardId(idCard);

                            }
                            // Check pin
                            card = account.getCard();
                            vendingMachine.checkPin(card, BANK);

                            //execute transaction + update record and account balance
                            if (vendingMachine.completeStandardTransaction(standardOrder, BANK, orderIndex)) {
                                profit += standardOrder.getProduct().getPrice();
                                orderIndex++;
                                System.out.println(vendingMachine.updateStockStandard(standardOrder.getProduct(), MENU));
                            }
                        }
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Please type your name");
                        String customerName = s.next();
                        Order customOrder = new Order(null);
                        customOrder.setCustomerName(customerName);
                        //chooseIngredients
                        vendingMachine.chooseIngredient(customOrder,MENU);
                        //chooseLocation
                        customOrder.setLocation(vendingMachine.chooseLocation(customOrder));

                        System.out.println("Your " + customerName + " order will be: " + customOrder.getCustomPrice() + "$\n");
                        System.out.println("Please enter your credit card for payment:");
                        String idCard = s.next();
                        Card card = BANK.getAccountByCardId(idCard).getCard();
                        // Check pin
                        vendingMachine.checkPin(card, BANK);
                        //execute transaction + update record and account balance
                        if (vendingMachine.completeCustomTransaction(customOrder, BANK, orderIndex)) {
                            profit += customOrder.getCustomPrice();
                            orderIndex++;
                            System.out.println(vendingMachine.updateStockCustom(MENU, customOrder));

                        }
                    }
                    case 3:
                    {
                        vendingMachine.checkStock(MENU);
                        break;
                    }
                    default:
                    {
                        System.out.println("Wrong command.\n");
                        break;
                    }
                }
            }
        }
}
