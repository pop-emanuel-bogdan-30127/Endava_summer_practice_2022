package Repository;

import BasicObjects.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProductRepository {

        private String filePath;
        private List<Product> productList;

        public ProductRepository(String filePath, List<Product> productList){
            this.filePath = filePath;
            this.productList = productList;
        }
        public void initialize(String filePath, List<Product> productList) throws IOException {
            BufferedReader item;
            try {
                item = new BufferedReader(new FileReader(filePath));
                String line = item.readLine();
                String coffeeName = "";
                String[] ingredients;
                double price = 0;
                while (line != null) {
                    coffeeName = line;
                    line = item.readLine();
                    ingredients = line.split(",");
                    Product product = new Product();
                    for(String name : ingredients)
                    {
                        product.recipeList.add(name);
                    }
                    line = item.readLine();
                    price = Double.parseDouble(line);
                    product.setName(coffeeName);
                    product.setPrice(price);
                    productList.add(product);
                    line = item.readLine();;
                }
                item.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
