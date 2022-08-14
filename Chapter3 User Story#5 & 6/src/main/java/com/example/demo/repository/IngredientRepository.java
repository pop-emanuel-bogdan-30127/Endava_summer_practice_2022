package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

    private String filePath = "C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
            "Chapter3 User Story#5 & 6\\Repository\\Ingredients.txt";
    private List<Ingredient> ingredientList;
    
    public IngredientRepository(){
        this.ingredientList = readIngredients();
    }

    private List<Ingredient> readIngredients(){
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        BufferedReader item;
        try {
            item = new BufferedReader(new FileReader(filePath));
            String[] line;
            String line0 = item.readLine();
            String name = "";
            double price = 0;
            double quantityPerCup;
            double quantity = 0;
            while (line0 != null) {
                line = line0.split(",");
                name = line[0];
                price = Double.parseDouble(line[1]);
                quantityPerCup = Double.parseDouble(line[2]);
                quantity = Double.parseDouble(line[3]);
                ingredientList.add(new Ingredient(name, price, quantity, quantityPerCup));
                line0 = item.readLine();

            }
            item.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }

    public List<Ingredient> getAll(){
        return ingredientList;
    }

    public void add(Ingredient ingredient){
        ingredientList.add(ingredient);
    }

    public Ingredient getByName(String name) throws Exception {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(name))
                return ingredient;
        }
        throw new Exception("We don't have this item right now.\n" + 
                "Please choose something else.\n");
    }
    
}
