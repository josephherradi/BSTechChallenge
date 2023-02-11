package com.backend.bt.demo.Controller;


import com.backend.bt.demo.Modele.Ingredient;
import com.backend.bt.demo.Modele.Recipe;
import com.backend.bt.demo.Service.IngredientService;
import com.backend.bt.demo.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "ingredients", method = RequestMethod.GET)
    public List<Ingredient> ingredList(){
        List<Ingredient> igList= ingredientService.ingredientsList();
        return igList;

    }

    @RequestMapping(value = "recipe/{id}/ingredients", method = RequestMethod.GET)
    public List<Ingredient> recipeIgdList(@PathVariable int id){
        List<Ingredient> recipeIgdList= ingredientService.ingredientsListPerRecipe(id);
        return recipeIgdList;

    }

    @RequestMapping(value = "recipesByIngredients", method = RequestMethod.GET)
    public List<Recipe> recipesByIgd(@RequestParam("ingredients_id") List<Integer> ingredients_id){
        List<Recipe> recipeBYIgdList= recipeService.getByIngredients(ingredients_id);
        return recipeBYIgdList;

    }

}
