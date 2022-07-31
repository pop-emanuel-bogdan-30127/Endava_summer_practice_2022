import java.util.List;

public class Order {
        private Product product;
        private String location;

        public Order(Product product, String location){
            this.product = product;
            this.location = location;
        }

        public Product getProduct() {
            return product;
        }

        public String getLocation() {
            return location;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
