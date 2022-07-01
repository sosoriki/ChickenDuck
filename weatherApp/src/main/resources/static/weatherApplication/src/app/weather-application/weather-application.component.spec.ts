import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatExpansionModule } from '@angular/material/expansion';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { ErrorComponent } from '../error/error.component';
import { ForgotComponent } from '../forgot/forgot.component';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { MenuComponent } from '../menu/menu.component';
import { ProfileComponent } from '../profile/profile.component';
import { RegisterComponent } from '../register/register.component';

import { WeatherApplicationComponent } from './weather-application.component';

describe('WeatherApplicationComponent', () => {
  let component: WeatherApplicationComponent;
  let fixture: ComponentFixture<WeatherApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeatherApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
