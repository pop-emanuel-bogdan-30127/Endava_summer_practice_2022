package Repository;

import BasicObjects.Account;
import BasicObjects.Ingredient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
                double quantityPerCup;
                double quantity = 0;
                while (line0 != null) {
                    line = line0.split(",");
                    ingredientName = line[0];
                    price = Double.parseDouble(line[1]);
                    quantityPerCup = Double.parseDouble(line[2]);
                    quantity = Double.parseDouble(line[3]);
                    ingredientList.add(new Ingredient(ingredientName, price, quantity, quantityPerCup));
                    line0 = item.readLine();
                }
                item.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void update(String filePath,List<Ingredient> ingredientList){
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Ingredient ingredient : ingredientList) {
            try {
                File file = new File(filePath);
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(ingredient.getIngredientName() +"," + ingredient.getIngredientPrice()
                        + "," + ingredient.getQuantityPerCup() + "," + ingredient.getQuantity() + "\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }

