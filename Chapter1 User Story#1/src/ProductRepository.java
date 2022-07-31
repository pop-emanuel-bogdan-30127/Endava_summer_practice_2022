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
                String[] recipe = null;
                double price = 0;
                while (line != null) {
                    coffeeName = line;
                    line = item.readLine();
                    recipe = line.split(",");
                    line = item.readLine();
                    price = Double.parseDouble(line);
                    productList.add(new Product(coffeeName, recipe, price));
                    line = item.readLine();;
                }
                item.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
