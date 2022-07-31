import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlataPOS extends Transaction{

    public double amount;

    public PlataPOS(double amount, Account cont){
        this.amount=amount;
        this.cont=cont;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    @Override
    public String execute() {
        if(cont.getBalance() > amount) {
            cont.setBalance(cont.getBalance() - amount);
            
            return "The sum of " + amount + " $ was sent.\n";
        }
        else
            return"Insufficient Balance.\n";
    }
}
