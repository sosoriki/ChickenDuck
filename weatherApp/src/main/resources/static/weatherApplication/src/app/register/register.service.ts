import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private baseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  registerUser(user: User):Observable<any>{
    return this.http.post<User>(`${this.baseUrl}/registerUser`, user, {responseType: 'json'});
  }
  // registerAddress(address: string):Observable<any>{
  //   return this.http.post (`${this.baseUrl}/registerAddress`, {responseType: 'json'});
  // }
  
}
