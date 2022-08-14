package com.example.demo.service;

import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IngredientService {

    public IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;

    }
    public void add(Ingredient ingredient) throws IOException {
        ingredientRepository.add(ingredient);
    }

    public Ingredient getIngredientByName(String name) throws Exception {
        return ingredientRepository.getByName(name);
    }

    public List<Ingredient> getAll(){
        return ingredientRepository.getAll();
    }

}
