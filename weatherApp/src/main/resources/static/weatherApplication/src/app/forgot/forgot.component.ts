import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { ForgotService } from './forgot.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-forgot',
  templateUrl: './forgot.component.html',
  styleUrls: ['./forgot.component.css']
})
export class ForgotComponent implements OnInit {
  forgotForm!: FormGroup;
  user!: User;
  submitted= false;

  constructor(private fb: FormBuilder,
              private forgotService: ForgotService,
              private router: Router) { 
                this.user = {
                  username:'',
                  password:'',
                  answer: '',
                  address: ''
                }
              }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.forgotForm = this.fb.group({
      username: ['',[Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      answer: ['',[Validators.required]]
    })
  }

  get username(){ 
    return this.forgotForm.get('username');
  }

  get password(){ 
    return this.forgotForm.get('password');
  }

  get answer(){ 
    return this.forgotForm.get('answer');
  }

  onSubmit(){
    this.submitted = true;
    if(this.forgotForm.invalid){
      return;
    }
    console.log(this.forgotForm.value.username);
    console.log(this.forgotForm.value.answer);
    console.log(this.forgotForm.value.password);
    this.user.username = this.forgotForm.value.username;
    this.user.password = this.forgotForm.value.password;
    this.user.answer = this.forgotForm.value.answer;
    this.forgotService.forgotPassword(this.user).subscribe(result => {
      console.log("Password Changed!");
      this.router.navigate(['']);
      Swal.fire({
        title: 'SUCCESS',
        text: 'Password Changed!',
        icon: 'success',
        confirmButtonText: 'Ok',
      }).then((result) => {
        if (result.isConfirmed) {
          this.router.navigate(['']);
        }
      })  ;
    },(error: HttpErrorResponse) => {
      Swal.fire({
        icon: 'error',
        title: 'FAIL',
        text: 'Wrong security answer/username',
        confirmButtonText: 'Ok',
      }).then((result) => {
      })  ;
      console.log("Answer Fail!");

  })
}

}
