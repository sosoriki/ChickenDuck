import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';

import { ProfileComponent } from './profile.component';

describe('ProfileComponent', () => {
  let component: ProfileComponent;
  let fixture: ComponentFixture<ProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        ProfileComponent,
     
         
      ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        AppRoutingModule,
    
         
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
    fixture = TestBed.createComponent(ProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('address form works', () => {
    component.infoForm.controls['userAddress'].setValue("Seattle, WA, USA");
    expect(component.infoForm.valid).toBeTruthy();
  });

  it('password form works', () => {
    expect(component.passwordForm.valid).toBeFalsy();
    component.passwordForm.controls['newPassword'].setValue("123");
    expect(component.passwordForm.valid).toBeFalsy();
    component.passwordForm.controls['newPassword'].setValue("123456");
    expect(component.passwordForm.valid).toBeTruthy();
  });

});
