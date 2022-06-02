import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Weather } from './weather';

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

    // Communicating between backed and frontend using HTTP
    // receive a  message from backend
    public getMessage(): Observable<string>{
        return this.http.get<string> (`${this.apiServerUrl}/getMessage`,this.httpOptions);
      }
    // request a weather from backend, supply with the zipcode that user input
    public getWeather(zipcode : string): Observable<Weather>{
      return this.http.get<Weather>(`${this.apiServerUrl}/getWeather/${zipcode}`,this.httpOptions)
    }
    public getWeatherApi(lat : number ,lon : number): Observable<Response>{
      return this.http.get<Response>(`${this.apiServerUrl}/getWeatherApi/lat={lat}&lon={lon}`,this.httpOptions)
    }


    

  }