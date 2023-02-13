import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Comment } from '../Modele/comment';
import { CommentService } from '../Service/comment.service';

@Component({
  selector: 'app-create-comment',
  templateUrl: './create-comment.component.html',
  styleUrls: ['./create-comment.component.css']
})
export class CreateCommentComponent implements OnInit {

  constructor(private route :ActivatedRoute, private router: Router, private commentService : CommentService, private formBuilder: FormBuilder) { }
id: number;
comment: Comment= new Comment();
submitted= false;
form: FormGroup;

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.form=this.formBuilder.group({
      name:[null,  [Validators.required, Validators.minLength(1)]]})

  }

  save(){
    console.log(this.comment);

    this.commentService.createComment(this.id,this.comment).subscribe(data=>console.log(data), error => console.log(error)
    )
    this.router.navigate([`recipe-details/${this.id}`])
  }

  onSubmit(){
    this.submitted=true;
    this.save();
  }

}
