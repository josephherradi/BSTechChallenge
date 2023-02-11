import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class UserService{
    private baseUrl = 'http://localhost:8082';


    constructor(private http: HttpClient) {}

    login(identifiant1: string, password1: string): Observable < any >  {
        return this.http.post(`${this.baseUrl}/login?identifiant=${identifiant1}&password=${password1}`,{
            responseType: 'text'
          });

        }
    

    logout(): Observable <any> {
        return this.http.get(`${this.baseUrl}/logout`)

    }
}