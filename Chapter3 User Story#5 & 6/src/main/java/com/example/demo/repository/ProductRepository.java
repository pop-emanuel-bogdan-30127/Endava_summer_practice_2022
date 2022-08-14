package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private String filePath = "C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice\\" +
            "Chapter3 User Story#5 & 6\\Repository\\Menu.txt";
    private List<Product> productList;

    public ProductRepository() throws IOException {
        this.productList = readProducts();
    }

    private List<Product> readProducts() throws IOException {
        List<Product> productList = new ArrayList<Product>();
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
        return productList;
    }

    public List<Product> getAll(){
        return productList;
    }

    public void add(Product product){
        productList.add(product);
    }

    public Product getByName(String name) throws Exception {
        for (Product prod : productList) {
            if (prod.getName().equals(name))
                return prod;
        }
        throw new Exception("We don't have this product.");
    }
}





