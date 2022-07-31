import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {

        public List<Product> productList;
        public List<Ingredient> ingredientList;

        public Menu() {
            productList = new ArrayList<>();
            ingredientList = new ArrayList<>();
        }

        public void addProduct(Product newProduct) {
            productList.add(newProduct);
        }

        public void addProductDB(String filePath) throws IOException{
            ProductRepository productRepository = new ProductRepository(filePath,productList);
            productRepository.initialize(filePath, productList);
        }

    public void addIngredientDB(String filePath) throws IOException{
        IngredientsRepository ingredientsRepository = new IngredientsRepository(filePath,ingredientList);
        ingredientsRepository.initialize(filePath, ingredientList);
    }

        public Product getProductByProductName(String name) {
            for (Product prod : productList) {
                if (prod.getName().equals(name))
                    return prod;
            }
            System.out.println("When don't have this item right now.\n" + "Please choose something else.\n");
            return null;
        }


}

