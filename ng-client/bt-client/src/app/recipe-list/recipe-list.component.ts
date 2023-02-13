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
  strVar: string;
  user: string;
  session: Storage;
  constructor(private recipeService: RecipeService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.session=this.sessionStorage;
    this.user=this.session.getItem('loggedUser');
    console.log(this.user);


  }

  reloadData() {
    
     this.recipeService.getRecipesList().subscribe(data => {
      this.recipes = data;});
  
  }

  recipeDetails(id: number){
    this.router.navigate(['recipe-details',id])
  }

  recipeUpdate(id: number){
this.router.navigate(['update-recipe',id])
  } 

  recipeDelete(id: number){
    this.recipeService.deleteRecipe(id).subscribe(data1 =>{
      this.strVar=data1;
      this.reloadData();
    });
    }

  get sessionStorage() {
    return sessionStorage;
}
recipeComment(id: number){
this.router.navigate([`recipe/${id}/create-comment`]);
}
}
