import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })

export class CommentService{

    private baseUrl = 'http://localhost:8082';



    constructor(private http: HttpClient) {}

    createComment(id: number, value: any): Observable <Object>{
        return this.http.post(`${this.baseUrl}/recipe/${id}/saveComment`, value,{withCredentials: true});
    }

    getCommentsByRecipe(id: number ): Observable<Object> {
        return this.http.get(`${this.baseUrl}/recipe/${id}/commentsList`,{withCredentials: true});
    }


}