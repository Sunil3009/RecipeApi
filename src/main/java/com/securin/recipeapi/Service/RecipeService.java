package com.securin.recipeapi.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securin.recipeapi.Model.RecipeEntry;
import com.securin.recipeapi.RecipeAPI.Nutrient;
import com.securin.recipeapi.RecipeAPI.Result;
import com.securin.recipeapi.Repository.RecipeRepository;
import com.securin.recipeapi.Repository.Specifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    ObjectMapper mapper = new ObjectMapper();
    private HashMap<String, Result> result = new HashMap<>();

    public void fetchAndStore() {
        {
            try {
                result = mapper.readValue(new File("C:\\Users\\Sunil\\Documents\\SecurinPreparation\\RecipeApi\\src\\main\\resources\\Data\\US_recipes_null.json"), new TypeReference<HashMap<String, Result>>() {});
//                return result.get("0");
                for(int i=0;i< result.size();i++){
                    RecipeEntry entry = new RecipeEntry();
                    Result items=result.get(String.valueOf(i));
                    if(items!=null){
                        Nutrient nut=items.getNutrients();
                        entry.setTitle(items.getTitle());
                        entry.setDescription(items.getDescription());
                        entry.setId(i);
                        entry.setCuisine(items.getCuisine());
                        entry.setRating(items.getRating());
                        entry.setPreparationTime(items.getPrepTime());
                        entry.setCookingTime(items.getCookTime());
                        entry.setTotalTime(items.getTotalTime());
                        entry.setServes(items.getServes());
                        if(nut!=null){
                            entry.setCalories(nut.getCalories());
                            entry.setCarbohydrate(nut.getCarbohydrateContent());
                            entry.setCholesterol(nut.getCholesterolContent());
                            entry.setProtein(nut.getProteinContent());
                            entry.setFiber(nut.getFiberContent());
                            entry.setSaturateFat(nut.getSaturatedFatContent());
                            entry.setSodium(nut.getSodiumContent());
                            entry.setSugar(nut.getSugarContent());
                            entry.setFat(nut.getFatContent());
                        }
                    }


                    recipeRepository.save(entry);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Page<RecipeEntry> getAllRecipes(){
        return recipeRepository.findAll(PageRequest.of(0, 10));
    }

    public List<RecipeEntry> getRecipeList(){
        return recipeRepository.findAll(Specifications.caloriFilter("<=",400).and(Specifications.ratingFilter(">=",4.5)));
    }

}
