import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ForgotService } from '../forgot/forgot.service';
import { AuthenticationService } from '../login/auth.service';
import { RegisterService } from '../register/register.service';
import { User } from '../user'; 
import { Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  invalidLocation: boolean = false;
  userAddress: string = '';
  public showChangePassword: boolean = false;
  public showUpdateAddress: boolean = false;
  public buttonName_address: any = 'Update Address';
  public buttonName_password: any = 'Change Password';
  user!: User;
  submitted = false;
  
  constructor(private fb: FormBuilder, 
    private updateAddress: RegisterService,
    private auth: AuthenticationService,
    private passwordService: ForgotService,
    private authenticationService: AuthenticationService,
    private router: Router,
 
    ) {
      this.user = {
        username:'',
        password:'',
        answer: '',
        address:'',
      };
     }
  
  ngOnInit(): void {
    if (this.authenticationService.isUserLoggedIn() == false) {
      this.router.navigate(['/error']);
    }
    this.initializeForm();
  }

  infoForm!: FormGroup;
  passwordForm!: FormGroup;
  initializeForm(): void {
    this.infoForm = this.fb.group({
      userAddress: ""
    })
    this.passwordForm = this.fb.group({
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
    })
  }
  handleAddressChange = async (address: any) => {
    console.log(address.formatted_address)
    this.userAddress = address.formatted_address;
    if (address.formatted_address == undefined) {
      this.invalidLocation = true;
    } else {
      this.invalidLocation = false;
    }

  }
  toggle_address() {
    this.showUpdateAddress = !this.showUpdateAddress;

    // CHANGE THE NAME OF THE BUTTON.
    if (this.showUpdateAddress)
      this.buttonName_address = "Hide";
    else
      this.buttonName_address = 'Update Address';
  }
  toggle_password() {
    this.showChangePassword = !this.showChangePassword;

    // CHANGE THE NAME OF THE BUTTON.
    if (this.showChangePassword)
      this.buttonName_password = "Hide";
    else
      this.buttonName_password = 'Change Password';
  }

  submitAddress() {
    this.user.username = this.auth.getLoggedInUserName();
    this.user.address = this.userAddress;
    console.log(this.user.username);
    console.log(this.user.address);
    this.updateAddress.registerAddress(this.user).subscribe(result => {
      console.log("Address registered!");
    },(error: HttpErrorResponse) => {
      console.log("Failed register");
      alert(error.message);
  })
  }

  get newPassword(){ 
    return this.passwordForm.get('newPassword');
  }

  onChangePassword(){
    this.submitted = true;
    if(this.passwordForm.invalid){
      return;
    }
    this.user.username = this.auth.getLoggedInUserName();
    this.user.password = this.passwordForm.value.newPassword;
    console.log(this.user.username);
    console.log(this.user.password);
    //update token
    this.passwordService.forgotPasswordNoUsername(this.user).subscribe(result => {
      this.authenticationService.logout();
      this.authenticationService.authenticationService(this.user.username, this.user.password).subscribe(result=>{
        console.log("changed");
      });
    },(error: HttpErrorResponse) => {
      console.log("wrong password");
      alert(error.message);
  })
  }

}