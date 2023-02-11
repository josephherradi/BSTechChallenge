import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
export class IngredientService {

    private baseUrlIngredients = 'http://localhost:8082/ingredients';
    constructor(private http: HttpClient) {}

    getIngredientsList(): Observable <any> {
        return this.http.get(`${this.baseUrlIngredients}`)
    }
}