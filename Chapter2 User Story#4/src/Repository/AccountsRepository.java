package Repository;

import BasicObjects.Account;
import BasicObjects.Card;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AccountsRepository {

    private String filePath;
    private List<Account> accountList;

    public AccountsRepository(String filePath, List<Account> accountList){
        this.filePath = filePath;
        this.accountList = accountList;
    }
    public void initialize(String filePath, List<Account> accountList) throws IOException {
        BufferedReader component;
        try {
            component = new BufferedReader(new FileReader(filePath));
            String cardId = "";
            String pin = "";
            String owner = "";
            double balance = 0;
            String line0 = component.readLine();
            String[] line1 = null;
            while (line0 != null) {
                line1 = line0.split(",");
                cardId = line1[0];
                pin = line1[1];
                owner = line1[2];
                balance = Double.parseDouble(line1[3]);
                Card card = new Card(cardId, pin);
                accountList.add(new Account(card, owner, balance));
                line0 = component.readLine();
            }
            component.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String filePath,List<Account> accountList){
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Account account : accountList) {
            try {
                File file = new File(filePath);
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(account.getCard().getCardId() +"," + account.getCard().getPin()
                        + "," + account.getOwner() + "," + account.getBalance()  + "\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



