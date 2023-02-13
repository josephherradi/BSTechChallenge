import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class UserService{
    private baseUrl = 'http://localhost:8082';



    constructor(private http: HttpClient) {}

    login(identifiant1: string, password1: string): Observable < any >  {
        return this.http.post(`${this.baseUrl}/login?identifiant=${identifiant1}&password=${password1}`,{withCredentials: true});

        }
    

    logout(): Observable <any> {
        return this.http.get(`${this.baseUrl}/logout`)


    }

    getUsersList(): Observable <any>{
        return this.http.get(`${this.baseUrl}/users-list`)
    }

    createUser(user: Object): Observable <Object>{
        return this.http.post(`http://localhost:8082/saveUser`, user,{withCredentials: true});
    }


}