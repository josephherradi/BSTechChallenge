import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CreateCommentComponent } from "./create-comment/create-comment.component";
import { CreateRecipeComponent } from "./create-recipe/create-recipe.component";
import { CreateUserComponent } from "./create-user/create-user.component";
import { IngredientListComponent } from "./ingredient-list/ingredient-list.component";
import { LoginComponent } from "./login/login.component";
import { RecipeDetailsComponent } from "./recipe-details/recipe-details.component";
import { RecipeListComponent } from "./recipe-list/recipe-list.component";
import { SearchRecipeComponent } from "./search-recipe/search-recipe.component";
import { UpdateRecipeComponent } from "./update-recipe/update-recipe.component";
import { UsersListComponent } from "./users-list/users-list.component";

const routes: Routes = [
    {path: 'ingredients', component: IngredientListComponent},
    {path: 'recipes', component: RecipeListComponent},
    {path: 'recipe-details/:id', component: RecipeDetailsComponent},
    {path: 'create-recipe', component: CreateRecipeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'search-recipe', component: SearchRecipeComponent},
    {path: 'update-recipe/:id', component: UpdateRecipeComponent},
    {path: 'users', component: UsersListComponent},
    {path: 'create-user', component: CreateUserComponent},
    {path: 'recipe/:id/create-comment', component: CreateCommentComponent}



];

@NgModule({
    imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
    exports: [RouterModule]
  })
  export class AppRoutingModule {

   }
  