package com.securin.recipeapi.RecipeAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)public class Result {

    @JsonProperty("Contient")
    private String continent;

    @JsonProperty("Country_State")
    private String countryState;

    private String cuisine;
    private String title;

    @JsonProperty("URL")
    private String url;

    private double rating;

    @JsonProperty("total_time")
    private int totalTime;

    @JsonProperty("prep_time")
    private int prepTime;

    @JsonProperty("cook_time")
    private int cookTime;

    private String description;
    private List<String> ingredients;
    private List<String> instructions;
    private Nutrient nutrients;
    private String serves;
}
