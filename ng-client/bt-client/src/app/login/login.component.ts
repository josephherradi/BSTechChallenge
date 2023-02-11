import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  identifiant: string;
  password: string;
  constructor(private userService : UserService, private router: Router) { }

  ngOnInit(): void {

  }
userlogin(){
  this.userService.login(this.identifiant,this.password);
}
onSubmit(){
  this.userlogin();
  this.router.navigate(['recipes']);
}
}
