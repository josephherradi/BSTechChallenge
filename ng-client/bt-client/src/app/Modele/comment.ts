import { Recipe } from "./recipe";
import { User } from "./user";

export class Comment{
    id: number;
    recipe: Recipe[];
    User: User[];
    text: string;
}