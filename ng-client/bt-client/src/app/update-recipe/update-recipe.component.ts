import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Ingredient } from '../Modele/ingredient';
import { Recipe } from '../Modele/recipe';
import { IngredientService } from '../Service/ingredient.service';
import { RecipeService } from '../Service/recipe.service';

@Component({
  selector: 'app-update-recipe',
  templateUrl: './update-recipe.component.html',
  styleUrls: ['./update-recipe.component.css']
})
export class UpdateRecipeComponent implements OnInit {
id: number;
recipe: Recipe=new Recipe();
ingredients: Observable<Ingredient[]>;
  
submitted = false;
dropdownList = [];
selectedItems = [];
dropdownSettings = {};

form: FormGroup;

constructor(private recipeService: RecipeService, private route :ActivatedRoute,private ingredientService: IngredientService, private router: Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {

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
      name:[null,  [Validators.required, Validators.minLength(1)]],
      description:[null,  [Validators.required, Validators.minLength(1)]],
      ingredients: [null, [Validators.required]],
      imageURL:[null,  [Validators.required, Validators.minLength(0)]]
    });
       

this.id=this.route.snapshot.params['id'];
this.recipeService.getRecipe(this.id).subscribe(data => {
  this.recipe = data;});

  }

  onSubmit(){
    console.log(this.recipe.imageURL)
    this.recipeService.updateRecipe(this.id,this.recipe).subscribe(data =>{
      this.router.navigate(['recipes']);
    }

    )
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

}
