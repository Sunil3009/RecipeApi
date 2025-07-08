package com.securin.recipeapi.Controller;


import com.securin.recipeapi.Model.RecipeEntry;
import com.securin.recipeapi.RecipeAPI.Result;
import com.securin.recipeapi.Service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/fetch")
    public void fetchRecipe() {
        recipeService.fetchAndStore();
    }

    @GetMapping("/calori")
    public List<RecipeEntry> calories() {
        return recipeService.getRecipeList();
    }

    @GetMapping("/page")
    public Page<RecipeEntry> page() {
        return recipeService.getAllRecipes();
    }
}
