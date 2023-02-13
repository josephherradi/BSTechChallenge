import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../Modele/user';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User= new User();
  submitted=false;
  form: FormGroup;

  constructor(private userService: UserService,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      name:[null,  [Validators.required, Validators.minLength(1)]],
      role:[null,  [Validators.required, Validators.minLength(1)]],
      password: [null, [Validators.required]],
      email: [null, [Validators.required]],
    });
  }

  save(){
    console.log(this.user);
    this.userService.createUser(this.user).subscribe(data=>console.log(data), error => console.log(error))
    this.user=new User();
  }

  onSubmit(){
    this.submitted=true;
    this.save();
  }
  newUser(){
    this.submitted=false;
    this.user=new User();
  }

}
