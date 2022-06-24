import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from '../login/auth.service';
import { RegisterService } from '../register/register.service';
import { User } from '../user';

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
  
  constructor(private fb: FormBuilder, 
    private updateAddress: RegisterService,
    private auth: AuthenticationService
    ) {
      this.user = {
        username:'',
        password:'',
        address:'',
      };
     }
  
  ngOnInit(): void {
    this.initializeForm();
  }

  infoForm!: FormGroup;
  initializeForm(): void {
    this.infoForm = this.fb.group({
      userAddress: ""
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

}