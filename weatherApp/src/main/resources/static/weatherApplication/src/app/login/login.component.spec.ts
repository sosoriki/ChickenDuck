import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app-routing.module';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { User } from '../user';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        LoginComponent,
     
         
      ],
      imports: [
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        AppRoutingModule,
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
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    component.loginForm;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form invalid when empty', () => {
    expect(component.loginForm.valid).toBeFalsy();
  });

  it('username field validity', () => {
    let username = component.loginForm.controls['username'];
    expect(username.valid).toBeFalsy();
    username.setValue('Bob');
    expect(username.valid).toBeTruthy();
  });

  it('password field validity', () => {
    let password = component.loginForm.controls['password'];
    expect(password.valid).toBeFalsy();
    password.setValue('123');
    expect(password.valid).toBeTruthy();
  });

  it('logging in user', () => {
    expect(component.loginForm.valid).toBeFalsy();
    component.loginForm.controls['username'].setValue("bob");
    component.loginForm.controls['password'].setValue("bobspassword");
    expect(component.loginForm.valid).toBeTruthy();
  });

});
