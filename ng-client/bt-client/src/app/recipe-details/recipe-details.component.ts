import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ingredient } from '../Modele/ingredient';
import { Recipe } from '../Modele/recipe';
import { RecipeService } from '../Service/recipe.service';
import {Location} from '@angular/common';
import { CommentService } from '../Service/comment.service';


@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  id: number
  ingredients: Ingredient[]
  recipe: Recipe=new Recipe();
  comment: any;
  comments: any;

  constructor(private route: ActivatedRoute, private recipeService: RecipeService, private router: Router, private _location: Location , private commentService: CommentService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  back(): void {
    this._location.back();
    this.reloadData();
    
  
  }

  reloadData(){
    this.id = this.route.snapshot.params['id'];
    this.recipeService.getRecipeIngredients(this.id).subscribe(data =>{
      this.ingredients=data;
    })
    this.recipeService.getRecipe(this.id).subscribe(data0=>{
      this.recipe=data0;
    })
  this.getComments(this.id);
  }
  getComments(id:number){
    this.commentService.getCommentsByRecipe(this.id).subscribe(data1=>{
      this.comments=data1;
    })

  }
  
}
