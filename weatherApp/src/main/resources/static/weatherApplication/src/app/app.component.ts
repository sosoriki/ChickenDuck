import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from './weather.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Weather } from './weather';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  //If we dont want to initialize a variable:
  //1)! postfix operator to the variable name can used to ingore initialization
  //2)or we can go to tsconfig.json set "strictPropertyInitialization": false 
  public message: string = "";
  public zipcode: string = "";
  public formdata: any;
  public weather!: Weather;
  public result!: Response;
  constructor(private weatherService: WeatherService) { }
  // A lifecycle hook that is called after Angular has initialized
  // all data-bound properties of a directive
  ngOnInit(){
    this.getMessage();
    this.formdata = new FormGroup({
      zipcode: new FormControl(""),
   });
  
 
  }

  // get a simple message from backend
  public getMessage(): void {
    this.weatherService.getMessage().subscribe(
    (response: any) =>{
      this.message = response;
      console.log(this.message);
    },(error: HttpErrorResponse) => {
      alert(error.message)
    }

  );
}
// send zipcode to backend and request a weather back
  public getWeather(zipcode : string): void {
    this.weatherService.getWeather(zipcode).subscribe(
      (response: Weather) =>{
        this.weather = response;

      },(error: HttpErrorResponse)=>{
        alert(error.message)
      }
    );
  }
  public getWeatherApi(lat:number, lon:number): void {
    this.weatherService.getWeatherApi(lat,lon).subscribe(
      (response: Response) =>{
        this.result = response;
   
      },(error: HttpErrorResponse)=>{
        alert(error.message)
      }
    );
  }

// Button onclick event
onclickSubmit(data: { zipcode: string; }): void{
  this.zipcode = data.zipcode;

  //invoke the get method
  this.getWeather(data.zipcode);
}
onclickSubmit2(): void{
  //invoke the get method
  //this.getWeatherApi(data.lat,data.lon);

}

}



