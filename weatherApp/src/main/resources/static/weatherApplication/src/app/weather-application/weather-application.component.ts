import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../weather.service';
import { Weather } from '../weather';
import { Loader } from '@googlemaps/js-api-loader';
@Component({
  selector: 'app-weather-application',
  templateUrl: './weather-application.component.html',
  styleUrls: ['./weather-application.component.css']
})
export class WeatherApplicationComponent implements OnInit {

 //If we dont want to initialize a variable:
  //1)! postfix operator to the variable name can used to ingore initialization
  //2)or we can go to tsconfig.json set "strictPropertyInitialization": false 
  public message: string = "";
  public address: string = "";
  public formdata: any;
  public weather!: Weather;
  public weathers !: Weather[];
  public condition!: string;
  public temp!: number;
  public description!: string;
  public receivedInput:boolean = false;
  public conditionUrl:string ="";
  public receivedUrl:boolean=false;
  //goolge place api autocomplete
  title = 'google-places-autocomplete';
  userAddress: string = "";
  userLatitude!: number;
  userLongitude!: number;
  teston!:boolean;
  hasResult:boolean = false;

   handleAddressChange = async (address: any) =>  {
    this.hasResult = true;
    this.userAddress = address.formatted_address
    this.userLatitude = address.geometry.location.lat()
    this.userLongitude = address.geometry.location.lng()
    this.getWeather(this.userAddress);
    
    let loader = new Loader({
      //get API key from google doc and remember to remove when push
      apiKey:'' 
    })
    //add google map
    loader.load().then(() =>{
      const map = new google.maps.Map(document.getElementById("map")as HTMLElement,{
      center:  {lat: this.userLatitude, lng : this.userLongitude},
      zoom:11,

      // add google map marker
      });
      new google.maps.Marker({
        position: {lat: this.userLatitude, lng :this.userLongitude},
        map,
        title: "Location",
        icon: "",
      });
    })
  }

  constructor(private weatherService: WeatherService) {
    

   }
  // A lifecycle hook that is called after Angular has initialized
  // all data-bound properties of a directive
   ngOnInit()  {
    //  this.getWeather("1600 Amphitheatre Parkway Mountain View, CA 94043");
    this.getWeather("5001 Statesman Dr, Irving, TX 75063");


    let loader = new Loader({
      //get API key from google doc and remember to remove when push
      apiKey:'' 
    })
    //add google map
    loader.load().then(() =>{
      const map = new google.maps.Map(document.getElementById("map")as HTMLElement,{
      center:  {lat: 32.93619290000001, lng: -97.0151767},
      zoom:11,

      // add google map marker
      });
      new google.maps.Marker({
        position: {lat: 32.93619290000001, lng: -97.0151767},
        map,
        title: "Location",
        icon: "",
      });
    })

  }
 
  // get a simple message from backend
  public getMessage(): void {
    this.weatherService.getMessage().subscribe(
    (response) =>{
      this.message = response;
      console.log(this.message);
    },(error: HttpErrorResponse) => {
      alert(error.message)
    }

  );
}
getConditionImg(weather:Weather):void{
  if(this.weather.condition=='Clouds')this.conditionUrl="https://pbs.twimg.com/media/ETtjLCrVAAYPFqv.jpg";
  if(this.weather.condition=='Clear') this.conditionUrl="https://thumbs.dreamstime.com/b/blue-sky-white-clouds-day-as-panorama-header-blue-sky-white-clouds-as-header-143601619.jpg";
  if(this.weather.condition=='Thunderstorm') this.conditionUrl="http://clipart-library.com/img/1405308.jpg";
  if(this.weather.condition=='Drizzle') this.conditionUrl="data:image/png;base64,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";
  if(this.weather.condition=='Rain') this.conditionUrl="https://images.unsplash.com/photo-1597533519581-685ea619e7a9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=749&q=80";
  if(this.weather.condition=='Snow') this.conditionUrl="https://img.lovepik.com/free_png/32/45/17/89Y58PICrXEfTYWND7eTf_PIC2018.png_860.png";
  if(this.weather.condition=='Mist') this.conditionUrl="https://cdn-icons-png.flaticon.com/512/1197/1197102.png";
  if(this.weather.condition=='Smoke') this.conditionUrl="https://thumbs.dreamstime.com/b/creative-warm-gradient-line-drawing-cartoon-smoke-cloud-original-151816264.jpg";
  if(this.weather.condition=='Haze') this.conditionUrl="https://cdn-icons-png.flaticon.com/512/1197/1197102.png";
  if(this.weather.condition=='Dust') this.conditionUrl="https://icons-for-free.com/download-icon-sand+sandstorm+storm+weather+icon-1320196636003215564_512.png";
  if(this.weather.condition=='Fog') this.conditionUrl="https://cdn-icons-png.flaticon.com/512/1197/1197102.png";
  if(this.weather.condition=='Sand') this.conditionUrl="https://icons-for-free.com/download-icon-sand+sandstorm+storm+weather+icon-1320196636003215564_512.png";
  if(this.weather.condition=='Ash') this.conditionUrl="https://icons-for-free.com/download-icon-sand+sandstorm+storm+weather+icon-1320196636003215564_512.png";
  if(this.weather.condition=='Squail') this.conditionUrl="https://st3.depositphotos.com/25280234/31824/v/950/depositphotos_318244518-stock-illustration-cute-cloud-blowing-storm-cloud.jpg?forcejpeg=true";
  if(this.weather.condition=='Tornado') this.conditionUrl="https://img.freepik.com/free-vector/cartoon-tornado-character-storm-whirlwind-twister-cyclone-hurricane-isolated-vector-funny-cute-tornado-wind-typhoon-cloud-emoji-with-face-smile-kids-cartoon-comic-weather-character_8071-10806.jpg?w=2000";
  }
save(event:any) {

  this.getWeather(event.target.value);
  this.receivedInput=true;
  console.log("You entered: ", event.target.value);
  this.userLatitude = this.weather.latitude;
  this.userLongitude = this.weather.longitude; 
  let loader = new Loader({
    //get API key from google doc and remember to remove when push
    apiKey:'AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI' 
  })
  //add google map
  loader.load().then(() =>{
    const map = new google.maps.Map(document.getElementById("map")as HTMLElement,{
    center:  {lat: this.userLatitude, lng : this.userLongitude},
    zoom:11,

    // add google map marker
    });
    new google.maps.Marker({
      position: {lat: this.userLatitude, lng :this.userLongitude},
      map,
      title: "Location",
      icon: "",
    });
  
  })
}
// send cityname to backend and request a weather back
public getWeather(userAddress : string): void {
  this.weatherService.getWeather(userAddress).subscribe(
    (response: Weather) =>{
      this.weather = response;
      // console.log(this.weather);
      this.getConditionImg(this.weather);
    },(error: HttpErrorResponse)=>{
      alert(error.message)
    }
  );
}

public convertToC(temp: any){
  return ((temp - 32) * (5/9)).toFixed(2);
}


}
