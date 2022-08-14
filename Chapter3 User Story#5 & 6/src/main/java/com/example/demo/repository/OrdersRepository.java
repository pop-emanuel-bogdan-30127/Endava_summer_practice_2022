package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersRepository {

    private String filePath = "C:\\Users\\ux533fda8011 lot\\Desktop\\Endava_summer_practice" +
            "\\Chapter3 User Story#5 & 6\\Repository\\Record.txt";
    private List<Order> orderList;

    public OrdersRepository() {
        this.orderList = readOrders();
    }

    private List<Order> readOrders() {
        List<Order> orderList = new ArrayList<Order>();
        BufferedReader item;
        try {
            item = new BufferedReader(new FileReader(filePath));
            String line = item.readLine();
            String[] elements;
            int quantity = 0;
            String customer = "";
            String product = "";
            while (line != null) {
                elements = line.split(", ");
                product = elements[0];
                quantity = Integer.parseInt(elements[1]);
                customer = elements[2];
                orderList.add(new Order(product, quantity, customer));
                line = item.readLine();
            }
            item.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void update(String filePath, int quantity, String orderName, String customerName) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(orderName + ", " + quantity + ", " + customerName + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAll(){
        return orderList;
    }

    public void add(Order order) throws IOException {
        orderList.add(order);
        update(filePath, order.getQuantity(), order.getProductName(), order.getCustomerName());
    }

    public Order getOrderById(int id){
        return orderList.get(id);
    }


}
