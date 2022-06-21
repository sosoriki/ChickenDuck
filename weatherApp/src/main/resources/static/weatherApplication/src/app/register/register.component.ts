import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { RegisterService } from './register.service';

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
  ) { }

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
    this.user = new User(this.registerForm.value.username, this.registerForm.value.password);
    this.register.registerUser(this.user).subscribe(result => {
      this.loading = true;
      alert("User registered. Please Log in.");
      this.router.navigate(['']);
      console.log("Successful register");
    }, (error) => {
      console.log("Failed register");
    })
  }

}
