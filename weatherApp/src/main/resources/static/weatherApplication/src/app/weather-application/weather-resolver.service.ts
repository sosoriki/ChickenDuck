import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { EMPTY, map, mergeMap, Observable } from 'rxjs';
import { AuthenticationService } from "../login/auth.service"
import {WeatherService} from '../weather.service'
import { HttpErrorResponse } from '@angular/common/http';
 
@Injectable({
  providedIn: 'root'
})
export class WeatherResolverService implements Resolve<any>{
  username: any;
  address:string='';
  loginForm: any;
  message :string='';
constructor(private  authenticationService: AuthenticationService, private weatherService:WeatherService, private router: Router){}
  // : Observable<Userdata> | Promise<Userdata> | Userdata
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {     
    this.username = this.authenticationService.getLoggedInUserName();
    
      return this.weatherService.getAddress(this.username).pipe(mergeMap((res) => {
        let data : any = {}
        let params:string;
        params = res;
        data.address = res;
        console.log("res:",res);
        //user has no address in database
        if(res === ''){
           console.log("No address in database");
           data.address  = "5001 Statesman Dr, Irving, TX 75063";
           //get weather
           return this.weatherService.getWeather( data.address).pipe(map((res) => {
            data.weather = res;
              return data;} ))
        }
        else
        //user has address in database
        return this.weatherService.getWeather(params).pipe(map((res) => {
          data.weather = res;
            return data;} ))

    }))
    // Another way(example): if we don't need nested api calls.
    // let id = route.params['id'];
    // const getAddress = new Promise((resolve,reject)=>{this.weatherService.getAddress(this.username).subscribe(
    //   (res) => {
    //     resolve(res)
    //   }, (err) => {
    //     console.log('err',err);
    //   }
    // );});
    
    //   const getMessage = new Promise((resolve,reject)=> {    this.weatherService.getMessage().subscribe(
    //     (res) => {
    //       resolve(res);
    //     });
    //   });
    // return this.userdata;

    // return  Promise.all([getAddress, getMessage]);

    //nested api calls.

  }
 
}
