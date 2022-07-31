public class Product {
    private String name;
    private double price;
    private String recipe[] = null;


    public Product(String name, String[] recipe, double price){
        this.name = name;
        this.recipe = recipe;
        this.price =price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String[] getRecipe() {
        return recipe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRecipe(String[] recipe) {
        this.recipe = recipe;
    }
}
