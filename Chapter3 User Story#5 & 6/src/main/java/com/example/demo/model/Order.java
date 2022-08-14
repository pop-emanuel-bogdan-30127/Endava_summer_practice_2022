package com.example.demo.model;

public class Order {

    private String productName;
    private int quantity;
    private String customerName;
    private Card card;

//        public StandardOrder(Product product){
//            this.product = product;
//        }

    public Order(String productName, int quantity, String customerName) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Card getCard() { return card;}

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCard(Card card){ this.card = card; }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }
}
