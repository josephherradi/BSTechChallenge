import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingredient } from '../Modele/ingredient';
import { IngredientService } from '../Service/ingredient.service';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent implements OnInit {
ingredients: Ingredient[];
  constructor(private ingredientService: IngredientService) { }

  ngOnInit() {
    this.getDataList();
  }

  getDataList(){
    this.ingredientService.getIngredientsList().subscribe(data => {
      this.ingredients = data;});
  }

}
