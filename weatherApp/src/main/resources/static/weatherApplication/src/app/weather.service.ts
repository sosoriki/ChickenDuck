import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Weather } from './weather';
import { Forecast } from './forecast';
import { AuthenticationService } from './login/auth.service';


@Injectable({
    providedIn: 'root'
  })
  export class WeatherService{
    // apiBaseUrl is defined in enviroment.ts
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient,
      private authenticationService: AuthenticationService
  
     ) {   }
    // // 
    // httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //     'Authorization': `Basic ${window.btoa(this.authenticationService.username + ":" + this.authenticationService.password)}`
    //   } )
    // };

    // Communicating between backed and frontend using HTTP
    // receive a  message from backend
    public getMessage(){
        return this.http.get (`${this.apiServerUrl}/getMessage`,{responseType: 'text'});
      }
      
    // request a weather from backend, address can be either{cityname,state} or {cityname}.
    public getWeather(address : string): Observable<Weather>{
      return this.http.get<Weather>(`${this.apiServerUrl}/getWeather/location/${address}`)
    }

    public getForecast(address : string): Observable<Forecast[]>{
      return this.http.get<Forecast[]>(`${this.apiServerUrl}/getForecast/location/${address}`,{responseType: 'json'});
    }

 
    public getAddress(username: string){
      return this.http.get(`${this.apiServerUrl}/getAddress/${username}`,{responseType: 'text'});
    }

  }