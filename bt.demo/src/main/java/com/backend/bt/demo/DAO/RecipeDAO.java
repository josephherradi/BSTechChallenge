package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Ingredient;
import com.backend.bt.demo.Modele.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RecipeDAO extends JpaRepository<Recipe,Integer> {

// not working ...
    @Query("select r from Recipe r where r.ingredients in :ingredients")
    List<Recipe> findByIngredients(@Param("ingredients") List<Ingredient> ingredients);
}