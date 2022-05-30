import { HttpClient } from '@angular/common/http';
import {enableProdMode, Injectable} from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';


import { AppModule } from './app/app.module';
import { environment } from './environments/environment';



@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  rootURL = 'http://localhost:8080/';

  getWeather() {
    return this.http.get(this.rootURL + '/weather');
  }
  //
  // addUser(user: any) {
  //   return this.http.post(this.rootURL + '/user', {user});
  // }

}

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
