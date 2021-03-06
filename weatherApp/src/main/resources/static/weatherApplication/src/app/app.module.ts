import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
import { LoginComponent } from './login/login.component';//google place api autocomplete 
import { AppRoutingModule } from './app-routing.module';
import { HttpInterceptorService } from './HttpInterceptorService';
import { MenuComponent } from './menu/menu.component';
import { WeatherApplicationComponent } from './weather-application/weather-application.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { ErrorComponent } from './error/error.component';
import { ProfileComponent } from './profile/profile.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { ForgotComponent } from './forgot/forgot.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// npm i mdb-angular-ui-kit
// npm install angular-bootstrap-md --save
// ng add @angular/material

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    WeatherApplicationComponent,
    LogoutComponent,
    RegisterComponent,
    ErrorComponent,
    ProfileComponent,
    ForgotComponent,
 
     
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    GooglePlaceModule,
    AppRoutingModule,
    MDBBootstrapModule,
    MatButtonToggleModule,
    MatExpansionModule,
    BrowserAnimationsModule,

     
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true
  },LoginComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
