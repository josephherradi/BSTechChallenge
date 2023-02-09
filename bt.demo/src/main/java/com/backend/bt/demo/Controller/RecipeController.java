package com.backend.bt.demo.Controller;


import com.backend.bt.demo.Controller.exceptions.RecipeExceptions;
import com.backend.bt.demo.Modele.Recipe;
import com.backend.bt.demo.Modele.User;
import com.backend.bt.demo.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe theRecipe,HttpSession session, HttpServletRequest request){
        User loggedUser=(User) request.getSession().getAttribute("theUser");
        theRecipe.setChef(loggedUser);
        Recipe newRecipe=recipeService.saveRecipe(theRecipe);
        return new ResponseEntity<Recipe>(newRecipe, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/recipe/{id}",method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id){
        Recipe theRecipe= recipeService.get(id);
        return ResponseEntity.ok(theRecipe);

    }

    @PutMapping("/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe (@PathVariable int id, @RequestBody Recipe recipe, HttpSession session, HttpServletRequest request){
        User loggedUser=(User) request.getSession().getAttribute("theUser");

        Recipe recipe1=recipeService.get(id);
        String chefName=recipe1.getChef().getName();
        System.out.println(chefName +" is chef /"+ loggedUser.getName() +"is connected user");

        if(loggedUser.getName().equalsIgnoreCase(chefName)){
            recipe1.setDescription(recipe.getDescription());
            recipe1.setIngredients(recipe.getIngredients());
            recipe1.setName(recipe.getName());
            Recipe updatedRecipe=recipeService.saveRecipe(recipe1);
            return ResponseEntity.ok(updatedRecipe);
        } else {
                throw new RecipeExceptions("modification possible uniquement par le rédacteur");

        }

    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteRecipe(@PathVariable int id, HttpSession session, HttpServletRequest request){
        User loggedUser=(User) request.getSession().getAttribute("theUser");

        Recipe recipe=recipeService.get(id);
        String chefName=recipe.getChef().getName();

        if(loggedUser.getName().equalsIgnoreCase(chefName)) {
            recipeService.delete(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } else {
            throw new RecipeExceptions("modification possible uniquement par le rédacteur");
        }

    }

}
