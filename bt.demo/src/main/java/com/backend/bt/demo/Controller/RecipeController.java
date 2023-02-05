package com.backend.bt.demo.Controller;


import com.backend.bt.demo.Modele.Recipe;
import com.backend.bt.demo.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "recipes", method = RequestMethod.GET)
    public List<Recipe> listRecipes(){
        List<Recipe> listRecipes=recipeService.listRecipes();
        return listRecipes;

    }



    @PostMapping(value="/saveRecipe")
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe theRecipe){
        Recipe newRecipe=recipeService.saveRecipe(theRecipe);
        return new ResponseEntity<Recipe>(newRecipe, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/recipe/{id}",method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id){
        Recipe theRecipe= recipeService.get(id);
        return ResponseEntity.ok(theRecipe);

    }

    @PutMapping("/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe (@PathVariable int id, @RequestBody Recipe recipe){
        Recipe recipe1=recipeService.get(id);
        recipe1.setChef_name(recipe.getChef_name());
        recipe1.setDescription(recipe.getDescription());
        recipe1.setKey_words(recipe.getKey_words());
        recipe1.setName(recipe.getName());
        Recipe updatedRecipe=recipeService.saveRecipe(recipe1);
        return ResponseEntity.ok(updatedRecipe);

    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteRecipe(@PathVariable int id){
        Recipe recipe=recipeService.get(id);
        recipeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
