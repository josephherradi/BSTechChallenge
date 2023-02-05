package com.backend.bt.demo.Service;


import com.backend.bt.demo.DAO.RecipeDAO;
import com.backend.bt.demo.Modele.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDAO recipeDAO;

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
    public List<Recipe> listRecipesPerKeyWords(String keywords) {
        return recipeDAO.findByKeywords(keywords);
    }
}
