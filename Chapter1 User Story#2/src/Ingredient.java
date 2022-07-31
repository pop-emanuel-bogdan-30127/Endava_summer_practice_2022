public class Ingredient {

    public String name;
    public double price;

    public Ingredient(String name, double price){
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
