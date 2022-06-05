import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Weather } from './weather';
import { Forecast } from './forecast';

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
      } )
    };

    // Communicating between backed and frontend using HTTP
    // receive a  message from backend
    public getMessage(){
        return this.http.get (`${this.apiServerUrl}/getMessage`,{responseType: 'text'});
      }
      
    // request a weather from backend, address can be either{cityname,state} or {cityname}.
    public getWeather(address : string): Observable<Weather>{
      return this.http.get<Weather>(`${this.apiServerUrl}/getWeather/location/${address}`,this.httpOptions)
    }

    public getForecast(address : string): Observable<Forecast[]>{
      return this.http.get<Forecast[]>(`${this.apiServerUrl}/getForecast/location/${address}`,this.httpOptions)
    }



    

  }