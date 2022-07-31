import java.io.IOException;
public class CoffeeShop {
    public static void main(String[] args) throws IOException {

        //Bank update from text file (database)
        Bank BANK = new Bank();
        BANK.addAccountsDB("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                "Chapter1 User Story#1\\Repository\\Accounts.txt");

        //Menu update from text file (database)
        Menu MENU = new Menu();
        MENU.addProductDB("C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
                "Chapter1 User Story#1\\Repository\\Menu.txt");

        //Interface
        UserInterface UI = new UserInterface(BANK, MENU);
        UI.start(BANK,MENU);
    }
}

//SDS4786,6521,Paul,15000
//IGE1784,9382,Mircea,1854.2
//FC1SA15,1678,Loti,7542
//4CS49VR,2389,Andrei,1245.3
//4CR6165,2167,Iulia,4213.6
