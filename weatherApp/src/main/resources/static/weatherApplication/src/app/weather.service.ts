import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })
  export class WeatherService{
    // apiBaseUrl is defined in enviroment.ts
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient) { }
    // 
    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        "Access-Control-Allow-Origin": "*",
        
      } ),responseType: 'text' as 'json'
    };
    // Communicating with backed services using HTTP
    public getWeather(): Observable<string>{
        return this.http.get<string> (`${this.apiServerUrl}/weather/getWeather`,this.httpOptions);
      }
    

  }