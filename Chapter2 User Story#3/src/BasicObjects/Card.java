package BasicObjects;

public class Card {

    private String cardId;
    private String pin;

    public Card(String cardId, String pin){
        this.cardId=cardId;
        this.pin=pin;
    }


    public String getCardId(){
        return this.cardId;
    }

    public String getPin(){
        return this.pin;
    }

}
