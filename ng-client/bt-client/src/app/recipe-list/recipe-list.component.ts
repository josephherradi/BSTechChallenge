import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Recipe } from '../Modele/recipe';
import { RecipeService } from '../Service/recipe.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe [] ;

  constructor(private recipeService: RecipeService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
     this.recipeService.getRecipesList().subscribe(data => {
      this.recipes = data;});
  
  }

  recipeDetails(id: number){
    this.router.navigate(['recipe-details',id])
  }


}
