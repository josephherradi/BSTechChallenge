import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Ingredient } from '../Modele/ingredient';
import { Recipe } from '../Modele/recipe';
import { RecipeService } from '../Service/recipe.service';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  id: number
  ingredients: Ingredient[]

  constructor(private route: ActivatedRoute, private recipeService: RecipeService ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.recipeService.getRecipeIngredients(this.id).subscribe(data =>{
      this.ingredients=data;
    })
  }

}
