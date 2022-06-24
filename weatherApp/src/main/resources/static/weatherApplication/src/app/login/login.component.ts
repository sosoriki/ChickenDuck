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
  showErrorMessage = false;
  islogin = false;
  loggedInUsername = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }


  ngOnInit(): void {
    if (this.authenticationService.isUserLoggedIn() == true) {
      this.islogin = true;

    }
    this.initializeForm();
  }

  //ngForm stuff
  loginForm!: FormGroup;
  initializeForm(): void {
    this.loginForm = this.fb.group({
      username: '',
      password: '',
    })
  }
  display(): void {
    console.log("clicked");
  }

  getLoggedUsername(){
    return this.loggedInUsername;
  }

  onSubmit(): void {
    this.authenticationService.authenticationService(this.loginForm.value.username, this.loginForm.value.password).subscribe((result) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.loggedInUsername = this.loginForm.value.username;
      this.successMessage = 'Login Successful.';
      this.router.navigate(['/main']);
      console.log("Success");
    }, (error) => {
      console.log("Failed");
      this.showErrorMessage = true
    });
  }

  handleLogout() {
    this.authenticationService.logout();
    this.router.navigate(['/logout']);
  }

}
