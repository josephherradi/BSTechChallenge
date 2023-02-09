package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Ingredient;
import com.backend.bt.demo.Modele.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe,Integer> {

@Query("select r from Recipe r where r.ingredients in :igList")
    List<Recipe> findByIngredients(@Param("igList") List<Ingredient> ingredientList);
}