import { Component, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './Service/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(private userService: UserService, private router : Router){}

  ngOnInit(): void {
    this.router.navigate(['login'])

  }
  
  userlogout(){
    this.userService.logout().subscribe(value => {
      const submit = value
      console.log(submit)});
    this.router.navigate(['login'])
  }
}
