import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class ForgotService {

  private baseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  forgotPassword(user: User):Observable<any>{
    return this.http.put<User>(`${this.baseUrl}/forgotPassword`, user, {responseType: 'json'});
  }

  forgotPasswordNoUsername(user: User):Observable<any>{
    return this.http.put(`${this.baseUrl}/forgotPasswordNoUsername`, user, {responseType: 'json'});
  }
  
}
