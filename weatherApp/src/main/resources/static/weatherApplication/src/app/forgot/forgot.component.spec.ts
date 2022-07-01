import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { HttpInterceptorService } from '../HttpInterceptorService';
import { LoginComponent } from '../login/login.component';

import { ForgotComponent } from './forgot.component';

describe('ForgotComponent', () => {
  let component: ForgotComponent;
  let fixture: ComponentFixture<ForgotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        ForgotComponent,
     
         
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
    fixture = TestBed.createComponent(ForgotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
