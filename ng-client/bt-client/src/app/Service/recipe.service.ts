import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Ingredient } from "../Modele/ingredient";

@Injectable({
    providedIn: 'root'
  })
export class RecipeService{

    private baseUrlRecipes = 'http://localhost:8082/recipes';
    private baseUrlRecipe = 'http://localhost:8082/recipe';
    private baseUrlRecipeSearch = 'http://localhost:8082/recipesByIngredients';



    constructor(private http: HttpClient) {}
    getRecipesList(): Observable <any>{
        return this.http.get(`${this.baseUrlRecipes}`)
    }

    getRecipe(id: number): Observable < Object > {
        return this.http.get(`${this.baseUrlRecipe}/${id}`);
      }
    
      createRecipe(recipe: Object): Observable < Object > {
        return this.http.post(`http://localhost:8082/saveRecipe`, recipe,{withCredentials: true});
      }
    
      updateRecipe(id: number, value: any): Observable < Object > {
        return this.http.put(`${this.baseUrlRecipe}/${id}`, value);
      }
    
      deleteRecipe(id: number): Observable < any > {
        return this.http.delete(`${this.baseUrlRecipe}/${id}`, {
          responseType: 'text'
        });
      }

      getRecipeIngredients(id : number): Observable < any > {
        return this.http.get(`${this.baseUrlRecipe}/${id}/ingredients`);
      }

      getRecipesByIgdts(ingredients: number[]): Observable <any >{
        return this.http.get(`${this.baseUrlRecipeSearch}?ingredients_id=${ingredients}`,{withCredentials: true});

      }
    
}