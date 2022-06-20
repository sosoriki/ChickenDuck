import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './auth.service';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  errorMessage = 'Invalid Credentials';
  successMessage!: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
    ) { }


    ngOnInit(): void {
      this.initializeForm();
    }
 
  //ngForm stuff
  loginForm!: FormGroup;
  initializeForm():void{
    this.loginForm = this.fb.group({
      username: '',
      password: ''
    })
  }
  display():void{
    console.log("clicked");
  }
  onSubmit(): void{
    this.authenticationService.authenticationService(this.loginForm.value.username, this.loginForm.value.password).subscribe((result)=> {
    this.invalidLogin = false;
    this.loginSuccess = true;
    this.successMessage = 'Login Successful.';
    this.router.navigate(['/main']);
      console.log("Success");
    }, (error) => {
     console.log("Failed");
    }); 
  } 
  //  onSubmit():void{
  //   console.log("button works");
  //   console.log("username is: ",this.loginForm.value.username);
  //   console.log("passwowrd is: ",this.loginForm.value.password);
    // this.authenticationService.authenticationService(this.loginForm.value.username, this.loginForm.value.password).subscribe((result)=> {
    //   this.invalidLogin = false;
    //   this.loginSuccess = true;
    //   this.successMessage = 'Login Successful.';
    //   console.log("Success");
    //   this.router.navigate(['/second']);
  //   }, () => {
  //     // this.invalidLogin = true;
  //     // this.loginSuccess = false;
  //     console.log("Failed");
  //   // }); 
  //  }
  // // handleLogin(){
  //   this.username = this.user.username;
  //   this.password = this.user.password;
  //   console.log("entered username:",this.user.username);
  //   console.log("entered password:",this.user.password);
  //   this.authenticationService.authenticationService(this.username, this.password).subscribe((result)=> {
  //     this.invalidLogin = false;
  //     this.loginSuccess = true;
  //     this.successMessage = 'Login Successful.';
  //     this.router.navigate(['/second']);
  //   }, () => {
  //     this.invalidLogin = true;
  //     this.loginSuccess = false;
  //   }); 



}
