package BasicObjects;

import java.util.ArrayList;
import java.util.List;

public class Order {
        private Product product;
        private String location;
        private String customerName;
        private List<Ingredient> ingredientList;
        private double customPrice;

        public Order(Product product){
            this.product = product;
            this.ingredientList  =new ArrayList<>();
        }

        public Product getProduct() {
            return product;
        }

        public String getLocation() {
            return location;
        }

        public String getCustomerName(){ return customerName;}

        public List<Ingredient> getIngredientList(){ return ingredientList;}

        public double getCustomPrice(){ return customPrice;}

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setCustomerName(String customerName) { this.customerName = customerName;}

        public void setIngredientList(List<Ingredient> ingredientList) { this.ingredientList = ingredientList;}

        public void setCustomPrice(double customPrice){ this.customPrice = customPrice;}
    }
