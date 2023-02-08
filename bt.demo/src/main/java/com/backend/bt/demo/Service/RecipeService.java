package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> listRecipes();
    public Recipe saveRecipe(Recipe theRecipe);
    public Recipe get(int theId);
    public void delete(int theId);
}
