package com.securin.recipeapi.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class RecipeEntry {

    @Id
    private int id;
    private String title;
    private String cuisine;
    private Double rating;
    private int preparationTime;
    private int cookingTime;
    private int totalTime;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String calories;
    private String carbohydrate;
    private String cholesterol;
    private String protein;
    private String fiber;
    private String saturateFat;
    private String sodium;
    private String sugar;
    private String fat;
    private String serves;
}
