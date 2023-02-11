import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { IngredientListComponent } from './ingredient-list/ingredient-list.component';
import { RecipeDetailsComponent } from './recipe-details/recipe-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateRecipeComponent } from './create-recipe/create-recipe.component';
import { AppRoutingModule } from './app.routing.module';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    RecipeListComponent,
    IngredientListComponent,
    RecipeDetailsComponent,
    CreateRecipeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,ReactiveFormsModule  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
