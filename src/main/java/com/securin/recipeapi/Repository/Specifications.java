package com.securin.recipeapi.Repository;

import com.securin.recipeapi.Model.RecipeEntry;
import org.springframework.data.jpa.domain.Specification;

public class Specifications {

    public static Specification<RecipeEntry> caloriFilter(String compare,int value){
        if(compare!=null){
            if(compare.equals(">=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("calories"), value));
            if(compare.equals("<=")) return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("calories"), value);
            if(compare.equals("=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("calories"),value));
        }
        return null;
    }

    public static Specification<RecipeEntry> totalTimrFilter(String compare,int value){
        if(compare!=null){
            if(compare.equals(">=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("totalTime"), value));
            if(compare.equals("<=")) return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("totalTime"), value);
            if(compare.equals("=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("totalTime"),value));
        }
        return null;
    }

    public static Specification<RecipeEntry> ratingFilter(String compare,Double value){
        if(compare!=null){
            if(compare.equals(">=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("rating"), value));
            if(compare.equals("<=")) return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("rating"), value);
            if(compare.equals("=")) return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("rating"),value));
        }
        return null;
    }

}
