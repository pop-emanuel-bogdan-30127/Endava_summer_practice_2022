package BasicObjects;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public String name;
    public double price;
    public List<String> recipeList;


    public Product(){
        this.recipeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getRecipe(){ return recipeList;}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addRecipe(String ingredient){ this.recipeList.add(ingredient);}
}
