import { Component, Input, OnInit, Output } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './auth.service';
import { User } from '../user';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'], 
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

  onSubmit(): void{
    console.log("button works");
    console.log(this.loginForm.value.username);
    console.log(this.loginForm.value.password);
    this.authenticationService.authenticationService(this.loginForm.value.username, this.loginForm.value.password).subscribe((result)=> {
    console.log("Success");
    this.router.navigate(['/main']);
    }, (error) => {
     console.log("Failed");
    }); 
  }
  

}

