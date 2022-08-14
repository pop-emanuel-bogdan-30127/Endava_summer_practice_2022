package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer id;
//
 //   @Column(name = "product_name", nullable = false)
    private String name;

 //   @Column
    private double price;

    public List<String> recipeList;

    public Product(){
        this.recipeList = new ArrayList<>();
    }

    public Product(String name, double price){
        this.name =name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getRecipeList(){ return recipeList;}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addRecipeList(String ingredient){ this.recipeList.add(ingredient);}
}
