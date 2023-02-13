import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Ingredient } from '../Modele/ingredient';
import { Recipe } from '../Modele/recipe';
import { IngredientService } from '../Service/ingredient.service';
import { RecipeService } from '../Service/recipe.service';

@Component({
  selector: 'app-create-recipe',
  templateUrl: './create-recipe.component.html',
  styleUrls: ['./create-recipe.component.css']
})
export class CreateRecipeComponent implements OnInit {
  recipe: Recipe = new Recipe();
  ingredients: Observable<Ingredient[]>;
  
  submitted = false;
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};

  form: FormGroup;
  session: Storage;
  user: string;


  constructor(private recipeService: RecipeService,private ingredientService: IngredientService ,private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.ingredientService.getIngredientsList().subscribe(ingredients =>{ 
      this.dropdownList=ingredients as Ingredient[];

      this.session=this.sessionStorage;
      this.user=this.session.getItem('loggedUser');
      console.log(this.user);
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
      name:[null,  [Validators.required, Validators.minLength(1)]],
      description:[null,  [Validators.required, Validators.minLength(1)]],
      ingredients: [null, [Validators.required]],
      imageURL:[null]
    });
       
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
  newRecipe(): void{
    this.submitted=false;
    this.recipe=new Recipe();
  }

  save(){
    this.recipeService.createRecipe(this.recipe).subscribe(data => 
      console.log(data), error => console.log(error));
    this.recipe = new Recipe();
  }
  onSubmit() {
    this.submitted = true;
    console.log(this.selectedItems)
    this.save();
  }
get sessionStorage() {
    return sessionStorage;
}

}
