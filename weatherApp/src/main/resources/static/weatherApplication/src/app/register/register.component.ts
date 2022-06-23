import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { RegisterService } from './register.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  submitted = false;
  loading = false;
  user!: User;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    public register: RegisterService
  ) { 
    this.user = {
      username:'',
      password:''
    };
  }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm():void{
    this.registerForm = this.fb.group({
      username: ['',[Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }

  get username(){ 
    return this.registerForm.get('username');
  }

  get password(){ 
    return this.registerForm.get('password');
  }

  submitRegister(){
    this.submitted = true;
    console.log(this.registerForm.value.username);
    console.log(this.registerForm.value.password);
    if(this.registerForm.invalid){
      return;
    }
    this.user.username = this.registerForm.value.username;
    this.user.password = this.registerForm.value.password;
    this.register.registerUser(this.user).subscribe(result => {
      this.loading = true;
      //dialog box: register alert 
      Swal.fire({
        title: 'SUCCESS',
        text: 'User registered. Please Log in.',
        icon: 'success',
        showCancelButton: true,
        confirmButtonText: 'Yes, login!',
      }).then((result) => {
        if (result.isConfirmed) {
          console.log('Yes! ');
          this.router.navigate(['']);
        }
      })  ;
    }, (error: HttpErrorResponse) => {
      console.log("Failed register");
      alert(error.message);
    })
  }

 
}
