import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Ingredient } from '../Modele/ingredient';
import { Recipe } from '../Modele/recipe';
import { IngredientService } from '../Service/ingredient.service';
import { RecipeService } from '../Service/recipe.service';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  recipes: []
  ingredients: Observable<Ingredient[]>;
  ingredients_id=[];
  
  
  submitted = false;
  dropdownList = [];
  selectedItems= [];
  dropdownSettings = {};

  form: FormGroup;
  constructor(private recipeService: RecipeService,private ingredientService: IngredientService ,private formBuilder: FormBuilder,private router: Router) { }

  ngOnInit(){
    this.ingredientService.getIngredientsList().subscribe(ingredients =>{ 
      this.dropdownList=ingredients as Ingredient[];
    })
  
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'ingredient_id',
      textField: 'name',
      enableCheckAll: false,
      selectAllText: 'Select all',
      unSelectAllText: 'Unselect all',
      itemsShowLimit: 10,
      allowSearchFilter: true,
      searchPlaceholderText: 'Search',
    };
    this.form=this.formBuilder.group({
      ingredients: [null, [Validators.required]]
    });
       
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
  onSubmit(){
    this.submitted = true;
  console.log(this.selectedItems)
    for(let i=0;i<this.selectedItems.length;i++)
    {
this.ingredients_id.push(this.selectedItems[i].ingredient_id);
    }
  this.reloadData(this.ingredients_id);
this.recipeFound();

  }

  reloadData(ids: number[]) {
    this.recipeService.getRecipesByIgdts(ids).subscribe(data => {
     this.recipes = data;});
 }

 recipeFound(){
   this.router.navigate(['search-recipe'])
 }
 recipeDetails(id: number){
  this.router.navigate(['recipe-details',id])
}
back(): void {
  this.router.navigate([".."]);
}

}
