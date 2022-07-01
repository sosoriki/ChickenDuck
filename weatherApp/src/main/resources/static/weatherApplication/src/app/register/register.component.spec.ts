import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app-routing.module';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';

import { RegisterComponent } from './register.component';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        RegisterComponent,
     
         
      ],
      imports: [
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
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('username field validity', () => {
    let username = component.registerForm.controls['username'];
    expect(username.valid).toBeFalsy();
    username.setValue('Bob');
    expect(username.valid).toBeTruthy();
  });

  it('password field validity', () => {
    let password = component.registerForm.controls['password'];
    expect(password.valid).toBeFalsy();
    //password needs to be length of 6+
    password.setValue('123');
    expect(password.valid).toBeFalsy();
    //true because password is length of 6
    password.setValue('123456');
    expect(password.valid).toBeTruthy();
  });

  it('security question field validity', () => {
    let answer = component.registerForm.controls['answer'];
    expect(answer.valid).toBeFalsy();
    answer.setValue('Bob');
    expect(answer.valid).toBeTruthy();
  });

  it('registering user', () => {
    expect(component.registerForm.valid).toBeFalsy();
    component.registerForm.controls['username'].setValue("bob");
    component.registerForm.controls['password'].setValue("bobspassword");
    expect(component.registerForm.valid).toBeFalsy();
    component.registerForm.controls['answer'].setValue("banana");
    expect(component.registerForm.valid).toBeTruthy();
  });

});
