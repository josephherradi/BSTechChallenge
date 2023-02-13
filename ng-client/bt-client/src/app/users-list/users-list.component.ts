import { Component, OnInit } from '@angular/core';
import { User } from '../Modele/user';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
users: User[];


  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.userService.getUsersList().subscribe(data =>{
      this.users=data;
    });
  }

}
