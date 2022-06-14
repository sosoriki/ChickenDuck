import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
import { UserLoginComponent } from './user-login/user-login.component';//google place api autocomplete


@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    GooglePlaceModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
