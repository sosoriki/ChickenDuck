import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from './weather.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public weather!: string;
  constructor(private weatherService: WeatherService) { }
  ngOnInit(){
    this.getWeather();
  }
  public getWeather(): void {
    this.weatherService.getWeather().subscribe(
    (response: any) =>{
      this.weather = response;
    },(error: HttpErrorResponse) => {
      alert(error.message)
    }

  );
}


}


