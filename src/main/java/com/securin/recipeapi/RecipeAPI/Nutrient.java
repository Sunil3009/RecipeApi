package com.securin.recipeapi.RecipeAPI;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutrient {
    private String calories;
    private String carbohydrateContent;
    private String cholesterolContent;
    private String fiberContent;
    private String proteinContent;
    private String saturatedFatContent;
    private String sodiumContent;
    private String sugarContent;
    private String fatContent;
    private String unsaturatedFatContent;
}
