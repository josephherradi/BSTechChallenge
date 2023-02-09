package com.backend.bt.demo.Service;

import com.backend.bt.demo.DAO.IngredientDAO;
import com.backend.bt.demo.DAO.RecipeDAO;
import com.backend.bt.demo.Modele.Ingredient;
import com.backend.bt.demo.Modele.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private RecipeDAO recipeDAO;

    @Override
    public List<Ingredient> ingredientsList() {
        return ingredientDAO.findAll();
    }

    @Override
    public List<Ingredient> ingredientsListPerRecipe(int Id) {
        return recipeDAO.findById(Id).orElse(null).getIngredients();
    }
}
