package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    public ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;

    }
    public void add(Product product) throws IOException {
        productRepository.add(product );
    }

    public Product getProductByName(String name) throws Exception {
        return productRepository.getByName(name);
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

}


