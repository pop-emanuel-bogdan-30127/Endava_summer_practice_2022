public class Account {

    private String owner;
    private double balance;

    private Card card;

    public Account(Card card, String owner, double balance){
        this.card=card;
        this.owner=owner;
        this.balance=balance;
    }

    public Card getCard(){ return this.card;}

    public void setOwner(String owner){ this.owner=owner;}

    public void setBalance(double balance){ this.balance=balance;}

    public String getOwner(){
        return this.owner;
    }

    public double getBalance(){
        return this.balance;
    }

    @Override
    public boolean equals(Object o) {
        Account other = (Account) o;
        return this.owner.equals(other.getOwner()) && card.getCardId().equals(other.getCard().getCardId());
    }
}
