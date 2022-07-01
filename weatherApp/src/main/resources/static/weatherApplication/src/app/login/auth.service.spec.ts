import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpInterceptorService } from '../HttpInterceptorService';

import { AuthenticationService } from './auth.service';
import { LoginComponent } from './login.component';

describe('AuthService', () => {
  let service: AuthenticationService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
      ],
      imports: [
        HttpClientModule,
    
         
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
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
