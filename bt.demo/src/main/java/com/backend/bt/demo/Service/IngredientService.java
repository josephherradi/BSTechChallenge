package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.Ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> ingredientsList();
    public List<Ingredient> ingredientsListPerRecipe(int Id);
}
