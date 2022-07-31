public class Ingredients {

    public String name;
    public double price;

    public Ingredients(String name, double price){
        this.name=name;
        this.price=price;
    }

    public double getIngredientPrice(){
        return this.price;
    }

    public String getIngredientName(){
        return this.name;
    }

}
