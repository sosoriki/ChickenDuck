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
  //! postfix operator to the variable name can used to ingore initialization
  //or we can go to tsconfig.json set "strictPropertyInitialization": false 
  public message: string = "";
  public formdata: any;
  public zipcode!:string;
  public weather !: Weather;
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
        console.log(response);
      },(error: HttpErrorResponse)=>{
        alert(error.message)
      }
    );
  }


// Button onclick event
onclickSubmit(data: { zipcode: string; }): void{
  this.zipcode = data.zipcode;
  //invoke the get method
  this.getWeather(this.zipcode);
  console.log(data.zipcode)}

}



