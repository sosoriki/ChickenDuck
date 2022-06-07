import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from './weather.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Weather } from './weather';
import { Loader } from '@googlemaps/js-api-loader';


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
  public address: string = "";
  public formdata: any;
  public weather!: Weather;
  public weathers !: Weather[];
  public condition!: string;
  public temp!: number;
  public description!: string;
  public receivedInput:boolean = false;
 

  //goolge place api autocomplete
  title = 'google-places-autocomplete';
  userAddress: string = ''
  userLatitude: string = ''
  userLongitude: string = ''
  
  handleAddressChange(address: any) {
    this.userAddress = address.formatted_address
    this.userLatitude = address.geometry.location.lat()
    this.userLongitude = address.geometry.location.lng()
    this.getWeather(this.userAddress);
    this.receivedInput=true;
    let loader = new Loader({
      apiKey:'AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI' 
    })
    loader.load().then(() =>{
      new google.maps.Map(document.getElementById("map")as HTMLElement,{
      center:  {lat: parseFloat(this.userLatitude), lng : parseFloat(this.userLongitude)},
      zoom:8,
      styles:[
        {
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#ebe3cd"
            }
          ]
        },
        {
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#523735"
            }
          ]
        },
        {
          "elementType": "labels.text.stroke",
          "stylers": [
            {
              "color": "#f5f1e6"
            }
          ]
        },
        {
          "featureType": "administrative",
          "elementType": "geometry.stroke",
          "stylers": [
            {
              "color": "#c9b2a6"
            }
          ]
        },
        {
          "featureType": "administrative.land_parcel",
          "elementType": "geometry.stroke",
          "stylers": [
            {
              "color": "#dcd2be"
            }
          ]
        },
        {
          "featureType": "administrative.land_parcel",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#ae9e90"
            }
          ]
        },
        {
          "featureType": "landscape.natural",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#dfd2ae"
            }
          ]
        },
        {
          "featureType": "poi",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#dfd2ae"
            }
          ]
        },
        {
          "featureType": "poi",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#93817c"
            }
          ]
        },
        {
          "featureType": "poi.park",
          "elementType": "geometry.fill",
          "stylers": [
            {
              "color": "#a5b076"
            }
          ]
        },
        {
          "featureType": "poi.park",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#447530"
            }
          ]
        },
        {
          "featureType": "road",
          "stylers": [
            {
              "visibility": "off"
            }
          ]
        },
        {
          "featureType": "road",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#f5f1e6"
            }
          ]
        },
        {
          "featureType": "road.arterial",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#fdfcf8"
            }
          ]
        },
        {
          "featureType": "road.highway",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#f8c967"
            }
          ]
        },
        {
          "featureType": "road.highway",
          "elementType": "geometry.stroke",
          "stylers": [
            {
              "color": "#e9bc62"
            }
          ]
        },
        {
          "featureType": "road.highway.controlled_access",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#e98d58"
            }
          ]
        },
        {
          "featureType": "road.highway.controlled_access",
          "elementType": "geometry.stroke",
          "stylers": [
            {
              "color": "#db8555"
            }
          ]
        },
        {
          "featureType": "road.local",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#806b63"
            }
          ]
        },
        {
          "featureType": "transit.line",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#dfd2ae"
            }
          ]
        },
        {
          "featureType": "transit.line",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#8f7d77"
            }
          ]
        },
        {
          "featureType": "transit.line",
          "elementType": "labels.text.stroke",
          "stylers": [
            {
              "color": "#ebe3cd"
            }
          ]
        },
        {
          "featureType": "transit.station",
          "elementType": "geometry",
          "stylers": [
            {
              "color": "#dfd2ae"
            }
          ]
        },
        {
          "featureType": "water",
          "elementType": "geometry.fill",
          "stylers": [
            {
              "color": "#b9d3c2"
            }
          ]
        },
        {
          "featureType": "water",
          "elementType": "labels.text.fill",
          "stylers": [
            {
              "color": "#92998d"
            }
          ]
        }
      ]
       
      })
      

    })
  }

  constructor(private weatherService: WeatherService) { }
  // A lifecycle hook that is called after Angular has initialized
  // all data-bound properties of a directive
  ngOnInit(): void{
    // let loader = new Loader({
    //   apiKey:'AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI' 
    // })
    // loader.load().then(() =>{
    //   new google.maps.Map(document.getElementById("map")as HTMLElement,{
    //   center:  {lat: 0, lng :0},
    //   zoom:11
    //   })
      

    // })
  
  }
  //this.getMessage();
  //   this.formdata = new FormGroup({
  //     address: new FormControl(""),
  //  });
 

 


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
// // send cityname to backend and request a weather back
//   public getWeather(address : string): void {
//     this.weatherService.getWeather(address).subscribe(
//       (response: Weather) =>{
//         this.weather = response;
//       },(error: HttpErrorResponse)=>{
//         alert(error.message)
//       }
//     );
//   }


// 
save(event:any) {
  this.getWeather(event.target.value);
  this.receivedInput=true;
  console.log("You entered: ", event.target.value);
}
// send cityname to backend and request a weather back
public getWeather(userAddress : string): void {
  this.weatherService.getWeather(userAddress).subscribe(
    (response: Weather) =>{
      this.weather = response;
    },(error: HttpErrorResponse)=>{
      alert(error.message)
    }
  );
}


}



