package com.backend.bt.demo.Service;


import com.backend.bt.demo.DAO.IngredientDAO;
import com.backend.bt.demo.DAO.RecipeDAO;
import com.backend.bt.demo.Modele.Ingredient;
import com.backend.bt.demo.Modele.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDAO recipeDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Override
    public List<Recipe> listRecipes() {
        return recipeDAO.findAll();
    }

    @Override
    public Recipe saveRecipe(Recipe theRecipe) {
        return recipeDAO.save(theRecipe);
    }

    @Override
    public Recipe get(int theId) {
        return recipeDAO.findById(theId).orElse(null);
    }

    @Override
    public void delete(int theId) {
        recipeDAO.deleteById(theId);

    }

    @Override
    public List<Recipe> getByIngredients(List<Integer> ingredients_id) {
        List<Ingredient> ingredientList=  ingredientDAO.findAllById(ingredients_id);
        List<Recipe> recipes = recipeDAO.findByIngredients(ingredientList);
        return recipes;
    }


}
