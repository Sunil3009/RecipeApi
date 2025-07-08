package com.securin.recipeapi.Repository;

import com.securin.recipeapi.Model.RecipeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntry, Integer>, JpaSpecificationExecutor {

}
