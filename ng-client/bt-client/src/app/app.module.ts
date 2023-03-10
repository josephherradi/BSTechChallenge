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
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { SearchRecipeComponent } from './search-recipe/search-recipe.component';
import { UpdateRecipeComponent } from './update-recipe/update-recipe.component';
import { UsersListComponent } from './users-list/users-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { createComponent } from '@angular/compiler/src/core';
import { CreateCommentComponent } from './create-comment/create-comment.component';



@NgModule({
  declarations: [
    AppComponent,
    RecipeListComponent,
    IngredientListComponent,
    RecipeDetailsComponent,
    CreateRecipeComponent,
    LoginComponent,
    SearchRecipeComponent,
    UpdateRecipeComponent,
    UsersListComponent,
    CreateUserComponent,
    CreateCommentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,ReactiveFormsModule,
    NgMultiSelectDropDownModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
