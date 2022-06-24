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

  updateAddress(address: string, username: string):Observable<any>{
    return this.http.put<User>(`${this.baseUrl}/updateAddress`, username, {responseType: 'json'});
  }
  registerAddress(user: User):Observable<any>{
    return this.http.post<User>(`${this.baseUrl}/registerAddress`, user, {responseType: 'json'});
  }
  
}
