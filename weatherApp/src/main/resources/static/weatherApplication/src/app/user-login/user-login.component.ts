import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  
  user: User = new User();

  constructor(private loginService: LoginService) {
    
  }

  ngOnInit(): void {
  }

  userLogin(){
    console.log(this.user)
    this.loginService.loginUser(this.user).subscribe(data=>{
      alert("Logged in successfully");
    },error=> alert("Account does not exist!"));
  }

}
