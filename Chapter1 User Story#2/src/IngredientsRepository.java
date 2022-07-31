import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IngredientsRepository {

        private String filePath;
        private List<Ingredient> ingredientList;

        public IngredientsRepository(String filePath, List<Ingredient> ingredientList){
            this.filePath = filePath;
            this.ingredientList = ingredientList;
        }
        public void initialize(String filePath, List<Ingredient> ingredientList) throws IOException {
            BufferedReader item;
            try {
                item = new BufferedReader(new FileReader(filePath));
                String[] line;
                String line0 = item.readLine();
                String ingredientName = "";
                double price = 0;
                while (line0 != null) {
                    line = line0.split(",");
                    ingredientName = line[0];
                    price = Double.parseDouble(line[1]);
                    ingredientList.add(new Ingredient(ingredientName, price));
                    line0 = item.readLine();
                }
                item.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

