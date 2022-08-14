package com.example.demo.controller;


import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1/ingredient")
@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public void add(@Valid @NonNull @RequestBody Ingredient ingredient) throws IOException {
        ingredientService.add(ingredient);
    }

    @GetMapping(path = "{name}")
    public Ingredient getByName(@PathVariable String name) throws Exception {
        return ingredientService.getIngredientByName(name);
    }

    @GetMapping()
    public List<Ingredient> getAll(){
        return ingredientService.getAll();
    }

}
