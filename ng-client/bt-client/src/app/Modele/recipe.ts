import { Ingredient } from "./ingredient";
import { User } from "./user";

export class Recipe{
    id: number;
    name: string;
    description: string;
    chef: User[];
    ingredients: Ingredient[]


}