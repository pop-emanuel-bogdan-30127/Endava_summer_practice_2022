import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accountList;
    private Account account;

    public Bank() {
        accountList = new ArrayList<>();
    }

    public void addAccount(Account contnou) {
        accountList.add(contnou);
    }

    public void addAccountsDB(String filePath) throws IOException {
        AccountsRepository accountsRepository = new AccountsRepository(filePath,accountList);
            accountsRepository.initialize(filePath, accountList);
    }
    public void updateAccount(String filePath) throws IOException {
        AccountsRepository accountsRepository = new AccountsRepository(filePath,accountList);
        accountsRepository.update(filePath, accountList);
    }

    public String executeTransaction(Transaction t){
        return t.execute();
    }

    public Account getAccountByCardId(String cardId) {
        for (Account acc : accountList) {
            if (acc.getCard().getCardId().equals(cardId))
            {
                this.account = acc;
                return acc;
            }
        }
        System.out.println("THIS ACCOUNT DOES NOT EXIST!\n");
        return null;
    }
    public boolean isAccount(){
        if(this.account == null)
            return true;
        else
            return false;
    }
}
