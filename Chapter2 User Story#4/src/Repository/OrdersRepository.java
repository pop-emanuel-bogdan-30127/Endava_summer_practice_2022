package Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrdersRepository {

        private String filePath;
        private int orderIndex;
        private String orderName;
        private double orderFee;

        public OrdersRepository(String filePath, int orderIndex, String orderName, double orderFee, String location){
            this.filePath = filePath;
            this.orderIndex = orderIndex;
            this.orderName = orderName;
            this.orderFee = orderFee;
        }
        public void update(String filePath, int orderIndex, String orderName, double orderFee, String location) throws IOException {
            try {
                File file = new File(filePath);
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(orderIndex + " " + orderName + " chosen location: " + location + "\n Total fee: "+ orderFee + "$\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





}
