package com.example.demo.model;


//@Entity
public class Ingredient {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ingredient_id")
//    private Integer id;
//
//    @Column(name = "ingredient_name", nullable = false)
    private String name;

//    @Column
    private double price;
    private double quantity;
    private double quantityPerCup;

    public Ingredient(){}

    public Ingredient(String name, double price, double quantity, double quantityPerCup){
        this.name=name;
        this.price=price;
        this.quantity = quantity;
        this.quantityPerCup = quantityPerCup;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public double getQuantity() { return this.quantity; }

    public double getQuantityPerCup() { return this.quantityPerCup; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
}
