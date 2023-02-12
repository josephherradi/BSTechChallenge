import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable()
export class LoginComponent implements OnInit {
  identifiant: string;
  password: string;
  session: Storage;
  loggedUser: string;
  constructor(private userService : UserService, private router: Router) { }

  ngOnInit(): void {

  }
userlogin(){
  this.userService.login(this.identifiant,this.password).subscribe(value => {
    const submit = value
    console.log(submit)});
    sessionStorage.setItem('loggedUser', this.identifiant);

  }
onSubmit(){
  this.userlogin();
  this.router.navigate(['recipes']);
}


}
