import java.io.IOException;
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

    public void showOptions(Menu menu){
        OrderService orderService = new OrderService();
        orderService.enumOptions(menu);
    }

    public String chooseLocation(Order order){
        OrderService orderService = new OrderService();
        return orderService.Location(order);
    }

    public void checkPin(Card card, Bank bank){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter pin:");
        String pin1 = s.next();
        insertCard(card, pin1);

        while (isCard()) {
            System.out.println("Enter the CardId: ");
            String idCard = s.next();
            Card card123 = bank.getAccountByCardId(idCard).getCard();
            System.out.print("Enter pin:");
            pin1 = s.next();
            insertCard(card123, pin1);
        }
    }

    public boolean completeTransaction(Order order,Bank bank,int orderIndex, double profit) throws IOException {
        if (!isCard()) {
            executeTransaction(order.getProduct().getPrice());
            bank.updateAccount("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                    "Chapter1 User Story#1\\Repository\\Accounts.txt");
            addOrder("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\Chapter1 User Story#1\\Repository\\Record.txt",
                    orderIndex, order.getProduct().getName(), order.getProduct().getPrice(), order.getLocation());
            return true;
        }
        return false;
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
