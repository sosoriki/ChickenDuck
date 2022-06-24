import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
  AUTH_TOKEN : string = 'authenticatedToken';

  public username: String | null= "";
  public password: String | null= "";
  
  constructor(private http: HttpClient) {

  }

  authenticationService(username: String, password: String) {
    return this.http.get(`http://localhost:8080/api/v1/basicauth`,
      { headers: { Authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res:any) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password);
      }));
  }

  createBasicAuthToken(username: String, password: String) {
    console.log("entered username:", username);
    console.log("entered password:", password);
    return 'Basic ' + window.btoa(username + ":" + password)
  }
createAuthoTokenNoHeader(username: String, password: String){
  return  window.btoa(username + ":" + password);
}

  registerSuccessfulLogin(username:String, password:String) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME,username as string)
    sessionStorage.setItem(this.AUTH_TOKEN,this.createAuthoTokenNoHeader(username,password));//store token
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    sessionStorage.removeItem(this.AUTH_TOKEN)
    this.username = null;
    this.password = null;
    
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
  
  getAuthToken(){
    return sessionStorage.getItem(this.AUTH_TOKEN);
  }
}