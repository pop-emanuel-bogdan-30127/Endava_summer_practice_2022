package BasicObjects;

public class Ingredient {

    public String name;
    public double price;
    public double quantity;
    public double quantityPerCup;

    public Ingredient(String name, double price, double quantity, double quantityPerCup){
        this.name=name;
        this.price=price;
        this.quantity = quantity;
        this.quantityPerCup = quantityPerCup;
    }

    public double getIngredientPrice(){
        return this.price;
    }

    public String getIngredientName(){
        return this.name;
    }

    public double getQuantity() { return this.quantity; }

    public double getQuantityPerCup() { return this.quantityPerCup; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
}
