import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../weather.service';
import { Weather } from '../weather';
import { Loader } from '@googlemaps/js-api-loader';
import { AuthenticationService } from "../login/auth.service"
import { ActivatedRoute, Router } from '@angular/router';
import { Forecast } from '../forecast';




@Component({
  selector: 'app-weather-application',
  templateUrl: './weather-application.component.html',
  styleUrls: ['./weather-application.component.css']
})
export class WeatherApplicationComponent implements OnInit {
  public message: string = "";
  public address: string = "";
  public formdata: any;
  public weather!: Weather;
  public forecast !: Forecast[];
  public slices: number[] = [];
  dayofweek!: string;
  public condition!: string;
  public temp!: any;
  public description!: string;
  public receivedInput: boolean = false;
  public conditionUrl: string = "";
  public receivedUrl: boolean = false;
  public defaultAddress: string = "";
  //goolge place api autocomplete
  userAddress: string = "";
  userLatitude!: number;
  userLongitude!: number;
  invalidLocation: boolean = false;
  loadForecest: boolean = false;
  panelOpenState = false;
  
  handleAddressChange = async (address: any) => {
    this.loadForecest=false;
    this.userAddress = address.formatted_address

    if (address.formatted_address == undefined) {
      this.invalidLocation = true;
    } else {
      this.invalidLocation = false;
    }
    this.userLatitude = address.geometry.location.lat()
    this.userLongitude = address.geometry.location.lng()
    this.getWeather(this.userAddress);
    this.getForecast(this.userAddress);

    let loader = new Loader({
      //get API key from google doc and remember to remove when push
      apiKey: 'AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI'
    })
    //add google map
    loader.load().then(() => {
      const map = new google.maps.Map(document.getElementById("map") as HTMLElement, {
        center: { lat: this.userLatitude, lng: this.userLongitude },
        zoom: 11,

        // add google map marker
      });
      new google.maps.Marker({
        position: { lat: this.userLatitude, lng: this.userLongitude },
        map,
        title: "Location",
        icon: "",
      });
    })


  }
  username: any;

  constructor(private weatherService: WeatherService, private authenticationService: AuthenticationService,
    private router: Router,private activatedRoute:ActivatedRoute) {

  }

  // A lifecycle hook that is called after Angular has initialized
  // all data-bound properties of a directive
  ngOnInit() {
     if (this.authenticationService.isUserLoggedIn() == false) {
      this.router.navigate(['/error']);
    }
    this.activatedRoute.data.subscribe((data) =>{
      console.log("I am printing out data: ",data);
      console.log("I am printing out data1: ",data['addressdata']['address']);
      console.log("I am printing out data2: ",data['addressdata']['weather']);
      this.weather = data['addressdata']['weather'];
      this.userAddress = data['addressdata']['address'];
      this.getConditionImg(this.weather);
    });
    // console.log(this.weather.latitude);
    // console.log(this.weather.longitude);
    this.getForecast(this.userAddress);

    let loader = new Loader({
      //get API key from google doc and remember to remove when push
      apiKey: 'AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI'
    })
    //add google map
    loader.load().then(() => {
      const map = new google.maps.Map(document.getElementById("map") as HTMLElement, {
        center: { lat:this.weather.latitude , lng: this.weather.longitude },
        zoom: 11,
        // add google map marker
      });
      new google.maps.Marker({
        position: { lat: this.weather.latitude, lng: this.weather.longitude },
        map,
        title: "Location",
        icon: "",
      });
    })
  }

  // get a simple message from backend
  public getMessage(): void {
    this.weatherService.getMessage().subscribe(
      (response) => {
        this.message = response;
        console.log(this.message);
      }, (error: HttpErrorResponse) => {

      }

    );
  }

  getConditionImg(weather: Weather): void {
    if (this.weather.condition == 'Clouds') this.conditionUrl = "/assets/img/cloud-bg.jpg";
    if (this.weather.condition == 'Clear') this.conditionUrl = "/assets/img/clear-bg.jpg";
    if (this.weather.condition == 'Thunderstorm') this.conditionUrl = "/assets/img/thunder-bg.jpg";
    if (this.weather.condition == 'Drizzle') this.conditionUrl = "/assets/img/rain-bg-bg.jpg";
    if (this.weather.condition == 'Rain') this.conditionUrl = "/assets/img/rain2-bg.jpg";
    if (this.weather.condition == 'Snow') this.conditionUrl = "/assets/img/snow-bg.jpg";
    if (this.weather.condition == 'Mist') this.conditionUrl = "/assets/img/Mist-bg.jpg";
    if (this.weather.condition == 'Smoke') this.conditionUrl ="/assets/img/cloud-bg.jpg";
    if (this.weather.condition == 'Haze') this.conditionUrl = "/assets/img/cloud-bg.jpg";
    if (this.weather.condition == 'Dust') this.conditionUrl = "/assets/img/cloud-bg.jpg";
    if (this.weather.condition == 'Fog') this.conditionUrl ="/assets/img/fog-bg.jpg";
    if (this.weather.condition == 'Sand') this.conditionUrl ="/assets/img/sand-bg.jpg";
    if (this.weather.condition == 'Ash') this.conditionUrl = "/assets/img/ash-bg.jpg";
    if (this.weather.condition == 'Squail') this.conditionUrl = "/assets/img/thunder-bg.jpg";
    if (this.weather.condition == 'Tornado') this.conditionUrl = "/assets/img/thunder-bg.jpg";
  }


   // send cityname to backend and request a weather back
   public getWeather(userAddress: string): void {
    this.weatherService.getWeather(userAddress).subscribe(
      (response: Weather) => {
        this.invalidLocation = false;
        this.weather = response;
        // console.log(this.weather);
        this.getConditionImg(this.weather);
      }, (error: HttpErrorResponse) => {
        this.invalidLocation = true;
      }
    );
  }

  // send cityname to backend and request a forecast back
  public getForecast(userAddress: string): void {
    this.weatherService.getForecast(userAddress).subscribe(
      (response: Forecast[]) => {
        this.forecast = response;
        let j = 0;
        this.dayofweek = response[0].dateOfWeek;
        for (let i = 0; i < response.length; i++) {
          if (response[i].dateOfWeek != this.dayofweek) {
            //keep track of the end of each day
            this.slices[j] = i;
            this.dayofweek = response[i].dateOfWeek
            j++;
          }
        }
        this.loadForecest = true;
        // for (let i = 0; i < this.slices.length; i++) {
        //   console.log(i,this.slices[i]);
        // }
      }, (error: HttpErrorResponse) => {

        alert(error.message)
      }
    );
  
  }



  public convertToC(temp: any) {
    return ((temp - 32) * (5 / 9)).toFixed(2);
  }
  public convertToMeter(mile: any) {
    return (mile * 1609.344).toFixed(2);
  }


}
